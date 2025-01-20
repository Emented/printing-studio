--liquibase formatted sql

--changeset ipovetin:triggers.create runInTransaction:true runOnChange:true splitStatements:false
-- Триггер проверяет, что у одного заказа может быть только 1 документ 1-го типа
CREATE OR REPLACE FUNCTION unique_type_order_id() RETURNS TRIGGER AS
$$
BEGIN
    IF EXISTS (SELECT 1 FROM document WHERE type = NEW.type AND order_id = NEW.order_id) THEN
        RAISE EXCEPTION 'Document type must be unique for a single order_id';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_unique_type_order_id
    BEFORE INSERT OR UPDATE
    ON document
    FOR EACH ROW
EXECUTE FUNCTION unique_type_order_id();

------------------------------------------------------------------------------------------------------------------------
-- Автоматически обновляет update_timestamp при обновлении
CREATE OR REPLACE FUNCTION update_update_timestamp() RETURNS TRIGGER AS
$$
BEGIN
    NEW.update_timestamp = now();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DO
$$
    DECLARE
        table_n text;
    BEGIN
        FOR table_n IN
            SELECT table_name FROM information_schema.columns WHERE column_name = 'update_timestamp'
            LOOP
                EXECUTE format('CREATE TRIGGER trigger_update_timestamp
                    BEFORE UPDATE ON %I
                    FOR EACH ROW EXECUTE PROCEDURE update_update_timestamp()', table_n, table_n);
            END loop;
    END;
$$ language plpgsql;

------------------------------------------------------------------------------------------------------------------------
-- Автоматически обновляет доступность материала
CREATE OR REPLACE FUNCTION update_availability_status()
    RETURNS TRIGGER AS
$$
DECLARE
BEGIN
    IF NEW.stock > 0 AND
       OLD.availability_status != (SELECT id FROM availability_status WHERE value = 'SPECIAL_ORDER') THEN
        NEW.availability_status := (SELECT id FROM availability_status WHERE value = 'AVAILABLE');
    ELSIF OLD.availability_status != (SELECT id FROM availability_status WHERE value = 'SPECIAL_ORDER') THEN
        NEW.availability_status := (SELECT id FROM availability_status WHERE value = 'NOT_AVAILABLE');
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER tr_update_availability_status
BEFORE UPDATE OF stock ON material
FOR EACH ROW
EXECUTE FUNCTION update_availability_status();
