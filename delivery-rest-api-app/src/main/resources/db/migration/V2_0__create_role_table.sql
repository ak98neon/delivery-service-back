DROP TABLE IF EXISTS role CASCADE;
CREATE TABLE role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) UNIQUE
);