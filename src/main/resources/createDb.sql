CREATE TABLE IF NOT EXISTS users
(
    id                      bigint                      NOT NULL GENERATED ALWAYS AS IDENTITY,
    name                    varchar                     NOT NULL CHECK (name != ''),
    surname                 varchar                     NOT NULL CHECK (surname != ''),
    birthday                timestamptz                 NOT NULL,
    phone_number            varchar                     NOT NULL CHECK (phone_number != ''),
    name                    varchar                     NOT NULL,
    surname                 varchar                     NOT NULL,
    second_name             varchar,
    phone                   bigint                     NOT NULL,
    sub_expire_notification boolean     DEFAULT 'false',
    telegram_id             bigint,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS customers
(
    id                      bigint                      NOT NULL GENERATED ALWAYS AS IDENTITY,
    name                    varchar                     NOT NULL CHECK (name != ''),
    surname                 varchar                     NOT NULL CHECK (surname != ''),
    birthday                timestamptz                 NOT NULL,
    phone_number            varchar                     NOT NULL CHECK (phone_number != ''),
    name                    varchar                     NOT NULL,
    surname                 varchar                     NOT NULL,
    second_name             varchar,
    phone                   bigint                     NOT NULL,
    sub_expire_notification boolean     DEFAULT 'false',
    telegram_id             bigint,
    PRIMARY KEY (id)
    );