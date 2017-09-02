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

