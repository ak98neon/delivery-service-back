DROP TABLE IF EXISTS permission CASCADE;

CREATE TABLE product
(
	id          BIGSERIAL PRIMARY KEY,
	name        VARCHAR(60) NOT NULL,
	description VARCHAR(128),
	imgurl      VARCHAR(128) NOT NULL
);

INSERT INTO product (name, description, imgurl) VALUES ('Pizza', '', 'assets/icons/food/pizza.png');
INSERT INTO product (name, description, imgurl) VALUES ('Burger', '', 'assets/icons/food/hamburger.png');
INSERT INTO product (name, description, imgurl) VALUES ('Hotdog', '', 'assets/icons/food/hotdog.png');
INSERT INTO product (name, description, imgurl) VALUES ('Taco', '', 'assets/icons/food/taco.png');
INSERT INTO product (name, description, imgurl) VALUES ('Snack', '', 'assets/icons/food/snacks.png');
INSERT INTO product (name, description, imgurl) VALUES ('Drink', '', 'assets/icons/food/juice.png');
