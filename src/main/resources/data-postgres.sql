-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123


 --DROP TABLE USERS ;--IF EXISTS(SELECT * FROM  USERS);
copy image_table from 'C:/tables.csv';
SELECT setval('image_table_id_seq', COALESCE((SELECT MAX(id)+1 FROM image_table), 1), false);



INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status, can_log,can_post) 
VALUES ('agnt', '$2a$04$ojOHchifXeLAevDCPwfyX.p0b2MbjyDed5CPk/1IyMBVT1Gl3lZBK', 'Marko', 'Markovic', 'user@example.com', true ,'2017-10-01 21:58:58.508-07', 'ACTIVE',true,true);

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status, can_log,can_post)
 VALUES ('admin', '$2a$04$ojOHchifXeLAevDCPwfyX.p0b2MbjyDed5CPk/1IyMBVT1Gl3lZBK', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58.508-07', 'ACTIVE',true,true);

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status, can_log,can_post) 
VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Maja', 'Savic', 'kupac@example.com', true, '2017-10-01 18:57:58.508-07', 'ACTIVE',true,true);

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status, can_log,can_post) 
VALUES ('peraSaKlise', '$2a$04$WswSnQIAkowjNIN/ZDk8w.LD5PwqdnTJLrRtgxP80uTokxC8LF1xa', 'Pera', 'Peric', 'prea@gmail.com', true, '2017-10-01 18:57:58.508-07', 'ACTIVE',true,true);

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date, status, can_log,can_post) 
VALUES ('maraSmara' ,'$2a$04$WFggkfJRG7dQKQELGDNXbemRQgSFG6GobpF94XJJ0p/oOu0Ms1.gi', 'Mara', 'Maric', 'merry@gmail.com', true, '2017-10-01 18:57:58.508-07' , 'ACTIVE',true,true);



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


INSERT INTO MODEL (title) VALUES  ('C1');
INSERT INTO MODEL (title) VALUES  ('C2');
INSERT INTO MODEL (title) VALUES  ('C3'); -- 3
INSERT INTO MODEL (title) VALUES  ('A1');  --4 
INSERT INTO MODEL (title) VALUES  ('A5');  --4 
INSERT INTO MODEL (title) VALUES  ('208'); --5 
INSERT INTO MODEL (title) VALUES  ('Fabia');--6

INSERT INTO MANUFACTURER ( title) VALUES ('Peugeot');
INSERT INTO MANUFACTURER ( title) VALUES ('Citroen');
INSERT INTO MANUFACTURER ( title) VALUES ('Skoda');
INSERT INTO MANUFACTURER ( title) VALUES ('Audi');  -- 4
INSERT INTO MANUFACTURER ( title) VALUES ('Shevrolet');  -- 5
INSERT INTO MANUFACTURER ( title) VALUES ('Volkswagen');  -- 6
INSERT INTO MANUFACTURER ( title) VALUES ('Zastava');  -- 6

INSERT INTO CITY ( title, code) VALUES ( 'Novi Sad', 21000);
INSERT INTO CITY ( title, code) VALUES ( 'Beograd', 11000);
INSERT INTO CITY ( title, code) VALUES ( 'Nis', 21000);
INSERT INTO CITY ( title, code) VALUES ( 'Cacak', 21000);
INSERT INTO CITY ( title, code) VALUES ( 'Subotica', 21000);

INSERT INTO GEAR(title) VALUES ('Manuelni');
INSERT INTO GEAR(title) VALUES ('Automatski');
INSERT INTO GEAR(title) VALUES ('Polu-automatski');

INSERT INTO FUEL (title) VALUES ('Gas');
INSERT INTO FUEL (title) VALUES ('Benzin');
INSERT INTO FUEL (title) VALUES ('Nafta');

INSERT INTO PRICELIST (cdw,price_per_day, price_per_km, creator_id, name, bonus) VALUES (12000, 3200, 500, 1, 'Prvi', 10);
INSERT INTO PRICELIST (cdw,price_per_day, price_per_km, creator_id, name, bonus) VALUES (12000, 3000, 700, 4, 'Drugi', 20);
INSERT INTO PRICELIST (cdw,price_per_day, price_per_km, creator_id, name, bonus) VALUES (12000, 3000, 700, 2, 'Drugi', 20);
INSERT INTO PRICELIST (cdw,price_per_day, price_per_km, creator_id, name, bonus) VALUES (12000, 3000, 700, 3, 'Drugi', 20);
INSERT INTO PRICELIST (cdw,price_per_day, price_per_km, creator_id, name, bonus) VALUES (10000, 1200, 500, 5, 'Treci', 0);
INSERT INTO PRICELIST (cdw,price_per_day, price_per_km, creator_id, name, bonus) VALUES (0, 1000, 100, 5, 'Cetvrti', 5);

