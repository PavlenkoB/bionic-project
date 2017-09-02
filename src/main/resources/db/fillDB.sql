DELETE FROM users;

INSERT INTO users (name, email, password, role)
VALUES ('admin', 'admin@mail.com', 'admin', 0);
INSERT INTO users (name, email, password, role)
VALUES ('user', 'user@mail.com', 'user', 1);

DELETE FROM attributes;

INSERT INTO attributes (NAME, DESCRIPTION)
VALUES ('RAM', 'mobile phone RAM');

DELETE FROM VARIANTS;

INSERT INTO VARIANTS (NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES ('1 GB', NULL, 1);
INSERT INTO VARIANTS (NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES ('2 GB', NULL, 1);
INSERT INTO VARIANTS (NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES ('3 GB', NULL, 1);
INSERT INTO VARIANTS (NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES ('4 GB', NULL, 1);

DELETE FROM orders;

INSERT INTO orders (datetime, description, users_id)
VALUES (now(), 'test order', 1);

DELETE FROM categorys;
INSERT INTO categorys (parent_cat_id, name)
VALUES (NULL, 'Техника');
INSERT INTO categorys (parent_cat_id, name)
VALUES (1, 'Мобильные телефоны');

DELETE FROM currencys;
INSERT INTO currencys (id, name, factor)
VALUES (1, 'dolars', 1);

DELETE FROM products;
INSERT INTO products (name, price, description, categorys_id, currencys_id)
VALUES ('LG g 1000', '0110.52', 'очень крутой телефоы', 2, 1);

DELETE FROM products_users;
INSERT INTO products_users (user_id, products_id)
    VALUE (1, 1);
