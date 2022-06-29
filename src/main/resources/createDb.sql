CREATE TABLE IF NOT EXISTS users
(
    id                      bigint                      NOT NULL GENERATED ALWAYS AS IDENTITY,
    name                    varchar                     NOT NULL CHECK (name != ''),
    surname                 varchar                     NOT NULL CHECK (surname != ''),
    birthday                timestamptz                 NOT NULL,
    phone_number            varchar                     NOT NULL CHECK (phone_number != ''),
    income                  bigint                      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS credits
(
    id                      bigint                      NOT NULL    GENERATED ALWAYS AS IDENTITY,
    user_id                 bigint                      NOT NULL,
    is_paid                 boolean                     DEFAULT     'false',
    percent                 int                         NOT NULL    DEFAULT (0),
    term                    int                         NOT NULL,
    amount                  bigint                      NOT NULL,
    processing_date         timestamptz                 NOT NULL DEFAULT NOW(),
    prepayment_date         timestamptz,
    PRIMARY KEY (id)
);