-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123


 --DROP TABLE USERS ;--IF EXISTS(SELECT * FROM  USERS);

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status) VALUES ('agnt', '$2a$04$ojOHchifXeLAevDCPwfyX.p0b2MbjyDed5CPk/1IyMBVT1Gl3lZBK', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58.508-07', 'BLOK');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status) VALUES ('admin', '$2a$04$ojOHchifXeLAevDCPwfyX.p0b2MbjyDed5CPk/1IyMBVT1Gl3lZBK', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58.508-07', 'ACTIVE');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Maja', 'Savic', 'kupac@example.com', true, '2017-10-01 18:57:58.508-07', 'ACTIVE');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status) VALUES ('peraSaKlise', '$2a$04$WswSnQIAkowjNIN/ZDk8w.LD5PwqdnTJLrRtgxP80uTokxC8LF1xa', 'Pera', 'Peric', 'prea@gmail.com', true, '2017-10-01 18:57:58.508-07', 'ACTIVE');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status) VALUES ('maraSmara' ,'$2a$04$WFggkfJRG7dQKQELGDNXbemRQgSFG6GobpF94XJJ0p/oOu0Ms1.gi', 'Mara', 'Maric', 'merry@gmail.com', true, '2017-10-01 18:57:58.508-07' , 'ACTIVE');



INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_AGENCY');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 3);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (4, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (5, 1);

