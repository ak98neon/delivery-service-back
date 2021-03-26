DROP TABLE IF EXISTS permission CASCADE;

CREATE TABLE product
(
	id          BIGSERIAL PRIMARY KEY,
	name        VARCHAR(60) NOT NULL,
	description VARCHAR(128),
	imgUrl      VARCHAR(128) NOT NULL
);
