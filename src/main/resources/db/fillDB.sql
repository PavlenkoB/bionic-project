DELETE FROM products_users;
DELETE FROM VARIANTS;
DELETE FROM attributes;
DELETE FROM products;
DELETE FROM categorys;
DELETE FROM users;

INSERT INTO `users` (id, `name`, `email`, `password`, `role`)
VALUES (1, 'admin', 'admin@mail.com', 'admin', 0);
INSERT INTO `users` (id, `name`, `email`, `password`, `role`)
VALUES (2, 'user', 'user@mail.com', 'user', 1);

INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`)
VALUES (1, NULL, 'Техника', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`)
VALUES (2, 1, 'Мобильные телефоны', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`)
VALUES (3, 1, 'Компютеры', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`)
VALUES (4, 3, 'Ноутбуки', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`)
VALUES (5, NULL, 'Авто', 0);


INSERT INTO products (id, name, description, categorys_id)
VALUES (1, 'LG g 1000', 'очень крутой телефоы', 2);


INSERT INTO attributes (id, name, description, moderated, categorys_id, type)
VALUES (1, 'RAM', 'mobile phone RAM', 1, 1, 'DROP_BOX');


INSERT INTO VARIANTS (ID, NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES (1, '1 GB', NULL, 1);
INSERT INTO VARIANTS (ID, NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES (2, '2 GB', NULL, 1);
INSERT INTO VARIANTS (ID, NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES (3, '3 GB', NULL, 1);
INSERT INTO VARIANTS (ID, NAME, DESCRIPTION, ATTRIBUTE_ID)
VALUES (4, '4 GB', NULL, 1);

INSERT INTO products_users (id, user_id, products_id, counter, price)
  VALUE (1, 1, 1, 100, 150);

