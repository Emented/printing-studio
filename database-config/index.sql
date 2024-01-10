CREATE INDEX IF NOT EXISTS order_status_creation_date_index ON "order"(status, creation_timestamp);

CREATE INDEX IF NOT EXISTS order_customer_id_index ON "order"(customer_id);

CREATE INDEX IF NOT EXISTS order_administrator_id_index ON "order"(customer_id);

CREATE INDEX IF NOT EXISTS material_type_status_index ON material(type, availability_status);

CREATE INDEX IF NOT EXISTS customer_user_id_index ON customer(user_id);

CREATE INDEX IF NOT EXISTS administrator_user_id_index ON administrator(user_id);

CREATE INDEX IF NOT EXISTS delivery_type_status_index ON delivery(type, status);

CREATE INDEX IF NOT EXISTS document_order_id_index ON document(order_id);

CREATE INDEX IF NOT EXISTS business_info_inn_kpp_index ON business_info(inn, kpp);
