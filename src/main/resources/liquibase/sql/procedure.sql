--liquibase formatted sql

--changeset ipovetin:procedures.create runInTransaction:true runOnChange:true splitStatements:false
-- Процедура для изменения статуса заказа
CREATE OR REPLACE FUNCTION set_order_status(p_order_id BIGINT, p_status VARCHAR(64))
    RETURNS VOID AS
$$
BEGIN
    UPDATE "order"
    SET status = (SELECT id FROM order_status WHERE value = p_status)
    WHERE id = p_order_id;
END;
$$  LANGUAGE plpgsql;

-- Процедура для изменения статуса доставки
CREATE OR REPLACE FUNCTION set_delivery_status(p_delivery_id BIGINT, p_status VARCHAR(64))
    RETURNS VOID AS
$$
BEGIN
    UPDATE delivery
    SET status = (SELECT id FROM delivery_status WHERE value = p_status)
    WHERE id = p_delivery_id;
END;
$$ LANGUAGE plpgsql;

-- Процедура для изменения статуса оплаты
CREATE OR REPLACE FUNCTION set_payment_status(p_payment_id BIGINT, p_status VARCHAR(64))
    RETURNS VOID AS
$$
BEGIN
    UPDATE payment
    SET status = (SELECT id FROM payment_status WHERE value = p_status)
    WHERE id = p_payment_id;
END;
$$ LANGUAGE plpgsql;

-- Процедура для изменения доступности пластика
CREATE OR REPLACE PROCEDURE set_material_availability_status(p_material_id BIGINT, p_availability_status VARCHAR(64))
    LANGUAGE plpgsql AS
$$
BEGIN
    UPDATE material
    SET availability_status = (SELECT id FROM payment_status WHERE value = p_availability_status)
    WHERE id = p_material_id;
END;
$$;

-- Создает пользователя и покупателя
CREATE OR REPLACE PROCEDURE add_customer(p_username VARCHAR, p_password_hash VARCHAR, p_name VARCHAR, p_surname VARCHAR,
                                         p_patronymic VARCHAR, p_phone VARCHAR, p_email VARCHAR)
    LANGUAGE plpgsql AS
$$
DECLARE
    current_ts timestamptz;
BEGIN
    current_ts := now();
    INSERT INTO "user" (username, password_hash, name, surname, patronymic, phone, email, address, creation_timestamp,
                        update_timestamp)
    VALUES (p_username, p_password_hash, p_name, p_surname, p_patronymic, p_phone, p_email, current_ts, current_ts);

    INSERT INTO customer (user_id, creation_timestamp, update_timestamp)
    VALUES (currval('user_id_seq'), current_ts, current_ts);
END;
$$;

-- Создает пользователя и администратора
CREATE OR REPLACE PROCEDURE add_administrator(p_username VARCHAR, p_password_hash VARCHAR, p_name VARCHAR, p_surname VARCHAR,
                                         p_patronymic VARCHAR, p_phone VARCHAR, p_email VARCHAR)
    LANGUAGE plpgsql AS
$$
DECLARE
    current_ts timestamptz;
BEGIN
    current_ts := now();
    INSERT INTO "user" (username, password_hash, name, surname, patronymic, phone, email, address, creation_timestamp,
                        update_timestamp)
    VALUES (p_username, p_password_hash, p_name, p_surname, p_patronymic, p_phone, p_email, current_ts, current_ts);

    INSERT INTO administrator (user_id, creation_timestamp, update_timestamp)
    VALUES (currval('user_id_seq'), current_ts, current_ts);
END;
$$;

