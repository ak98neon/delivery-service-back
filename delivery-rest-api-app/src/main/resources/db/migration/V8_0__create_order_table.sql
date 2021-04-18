DROP TABLE IF EXISTS "order" CASCADE;

CREATE TABLE "order"
(
	id          BIGSERIAL PRIMARY KEY,
	total_price DECIMAL      NOT NULL,
	status      VARCHAR(128) NOT NULL,
	quantity    INT          NOT NULL,
	created     TIMESTAMP    NOT NULL,
	updated     TIMESTAMP,
	deleted     TIMESTAMP
);
