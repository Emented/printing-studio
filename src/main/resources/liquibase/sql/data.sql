--liquibase formatted sql

--changeset ipovetin:data.create runInTransaction:true runOnChange:true
INSERT INTO order_status (value)
VALUES ('CREATED'), ('IN_PROGRESS'), ('DELIVERY'), ('CANCELLED'), ('FINISHED');

INSERT INTO delivery_status (value)
VALUES ('CREATED'), ('IN_PROGRESS'), ('FAILED'), ('FINISHED');

INSERT INTO delivery_type (value)
VALUES ('COURIER'), ('PICKUP');

INSERT INTO payment_status (value)
VALUES ('CREATED'), ('IN_PROGRESS'), ('FAILED'), ('FINISHED');

INSERT INTO payment_type (value)
VALUES ('CARD'), ('INVOICE');

INSERT INTO filament_type (value)
VALUES ('PLA'), ('ABS');

INSERT INTO availability_status (value)
VALUES ('AVAILABLE'), ('NOT_AVAILABLE'), ('SPECIAL_ORDER');

INSERT INTO document_type (value)
VALUES ('INVOICE'), ('CAST_FACTURE');

INSERT INTO print_setting (description, price, creation_timestamp, update_timestamp)
VALUES ('Быстро', 1000.00, now(), now());

INSERT INTO material (type, availability_status, stock, description, price, color, creation_timestamp, update_timestamp)
VALUES (1, 1, 10, 'Sample description', 200.00, 'Black', now(), now());
