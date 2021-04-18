DROP TABLE IF EXISTS product CASCADE;

CREATE TABLE product
(
	id          BIGSERIAL PRIMARY KEY,
	name        VARCHAR(60) NOT NULL,
	description VARCHAR(128),
	imgurl      VARCHAR(128) NOT NULL,
	created     TIMESTAMP    NOT NULL,
	updated     TIMESTAMP,
	deleted     TIMESTAMP
);

INSERT INTO product (name, description, imgurl, created, updated) VALUES ('Pizza', '', 'assets/icons/food/pizza.png', current_timestamp, current_timestamp);
INSERT INTO product (name, description, imgurl, created, updated) VALUES ('Burger', '', 'assets/icons/food/hamburger.png', current_timestamp, current_timestamp);
INSERT INTO product (name, description, imgurl, created, updated) VALUES ('Hotdog', '', 'assets/icons/food/hotdog.png', current_timestamp, current_timestamp);
INSERT INTO product (name, description, imgurl, created, updated) VALUES ('Taco', '', 'assets/icons/food/taco.png', current_timestamp, current_timestamp);
INSERT INTO product (name, description, imgurl, created, updated) VALUES ('Snack', '', 'assets/icons/food/snacks.png', current_timestamp, current_timestamp);
INSERT INTO product (name, description, imgurl, created, updated) VALUES ('Drink', '', 'assets/icons/food/juice.png', current_timestamp, current_timestamp);
