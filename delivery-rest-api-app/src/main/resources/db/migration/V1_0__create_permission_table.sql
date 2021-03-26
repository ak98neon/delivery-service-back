DROP TABLE IF EXISTS permission CASCADE;
CREATE TABLE permission
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(60) UNIQUE,
    description VARCHAR(128)
);
