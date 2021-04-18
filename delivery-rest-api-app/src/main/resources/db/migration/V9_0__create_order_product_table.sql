CREATE TABLE IF NOT EXISTS order_product
(
	order_id   BIGINT NOT NULL,
	product_id BIGINT NOT NULL,
	CONSTRAINT PK_order_product PRIMARY KEY (order_id, product_id)
);
