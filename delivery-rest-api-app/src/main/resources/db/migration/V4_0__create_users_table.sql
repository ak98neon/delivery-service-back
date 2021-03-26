DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id                  BIGSERIAL PRIMARY KEY,
    username            VARCHAR(30) UNIQUE NOT NULL,
    password            VARCHAR(255)       NOT NULL,
    email               VARCHAR(255)       NOT NULL,
    enabled             BOOLEAN            NOT NULL,
    account_expired     BOOLEAN            NOT NULL,
    credentials_expired BOOLEAN            NOT NULL,
    account_non_locked  BOOLEAN            NOT NULL,
    person_id           BIGINT
);
