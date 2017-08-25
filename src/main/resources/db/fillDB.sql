DELETE FROM users;

INSERT INTO users (name, email, password, role)
VALUES ('admin', 'admin@mail.com', 'admin', 0);
INSERT INTO users (name, email, password, role)
VALUES ('user', 'user@mail.com', 'user', 1);