INSERT INTO BONUS (creator, value) VALUES(5,5);
INSERT INTO BONUS (creator, value) VALUES(4,5);
INSERT INTO BONUS (creator, value) VALUES(4,10);
INSERT INTO BONUS (creator, value) VALUES(3,15);
INSERT INTO BONUS (creator, value) VALUES(5,20);

INSERT INTO CARCLASS (title) VALUES ('SUV');

INSERT INTO ADVERT (user_id, imgMain,  title, cdwprotection, kids_seat, milage , number_of_kids_seat,manufacturer_id, model, gear_id, cclass_id, fuel_id, descrption, price_list_id) VALUES (1,'toyotacamry.jpg', 'Chevrolet SPARK', true, true, 10000, 2, 5, 'SPARK', 2,1,3, 'Predstavnik gradskog automobila koji cilja na kupce nudeći praktičnost, ali i poseban prepoznatljiv i jedinstven izgled. ', 1);

INSERT INTO ADVERT (user_id, imgMain,  title, cdwprotection, kids_seat, milage , number_of_kids_seat,manufacturer_id, model ,gear_id, cclass_id,fuel_id,descrption, price_list_id) VALUES (1,'paugeot208.jpg', 'Peugeot 208', true, true, 10000, 2, 1, '208', 1 ,1,2, 'Najnovija generacija Peugeota 208',1);

INSERT INTO ADVERT (user_id, imgMain,  title, cdwprotection, kids_seat, milage , number_of_kids_seat,manufacturer_id, model , gear_id, cclass_id, fuel_id, price_list_id) VALUES (1,'volkswagen_tiguan.jpg', 'Volkswagen TIGUAN', true, true, 10000, 2, 6,'TIGUAN', 1 ,1,2, 1);

INSERT INTO ADVERT (user_id, imgMain,  title, cdwprotection, kids_seat, milage , number_of_kids_seat,manufacturer_id, model, gear_id, cclass_id, fuel_id, price_list_id) VALUES (4,'yugo.jpg', 'Yugo', true, true, 10000, 2, 7,'128', 1 ,1,1, 2);

INSERT INTO ADVERT (user_id, imgMain,  title, cdwprotection, kids_seat, milage , number_of_kids_seat,manufacturer_id, model, gear_id, cclass_id, fuel_id, price_list_id) VALUES (5,'audio_a5.jpg', 'Audio A5', true, true, 10000, 2, 4,'A5', 1 ,1,1, 6);



INSERT INTO BUNDLE_REQUEST (whoasked, whoposted) values ( 5 , 1);
INSERT INTO BUNDLE_REQUEST (whoasked, whoposted) values ( 4 , 1);



INSERT INTO REQUESTED_CAR_TERM (renting_date, renting_time, returning_date, returning_time, status    , advert_id, rent_id) 
                        values ('15.08.2020', '10:00'     , '18.08.2020'  , '12:00'       , 'PENDING' , 1        , 1);

INSERT INTO REQUESTED_CAR_TERM (renting_date, renting_time,  returning_date, returning_time, status    , advert_id, rent_id) 
                        values ('16.08.2020', '10:00'     , '19.08.2020'  , '13:00'        , 'PENDING' , 2        , 1);


INSERT INTO REQUESTED_CAR_TERM (renting_date, renting_time,  returning_date, returning_time, status    , advert_id, rent_id) 
                        values ('25.08.2020', '10:00'     , '28.08.2020'  , '14:00'        , 'PENDING' , 1        , 2);

INSERT INTO REQUESTED_CAR_TERM (renting_date, renting_time, returning_date, returning_time, status    , advert_id, rent_id) 
                        values ('17.08.2020', '10:00'     , '22.08.2020'  , '16:00'       , 'PENDING' , 3        , 2);




INSERT INTO STATISTIC_DATA ( advert_id,advert_name, milage, rent_number) VALUES (1, 'Chevrolet SPARK'  ,195000, 10);
INSERT INTO STATISTIC_DATA ( advert_id,advert_name, milage, rent_number) VALUES (2, 'Peugeot 208'      ,132000, 15);
INSERT INTO STATISTIC_DATA ( advert_id,advert_name, milage, rent_number) VALUES (3, 'Volkswagen TIGUAN',189000, 35);
INSERT INTO STATISTIC_DATA ( advert_id,advert_name, milage, rent_number) VALUES (4, 'Yugo'             ,255002, 5);
INSERT INTO STATISTIC_DATA ( advert_id,advert_name, milage, rent_number) VALUES (5, 'Audio A5'         ,212000, 8);
