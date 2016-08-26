CREATE TABLE `tbl_state` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `tbl_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


CREATE TABLE `tbl_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `random_uuid` varchar(200) DEFAULT NULL,
  `status_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_user_1` (`status_id`),
  CONSTRAINT `FK_tbl_user_1` FOREIGN KEY (`status_id`) REFERENCES `tbl_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `tbl_address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(200) NOT NULL,
  `address_line2` varchar(200) NOT NULL,
  `pin_no` varchar(45) NOT NULL,
  `city_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_address_1` (`city_id`),
  CONSTRAINT `FK_tbl_address_1` FOREIGN KEY (`city_id`) REFERENCES `tbl_city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


CREATE TABLE `tbl_cybercafe` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `address_id` int(10) unsigned NOT NULL,
  `updated_on` datetime NOT NULL,
  `status_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_cybercafe_1` (`address_id`),
  KEY `FK_tbl_cybercafe_2` (`status_id`),
  KEY `FK_tbl_cybercafe_3` (`user_id`),
  CONSTRAINT `FK_tbl_cybercafe_1` FOREIGN KEY (`address_id`) REFERENCES `tbl_address` (`id`),
  CONSTRAINT `FK_tbl_cybercafe_2` FOREIGN KEY (`status_id`) REFERENCES `tbl_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_cybercafe_3` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_id_card_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO `tbl_id_card_type` (`id`,`name`) VALUES 
 (1,'Election ID'),
 (2,'Pan Card'),
 (3,'Aadhar Card'),
 (4,'Passport'),
 (5,'College ID'),
 (6,'School ID');

CREATE TABLE `tbl_visitor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `sex` varchar(45) NOT NULL,
  `address_id` int(10) unsigned NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `cybercafe_id` int(10) unsigned NOT NULL,
  `id_card_number` varchar(100) NOT NULL,
  `id_card_type` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_visitor_2` (`cybercafe_id`),
  KEY `FK_tbl_visitor_3` (`id_card_type`),
  CONSTRAINT `FK_tbl_visitor_3` FOREIGN KEY (`id_card_type`) REFERENCES `tbl_id_card_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_visitor_1` FOREIGN KEY (`id`) REFERENCES `tbl_address` (`id`),
  CONSTRAINT `FK_tbl_visitor_2` FOREIGN KEY (`cybercafe_id`) REFERENCES `tbl_cybercafe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `tbl_status` (`id`,`name`) VALUES 
 (1,'Active'),
 (2,'Inactive');
 
 INSERT INTO `tbl_state` (`id`,`name`) VALUES 
 (1,'Punjab');
 
 INSERT INTO `tbl_city` (`id`,`name`,`state_id`) VALUES 
 (1,'Chandigarh',1);
 
 INSERT INTO `tbl_address` (`id`,`address_line1`,`address_line2`,`pin_no`,`city_id`) VALUES 
 (1,'Sector 17','Neelam Theater','160002',1),
 (2,'Sector 18','Near Cinema','400079',1);
 
 INSERT INTO `tbl_user` (`id`,`username`,`password`,`email`,`first_name`,`last_name`,`updated_on`,`random_uuid`,`status_id`) VALUES 
 (1,'brajbhar','9c408ed1f921b37d54ccfcb3e11072c9','bablu.rajbhar87@gmail.com','Bablu','Rajbhar','2015-06-27 19:17:07','3ef5f5a2-1c11-4cff-be49-f9f98f6675b0',2),
 (2,'bablur','9c408ed1f921b37d54ccfcb3e11072c9','bablu.rajbhar87@gmail.com','Bablu','Rajbhar','2015-06-27 22:05:50','7f998272-69d2-40b5-926b-90cca0d1fa6f',1);
 
 
 INSERT INTO `tbl_cybercafe` (`id`,`name`,`phone_no`,`address_id`,`updated_on`,`status_id`,`user_id`) VALUES 
 (1,'Macros','9819034283',1,'2015-06-27 19:17:07',2,1),
 (2,'Systech','9819034283',2,'2015-06-27 22:05:50',2,2);