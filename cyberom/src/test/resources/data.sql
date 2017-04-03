DROP TABLE IF EXISTS tbl_session_system_usage;
DROP TABLE IF EXISTS tbl_system_usage;
DROP TABLE IF EXISTS tbl_session;
DROP TABLE IF EXISTS tbl_system;
DROP TABLE IF EXISTS tbl_visitor;
DROP TABLE IF EXISTS tbl_cybercafe;
DROP TABLE IF EXISTS tbl_address;
DROP TABLE IF EXISTS tbl_city;
DROP TABLE IF EXISTS tbl_state;
DROP TABLE IF EXISTS tbl_user;
DROP TABLE IF EXISTS tbl_id_card_type;
DROP TABLE IF EXISTS tbl_status;
DROP TABLE IF EXISTS tbl_session_status;



CREATE TABLE tbl_status (
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
	name varchar(45) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tbl_session_status (
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
	name varchar(45) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE  tbl_state (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE  tbl_city (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  state_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE  tbl_address (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  address_line1 varchar(200) NOT NULL,
  address_line2 varchar(200) NOT NULL,
  pin_no varchar(45) NOT NULL,
  city_id int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  KEY FK_tbl_address_1 (city_id),
  CONSTRAINT FK_tbl_address_1 FOREIGN KEY (city_id) REFERENCES tbl_city (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE  tbl_user (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  updated_on datetime DEFAULT NULL,
  random_uuid varchar(200) DEFAULT NULL,
  status_id int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  KEY FK_tbl_user_1 (status_id),
  CONSTRAINT FK_tbl_user_1 FOREIGN KEY (status_id) REFERENCES tbl_status (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE  tbl_cybercafe (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  phone_no varchar(45) NOT NULL,
  address_id int(10) unsigned NOT NULL,
  updated_on datetime NOT NULL,
  status_id int(10) unsigned NOT NULL,
  user_id int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  KEY FK_tbl_cybercafe_1 (address_id),
  KEY FK_tbl_cybercafe_2 (status_id),
  KEY FK_tbl_cybercafe_3 (user_id),
  CONSTRAINT FK_tbl_cybercafe_3 FOREIGN KEY (user_id) REFERENCES tbl_user (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_tbl_cybercafe_1 FOREIGN KEY (address_id) REFERENCES tbl_address (id),
  CONSTRAINT FK_tbl_cybercafe_2 FOREIGN KEY (status_id) REFERENCES tbl_status (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tbl_id_card_type (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE tbl_visitor (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  age int(10) unsigned NOT NULL,
  sex varchar(45) NOT NULL,
  address_id int(10) unsigned NOT NULL,
  mobile varchar(45) NOT NULL,
  cybercafe_id int(10) unsigned NOT NULL,
  id_card_number varchar(100) NOT NULL,
  id_card_type int(10) unsigned NOT NULL,
  updated_on datetime not null,
  updated_by int(10),
  PRIMARY KEY (id),
  KEY FK_tbl_visitor_2 (cybercafe_id),
  KEY FK_tbl_visitor_3 (id_card_type),
  CONSTRAINT FK_tbl_visitor_3 FOREIGN KEY (id_card_type) REFERENCES tbl_id_card_type (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_tbl_visitor_1 FOREIGN KEY (address_id) REFERENCES tbl_address (id),
  CONSTRAINT FK_tbl_visitor_2 FOREIGN KEY (cybercafe_id) REFERENCES tbl_cybercafe (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tbl_system (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  serial varchar(100) DEFAULT NULL,
  status_id int(10) unsigned NOT NULL,
  is_occupied boolean,
  cybercafe_id int(10) unsigned NOT NULL,
  updated_on datetime NOT NULL,
  updated_by int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  KEY FK_tbl_system_1 (cybercafe_id),
  KEY FK_tbl_system_2 (updated_by),
  KEY FK_tbl_system_3 (status_id) USING BTREE,
  CONSTRAINT FK_tbl_system_1 FOREIGN KEY (cybercafe_id) REFERENCES tbl_cybercafe (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_tbl_system_2 FOREIGN KEY (updated_by) REFERENCES tbl_user (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_tbl_system_3 FOREIGN KEY (status_id) REFERENCES tbl_status (id)
);

CREATE TABLE tbl_session (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  start_time datetime NOT NULL,
  end_time datetime,
  visitor_id int(10) unsigned NOT NULL,
  updated_on datetime NOT NULL,
  updated_by int(10) unsigned NOT NULL,
  created_on datetime NOT NULL,
  cybercafe_id int(10) unsigned NOT NULL,
  session_status_id int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  KEY FK_tbl_session_1 (visitor_id),
  KEY FK_tbl_session_2 (cybercafe_id),
  KEY FK_tbl_session_3 (session_status_id),
  CONSTRAINT FK_tbl_session_1 FOREIGN KEY (visitor_id) REFERENCES tbl_visitor (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_tbl_session_2 FOREIGN KEY (cybercafe_id) REFERENCES tbl_cybercafe (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_tbl_session_3 FOREIGN KEY (session_status_id) REFERENCES tbl_session_status (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tbl_system_usage (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  system_id int(10) unsigned NOT NULL,
  start_time datetime NOT NULL,
  end_time datetime,
  PRIMARY KEY (id),
  KEY FK_tbl_system_usage_1 (system_id),
  CONSTRAINT FK_tbl_system_usage_1 FOREIGN KEY (system_id) REFERENCES tbl_system (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tbl_session_system_usage (
  session_id int(10) unsigned NOT NULL,
  system_usage_id int(10) unsigned NOT NULL,
  KEY FK_tbl_session_system_usage_1 (session_id),
  KEY FK_tbl_session_system_usage_2 (system_usage_id),
  CONSTRAINT FK_tbl_session_system_usage_2 FOREIGN KEY (system_usage_id) REFERENCES tbl_system_usage (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_tbl_session_system_usage_1 FOREIGN KEY (session_id) REFERENCES tbl_session (id) ON DELETE CASCADE ON UPDATE CASCADE
);



insert into tbl_status(id, name)
values(1, 'Active');

insert into tbl_status(id, name)
values(2, 'Inactive');

insert into tbl_session_status(id, name)
values(1, 'New');

insert into tbl_session_status(id, name)
values(2, 'In Progress');

insert into tbl_session_status(id, name)
values(3, 'Completed');

insert into tbl_state(id, name)
values(1, 'Punjab');

insert into tbl_state(id, name)
values(2, 'Maharashtra');

insert into tbl_state(id, name)
values(3, 'Gujarat');

insert into tbl_state(id, name)
values(4, 'Madhya Pradesh');

insert into tbl_state(id, name)
values(5, 'Rajasthan');


insert into tbl_city(id, name, state_id)
values(1, 'Mohali', 1);

insert into tbl_city(id, name, state_id)
values(2, 'Mumbai', 2);

insert into tbl_city(id, name, state_id)
values(3, 'Pune', 2);

insert into tbl_city(id, name, state_id)
values(4, 'Nasik', 2);

insert into tbl_city(id, name, state_id)
values(5, 'Thane', 2);

insert into tbl_user(id, username, password, email, first_name, last_name, updated_on, status_id)
values(1, 'bablur', 'password_123', 'bablu.rajbhar87@gmail.com', 'bablu', 'rajbhar', now(),2);


insert into tbl_address(id, address_line1, address_line2, pin_no, city_id)
values(1, 'shop no 2', 'station road', '400079', 1);

insert into tbl_cybercafe(id, name, phone_no, address_id, updated_on, status_id, user_id)
values(1, 'Macros', '25746596', 1, now(), 2, 1);

insert into tbl_cybercafe(id, name, phone_no, address_id, updated_on, status_id, user_id)
values(2, 'Surabhi', '32427479', 1, now(), 2, 1);

insert into tbl_id_card_type(id, name)
values(1, 'Election ID');

insert into tbl_id_card_type(id, name)
values(2, 'Pan Card');

insert into tbl_id_card_type(id, name)
values(3, 'Aadhar Card');



INSERT INTO tbl_visitor (id,first_name,last_name,age,sex,address_id,mobile,cybercafe_id,id_card_number,id_card_type,updated_by,updated_on) VALUES 
 (1,'Bablu','Rajbhar',29,'Male',1,'9819034283',1,'1234567',1,NULL,'2016-07-10 23:20:00');
 
 INSERT INTO tbl_visitor (id,first_name,last_name,age,sex,address_id,mobile,cybercafe_id,id_card_number,id_card_type,updated_by,updated_on) VALUES
 (2,'Sudhir','Rajbhar',17,'Male',1,'9967071203',1,'40078',1,NULL,'2016-07-10 23:22:09');
 
 INSERT INTO tbl_visitor (id,first_name,last_name,age,sex,address_id,mobile,cybercafe_id,id_card_number,id_card_type,updated_by,updated_on) VALUES
 (3,'Shivansh','Rajbhar',3,'Male',1,'9967071203',1,'456789',2,NULL,'2016-07-10 23:16:31');
 
 INSERT INTO tbl_visitor (id,first_name,last_name,age,sex,address_id,mobile,cybercafe_id,id_card_number,id_card_type,updated_by,updated_on) VALUES
 (4,'Ashish','Rajbhar',18,'Male',1,'9819034283',1,'400078',1,NULL,'2016-07-10 22:21:03');
 
 INSERT INTO tbl_visitor (id,first_name,last_name,age,sex,address_id,mobile,cybercafe_id,id_card_number,id_card_type,updated_by,updated_on) VALUES
 (5,'Sandip','Rajbhar',20,'Male',1,'9819034283',1,'400078',3,NULL,'2016-06-19 17:15:09');
 
 INSERT INTO tbl_visitor (id,first_name,last_name,age,sex,address_id,mobile,cybercafe_id,id_card_number,id_card_type,updated_by,updated_on) VALUES
 (6,'Pradeep','Rajbhar',20,'Male',1,'9819034283',1,'45212',3,NULL,'2016-06-23 22:16:45'),
 (7,'Amit','Rajbhar',29,'Male',1,'9819034283',1,'6483837',1,NULL,'2016-07-10 23:20:00'),
 (8,'Sumit','Rajbhar',17,'Male',1,'9967071203',1,'638393',1,NULL,'2016-07-10 23:22:09'),
 (9,'Ganesh','Rajbhar',3,'Male',1,'9967071203',1,'1214253',2,NULL,'2016-07-10 23:16:31'),
 (10,'Ramesh','Rajbhar',18,'Male',1,'9819034283',1,'363839',1,NULL,'2016-07-10 22:21:03'),
 (11,'Shivam','Rajbhar',20,'Male',1,'9819034283',1,'363920',3,NULL,'2016-06-19 17:15:09'),
 (12,'Naresh','Rajbhar',20,'Male',1,'9819034283',1,'342730',3,NULL,'2016-06-23 22:16:45');

 
 INSERT INTO tbl_system (id, name, serial, status_id, cybercafe_id, updated_on, updated_by, is_occupied) VALUES
 (1, 'System1', 'ABC', 1, 1, '2016-06-23 22:16:45', 1, false),
 (2, 'System2', 'EFG', 1, 1, '2016-06-23 22:16:45', 1, false),
 (3, 'System3', 'HIJ', 1, 1, '2016-06-23 22:16:45', 1, false),
 (4, 'System4', 'KLM', 1, 1, '2016-06-23 22:16:45', 1, false),
 (5, 'System5', 'NOP', 1, 1, '2016-06-23 22:16:45', 1, false),
 (6, 'System6', 'QRS', 1, 1, '2016-06-23 22:16:45', 1, false),
 (7, 'System7', 'TUV', 1, 1, '2016-06-23 22:16:45', 1, false),
 (8, 'System8', 'WXY', 1, 1, '2016-06-23 22:16:45', 1, false),
 (9, 'System9', 'ZAB', 1, 1, '2016-06-23 22:16:45', 1, false),
 (10, 'System10', 'CDF', 1, 1, '2016-06-23 22:16:45', 1, false);