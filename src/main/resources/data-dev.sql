/* encoder("password") ---> $2a$10$Kk5XqRUxi8zsedOdhpBiI.b4t97kd7h44KwneegmvrwGKpYBE3gSy */

INSERT INTO user_role(id, role_name) VALUES (10001, 'ROLE_ADMIN');
INSERT INTO user_role(id, role_name) VALUES (10002, 'ROLE_USER');

INSERT INTO user_login(id, email, first_name, last_name, username, password) VALUES (10001, 'admin@company.com', 'Amministratore', 'Amministratore', 'admin', '$2a$10$Kk5XqRUxi8zsedOdhpBiI.b4t97kd7h44KwneegmvrwGKpYBE3gSy');
INSERT INTO user_login(id, email, first_name, last_name, username, password) VALUES (10002, 'user@company.com', 'Utente', 'Utente', 'user', '$2a$10$Kk5XqRUxi8zsedOdhpBiI.b4t97kd7h44KwneegmvrwGKpYBE3gSy');

INSERT INTO user_login_roles(user_id, role_id) VALUES (10001, 10001);
INSERT INTO user_login_roles(user_id, role_id) VALUES (10001, 10002);

INSERT INTO user_login_roles(user_id, role_id) VALUES (10002, 10002);