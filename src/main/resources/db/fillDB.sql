DELETE FROM products_variants;
DELETE FROM products_orders;
DELETE FROM orders;
DELETE FROM variants;
DELETE FROM attributes;
DELETE FROM products;
DELETE FROM categorys;
DELETE FROM users;

INSERT INTO `users` (id, `name`, `email`, `password`, `role`)
VALUES (1, 'admin', 'admin@mail.com', 'admin', 0);
INSERT INTO `users` (id, `name`, `email`, `password`, `role`)
VALUES (2, 'user', 'user@mail.com', 'user', 1);

INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (1, NULL, 'Техника', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (2, 6, 'Мобильные телефоны', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (3, 6, 'Компютеры', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (4, 3, 'Ноутбуки', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (5, NULL, 'Авто', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (6, 1, 'Електроника', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (7, 2, 'Смартфон', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (8, 3, 'Собраные', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (9, 3, 'Детали', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (10, 9, 'Процесоры', 0);
INSERT INTO `categorys` (`id`, `parent_cat_id`, `name`, `order`) VALUES (11, NULL, 'Сантехника, Стройматериалы', 0);



INSERT INTO products (id, name, description, categorys_id)
VALUES (1, 'LG g 1000', 'очень крутой телефоы', 2);


INSERT INTO `attributes` (`id`, `name`, `description`, `type`, `categorys_id`)
VALUES (1, 'RAM', 'mobile phone RAM', 'DROP_BOX', 1);
INSERT INTO `attributes` (`id`, `name`, `description`, `type`, `categorys_id`) VALUES (2, 'ROM', 'ROM', 'DROP_BOX', 1);

INSERT INTO `variants` (`id`, `name`, `description`, `attribute_id`) VALUES (1, '1 GB', NULL, 1);
INSERT INTO `variants` (`id`, `name`, `description`, `attribute_id`) VALUES (2, '2 GB', NULL, 1);
INSERT INTO `variants` (`id`, `name`, `description`, `attribute_id`) VALUES (3, '3 GB', NULL, 1);
INSERT INTO `variants` (`id`, `name`, `description`, `attribute_id`) VALUES (4, '4 GB', NULL, 1);
INSERT INTO `variants` (`id`, `name`, `description`, `attribute_id`) VALUES (5, '16 GB', NULL, 2);
INSERT INTO `variants` (`id`, `name`, `description`, `attribute_id`) VALUES (6, '32 GB', NULL, 2);

INSERT INTO `orders` (`id`, `datetime_open`, `datetime_closed`, `description`, `sum`, `users_id`)
VALUES (1, '2017-09-07 23:05:23', NULL, 'TEstOrder', 1000, 2);

INSERT INTO `products_orders` (`id`, `orders_id`, `products_id`) VALUES (2, 1, 1);
INSERT INTO `products_orders` (`id`, `orders_id`, `products_id`) VALUES (3, 1, 1);

INSERT INTO `products_variants` (`products_id`, `variants_id`, `attributes_id`) VALUES (1, 1, 1);
INSERT INTO `products_variants` (`products_id`, `variants_id`, `attributes_id`) VALUES (1, 5, 2);


