--liquibase formatted sql

--changeset ipovetin:tables.create runInTransaction:true runOnChange:true
CREATE TABLE IF NOT EXISTS order_status
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS payment_status
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS payment_type
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS delivery_status
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS delivery_type
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS filament_type
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS availability_status
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS document_type
(
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS "user"
(
    id                 BIGSERIAL PRIMARY KEY,
    username           VARCHAR(255) NOT NULL UNIQUE,
    password_hash      VARCHAR(64)  NOT NULL,
    name               VARCHAR(255) NOT NULL,
    surname            VARCHAR(255) NOT NULL,
    patronymic         VARCHAR(255),
    phone              VARCHAR(20)  NOT NULL,
    email              VARCHAR(255) NOT NULL UNIQUE,
    address            VARCHAR(255) NOT NULL,
    creation_timestamp timestamptz  NOT NULL,
    update_timestamp   timestamptz  NOT NULL
);

CREATE TABLE IF NOT EXISTS business_info
(
    id                 BIGSERIAL PRIMARY KEY,
    inn                VARCHAR(12)  NOT NULL,
    kpp                VARCHAR(9),
    company_name       VARCHAR(255) NOT NULL,
    creation_timestamp timestamptz  NOT NULL,
    update_timestamp   timestamptz  NOT NULL
);

CREATE TABLE IF NOT EXISTS administrator
(
    id                 BIGSERIAL PRIMARY KEY,
    user_id            BIGINT      NOT NULL UNIQUE REFERENCES "user" (id),
    creation_timestamp timestamptz NOT NULL,
    update_timestamp   timestamptz NOT NULL
);

CREATE TABLE IF NOT EXISTS customer
(
    id                 BIGSERIAL PRIMARY KEY,
    user_id            BIGINT      NOT NULL UNIQUE REFERENCES "user" (id),
    business_info_id   BIGINT REFERENCES business_info (id),
    creation_timestamp timestamptz NOT NULL,
    update_timestamp   timestamptz NOT NULL
);

CREATE TABLE IF NOT EXISTS social_network
(
    id   BIGSERIAL PRIMARY KEY,
    link VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS customer_social_network
(
    customer_id       BIGINT NOT NULL REFERENCES customer (id),
    social_network_id BIGINT NOT NULL REFERENCES social_network (id),
    PRIMARY KEY (customer_id, social_network_id)
);

CREATE TABLE IF NOT EXISTS delivery
(
    id                 BIGSERIAL PRIMARY KEY,
    type               BIGINT         NOT NULL REFERENCES delivery_type (id),
    status             BIGINT         NOT NULL REFERENCES delivery_status (id),
    creation_timestamp timestamptz    NOT NULL,
    update_timestamp   timestamptz    NOT NULL
);

CREATE TABLE IF NOT EXISTS payment
(
    id                 BIGSERIAL PRIMARY KEY,
    type               BIGINT      NOT NULL REFERENCES payment_type (id),
    status             BIGINT      NOT NULL REFERENCES payment_status (id),
    creation_timestamp timestamptz NOT NULL,
    update_timestamp   timestamptz NOT NULL
);

CREATE TABLE IF NOT EXISTS print_setting
(
    id                 BIGSERIAL PRIMARY KEY,
    description        VARCHAR(255)   NOT NULL,
    price              NUMERIC(22, 2) NOT NULL,
    creation_timestamp timestamptz    NOT NULL,
    update_timestamp   timestamptz    NOT NULL
);

CREATE TABLE IF NOT EXISTS material
(
    id                  BIGSERIAL PRIMARY KEY,
    type                BIGINT         NOT NULL REFERENCES filament_type (id),
    availability_status BIGINT         NOT NULL REFERENCES availability_status (id),
    stock               BIGINT         NOT NULL,
    description         VARCHAR(255)   NOT NULL,
    price               NUMERIC(22, 2) NOT NULL,
    color               VARCHAR(255),
    creation_timestamp  timestamptz    NOT NULL,
    update_timestamp    timestamptz    NOT NULL
);

CREATE TABLE IF NOT EXISTS "order"
(
    id                 BIGSERIAL PRIMARY KEY,
    customer_id        BIGINT         NOT NULL REFERENCES customer (id),
    status             BIGINT         NOT NULL REFERENCES order_status (id),
    photo_url          VARCHAR(255),
    description        VARCHAR(255),
    material_id        BIGINT         NOT NULL REFERENCES material (id),
    print_setting_id   BIGINT         NOT NULL REFERENCES print_setting (id),
    payment_id         BIGINT         NOT NULL REFERENCES payment (id),
    delivery_id        BIGINT         NOT NULL REFERENCES delivery (id),
    total_price        NUMERIC(22, 2) NOT NULL,
    quantity           INT            NOT NULL,
    administrator_id   BIGINT REFERENCES administrator (id),
    creation_timestamp timestamptz    NOT NULL,
    update_timestamp   timestamptz    NOT NULL
);

CREATE TABLE IF NOT EXISTS document
(
    id                 BIGSERIAL PRIMARY KEY,
    type               BIGINT       NOT NULL REFERENCES document_type (id),
    url                VARCHAR(255) NOT NULL,
    order_id           BIGINT       NOT NULL REFERENCES "order" (id),
    creation_timestamp timestamptz  NOT NULL,
    update_timestamp   timestamptz  NOT NULL
);
