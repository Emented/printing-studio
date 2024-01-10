-- Возвращает число заказов пользователя
CREATE OR REPLACE FUNCTION get_customer_orders_count(p_customer_id BIGINT)
    RETURNS BIGINT AS
$$
DECLARE
    v_total_orders BIGINT;
BEGIN
    SELECT COUNT(*)
    INTO v_total_orders
    FROM "order"
    WHERE customer_id = p_customer_id;

    RETURN v_total_orders;
END;
$$ LANGUAGE plpgsql;

-- Возвращает число успешных заказов пользователя
CREATE OR REPLACE FUNCTION get_customer_finished_orders_count(p_customer_id BIGINT)
    RETURNS BIGINT AS
$$
DECLARE
    v_total_orders BIGINT;
BEGIN
    SELECT COUNT(*)
    INTO v_total_orders
    FROM "order"
    WHERE customer_id = p_customer_id
      AND status = (SELECT id FROM order_status WHERE value = 'FINISHED');

    RETURN v_total_orders;
END;
$$ LANGUAGE plpgsql;

-- Возвращает общую потраченную на заказы сумму
CREATE OR REPLACE FUNCTION get_customer_finished_orders_total(p_customer_id BIGINT)
    RETURNS NUMERIC(22, 2) AS
$$
DECLARE
    v_total NUMERIC(22, 2);
BEGIN
    SELECT SUM(total_price)
    INTO v_total
    FROM "order"
    WHERE customer_id = p_customer_id
      AND status = (SELECT id FROM order_status WHERE value = 'FINISHED');

    RETURN v_total;
END;
$$ LANGUAGE plpgsql;

-- Возвращает число заказов, которые обслуживает администратор
CREATE OR REPLACE FUNCTION get_administrator_orders_count(p_administrator_id BIGINT)
    RETURNS BIGINT AS
$$
DECLARE
    v_total_orders BIGINT;
BEGIN
    SELECT COUNT(*)
    INTO v_total_orders
    FROM "order"
    WHERE administrator_id = p_administrator_id;

    RETURN v_total_orders;
END;
$$ LANGUAGE plpgsql;

-- Возвращает число заказов, над которыми в данный момент работает администратор
CREATE OR REPLACE FUNCTION get_administrator_in_progress_orders_count(p_administrator_id BIGINT)
    RETURNS BIGINT AS
$$
DECLARE
    v_total_orders BIGINT;
BEGIN
    SELECT COUNT(*)
    INTO v_total_orders
    FROM "order"
    WHERE administrator_id = p_administrator_id
      AND status = (SELECT id FROM order_status WHERE value = 'IN_PROGRESS');

    RETURN v_total_orders;
END;
$$ LANGUAGE plpgsql;

-- Возвращает число записей в таблице
CREATE OR REPLACE FUNCTION get_record_count(table_name TEXT)
    RETURNS BIGINT AS
$$
DECLARE
    record_count BIGINT;
BEGIN
    EXECUTE format('SELECT COUNT(*) FROM %I', table_name) INTO record_count;
    RETURN record_count;
END;
$$
    LANGUAGE plpgsql;

-- Возвращает сводку продаж по материалам
CREATE OR REPLACE FUNCTION get_total_sales_per_material()
    RETURNS TABLE
            (
                material_type BIGINT,
                sales_revenue NUMERIC
            )
AS
$$
BEGIN
    RETURN QUERY
        SELECT mt.value, SUM(o.quantity * m.price) as sales_revenue
        FROM "order" o
                 JOIN material m ON o.material_id = m.id
                 JOIN filament_type mt ON m.type = mt.id
        GROUP BY mt.value;
END;
$$ LANGUAGE plpgsql;

-- Возвращает сводку заказов по настройкам печати
CREATE OR REPLACE FUNCTION get_total_orders_per_settings()
    RETURNS TABLE
            (
                material_type BIGINT,
                sales_revenue NUMERIC
            )
AS
$$
BEGIN
    RETURN QUERY
        SELECT ps.description, SUM(o.quantity * ps.price) as sales_revenue
        FROM "order" o
                 JOIN print_setting ps ON o.print_setting_id = ps.id
        GROUP BY ps.description;
END;
$$ LANGUAGE plpgsql;
