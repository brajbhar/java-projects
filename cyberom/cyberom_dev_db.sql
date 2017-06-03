-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.23


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_cyberom
--

CREATE DATABASE IF NOT EXISTS db_cyberom;
USE db_cyberom;

--
-- Definition of table `tbl_address`
--

DROP TABLE IF EXISTS `tbl_address`;
CREATE TABLE `tbl_address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(200) NOT NULL,
  `address_line2` varchar(200) NOT NULL,
  `pin_no` varchar(45) NOT NULL,
  `city_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_address_1` (`city_id`),
  CONSTRAINT `FK_tbl_address_1` FOREIGN KEY (`city_id`) REFERENCES `tbl_city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_address`
--

/*!40000 ALTER TABLE `tbl_address` DISABLE KEYS */;
INSERT INTO `tbl_address` (`id`,`address_line1`,`address_line2`,`pin_no`,`city_id`) VALUES 
 (1,'Sector 17','Neelam Theater','160002',1),
 (2,'Sector 18','Near Cinema','400079',1),
 (3,'sfsdf','sfsf','444444444444',1),
 (4,'Vikhroli','vikhroli east','400079',1),
 (5,'shfu','hu','400079',1),
 (6,'Vikhroli village','vikhroli east','400079',1),
 (9,'Vikhroli village','vikhroli east','400079',2),
 (10,'Vikhroli village','vikhroli east','400079',1),
 (11,'Vikhroli village','vikhroli east','400079',1),
 (12,'bldg no 3','sector 17','400079',2),
 (13,'bldg no 3','sector 17','400079',2),
 (14,'bldg no 3','sector 17','400079',2),
 (15,'Vikhroli','Village','400079',1),
 (16,'Satmesar','Bardiha','2256485',2),
 (17,'Satmesar','Bardiha','400078',1),
 (18,'Vikhroli village','vikhroli east','400079',1),
 (19,'Satmesara','Bardhina','458763',1),
 (20,'Vikhroli village','vikhroli east','400079',1),
 (21,'Vikhroli village','vikhroli east','400079',1),
 (22,'Vikhroli village','vikhroli east','400079',1),
 (23,'Vikhroli village','vikhroli east','400079',1),
 (24,'Vikhroli village','vikhroli east','400079',1),
 (25,'Vikhroli village','vikhroli east','400079',1),
 (26,'Vikhroli village','vikhroli east','400079',1),
 (27,'Vikhroli village','vikhroli east','400079',1),
 (28,'Vikhroli village','vikhroli east','400079',1),
 (29,'Vikhroli village','vikhroli east','400079',1),
 (30,'Vikhroli village','vikhroli east','400079',1),
 (31,'Vikhroli village','vikhroli east','400079',1),
 (32,'Satmesar','Bardiha','2256485',2),
 (33,'Vikhroli village','vikhroli east','400079',1),
 (34,'bldg no 3','sector 17','400079',2),
 (35,'Vikhroli village','vikhroli east','400079',1),
 (36,'bldg no 3','sector 17','400079',2),
 (37,'Vikhroli','Village','400079',1),
 (38,'Vikhroli village','vikhroli east','400079',1),
 (39,'Vikhroli village','vikhroli east','400079',1),
 (40,'bldg no 3','sector 17','400079',2),
 (41,'Satmesar','Bardiha','2256485',2),
 (42,'Satmesar','Bardiha','2256485',1),
 (43,'bldg no 3','sector 17','400079',1),
 (44,'Vikhroli village','vikhroli east','400079',1),
 (45,'Vikhroli village','vikhroli east','400083',1),
 (46,'Vikhroli village','vikhroli east','400083',1),
 (47,'Sector 17','Bus stand','160002',1),
 (48,'Panthar Nagar','Kannamwar Nagar1','400083',1),
 (49,'Bandra','East','400078',1),
 (50,'Juhu','east','455896',1),
 (51,'Vikhroli village','vikhroli east','400083',1),
 (52,'Vikhroli village','vikhroli west','400083',1),
 (53,'Vikhroli village','vikhroli west','400083',1),
 (54,'Vikhroli village','vikhroli west','400083',2),
 (55,'Vikhroli village','vikhroli west','400083',2),
 (56,'Vikhroli village','vikhroli west','400083',2),
 (57,'Vikhroli village','vikhroli west','400083',2),
 (58,'Vikhroli village','vikhroli west','400083',2),
 (59,'bldg no 3','sector 17','400079',1),
 (60,'Satmesar','Bardiha','400078',1),
 (61,'Vikhroli','Village','400079',1);
/*!40000 ALTER TABLE `tbl_address` ENABLE KEYS */;


--
-- Definition of table `tbl_city`
--

DROP TABLE IF EXISTS `tbl_city`;
CREATE TABLE `tbl_city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_city`
--

/*!40000 ALTER TABLE `tbl_city` DISABLE KEYS */;
INSERT INTO `tbl_city` (`id`,`name`,`state_id`) VALUES 
 (1,'Chandigarh',1),
 (2,'Ludhiyana',1);
/*!40000 ALTER TABLE `tbl_city` ENABLE KEYS */;


--
-- Definition of table `tbl_cybercafe`
--

DROP TABLE IF EXISTS `tbl_cybercafe`;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cybercafe`
--

/*!40000 ALTER TABLE `tbl_cybercafe` DISABLE KEYS */;
INSERT INTO `tbl_cybercafe` (`id`,`name`,`phone_no`,`address_id`,`updated_on`,`status_id`,`user_id`) VALUES 
 (1,'Macros','9819034283',1,'2015-06-27 19:17:07',2,1),
 (3,'Bingo','9967071203',4,'2015-09-05 19:49:04',2,3),
 (4,'Bablu','09664270556',5,'2015-09-05 20:00:24',2,4);
/*!40000 ALTER TABLE `tbl_cybercafe` ENABLE KEYS */;


--
-- Definition of table `tbl_id_card_type`
--

DROP TABLE IF EXISTS `tbl_id_card_type`;
CREATE TABLE `tbl_id_card_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_id_card_type`
--

/*!40000 ALTER TABLE `tbl_id_card_type` DISABLE KEYS */;
INSERT INTO `tbl_id_card_type` (`id`,`name`) VALUES 
 (1,'Election ID'),
 (2,'Pan Card'),
 (3,'Aadhar Card'),
 (4,'Passport'),
 (5,'College ID'),
 (6,'School ID');
/*!40000 ALTER TABLE `tbl_id_card_type` ENABLE KEYS */;


--
-- Definition of table `tbl_session`
--

DROP TABLE IF EXISTS `tbl_session`;
CREATE TABLE `tbl_session` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `visitor_id` int(10) unsigned NOT NULL,
  `updated_on` datetime NOT NULL,
  `updated_by` int(10) unsigned NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` int(10) unsigned NOT NULL,
  `cybercafe_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_session_1` (`visitor_id`),
  KEY `FK_tbl_session_2` (`cybercafe_id`),
  CONSTRAINT `FK_tbl_session_1` FOREIGN KEY (`visitor_id`) REFERENCES `tbl_visitor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_session_2` FOREIGN KEY (`cybercafe_id`) REFERENCES `tbl_cybercafe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_session`
--

/*!40000 ALTER TABLE `tbl_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_session` ENABLE KEYS */;


--
-- Definition of table `tbl_session_system_usage`
--

DROP TABLE IF EXISTS `tbl_session_system_usage`;
CREATE TABLE `tbl_session_system_usage` (
  `session_id` int(10) unsigned NOT NULL,
  `system_usage_id` int(10) unsigned NOT NULL,
  KEY `FK_tbl_session_system_usage_1` (`session_id`),
  KEY `FK_tbl_session_system_usage_2` (`system_usage_id`),
  CONSTRAINT `FK_tbl_session_system_usage_1` FOREIGN KEY (`session_id`) REFERENCES `tbl_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_session_system_usage_2` FOREIGN KEY (`system_usage_id`) REFERENCES `tbl_system_usage` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_session_system_usage`
--

/*!40000 ALTER TABLE `tbl_session_system_usage` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_session_system_usage` ENABLE KEYS */;


--
-- Definition of table `tbl_state`
--

DROP TABLE IF EXISTS `tbl_state`;
CREATE TABLE `tbl_state` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_state`
--

/*!40000 ALTER TABLE `tbl_state` DISABLE KEYS */;
INSERT INTO `tbl_state` (`id`,`name`) VALUES 
 (1,'Punjab');
/*!40000 ALTER TABLE `tbl_state` ENABLE KEYS */;


--
-- Definition of table `tbl_status`
--

DROP TABLE IF EXISTS `tbl_status`;
CREATE TABLE `tbl_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_status`
--

/*!40000 ALTER TABLE `tbl_status` DISABLE KEYS */;
INSERT INTO `tbl_status` (`id`,`name`) VALUES 
 (1,'Active'),
 (2,'Inactive');
/*!40000 ALTER TABLE `tbl_status` ENABLE KEYS */;


--
-- Definition of table `tbl_system`
--

DROP TABLE IF EXISTS `tbl_system`;
CREATE TABLE `tbl_system` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `serial` varchar(100) DEFAULT NULL,
  `status_id` int(10) unsigned NOT NULL,
  `cybercafe_id` int(10) unsigned NOT NULL,
  `updated_on` datetime NOT NULL,
  `updated_by` int(10) unsigned NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_system_1` (`cybercafe_id`),
  KEY `FK_tbl_system_2` (`updated_by`),
  KEY `FK_tbl_system_3` (`status_id`) USING BTREE,
  CONSTRAINT `FK_tbl_system_1` FOREIGN KEY (`cybercafe_id`) REFERENCES `tbl_cybercafe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_system_2` FOREIGN KEY (`updated_by`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_system_3` FOREIGN KEY (`status_id`) REFERENCES `tbl_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_system`
--

/*!40000 ALTER TABLE `tbl_system` DISABLE KEYS */;
INSERT INTO `tbl_system` (`id`,`name`,`serial`,`status_id`,`cybercafe_id`,`updated_on`,`updated_by`,`is_occupied`) VALUES 
 (1,'System111111','453722',1,1,'2017-01-28 07:27:38',1,0),
 (2,'System2','1234',1,1,'2017-01-26 20:40:53',1,0),
 (3,'System3',NULL,1,1,'2017-01-26 20:43:33',1,0),
 (4,NULL,NULL,1,1,'2017-01-26 21:02:43',1,0),
 (5,NULL,NULL,1,1,'2017-01-26 21:04:55',1,0),
 (6,NULL,NULL,1,1,'2017-01-26 21:14:27',1,0),
 (7,NULL,NULL,1,1,'2017-01-26 21:14:31',1,0),
 (8,NULL,NULL,1,1,'2017-01-26 21:15:59',1,0),
 (9,NULL,NULL,1,1,'2017-01-26 21:16:03',1,0),
 (10,NULL,NULL,1,1,'2017-01-26 21:50:58',1,0),
 (11,'aaa',NULL,1,1,'2017-01-26 21:55:00',1,0),
 (12,'sddddd','ddd',1,1,'2017-01-26 21:58:10',1,0),
 (13,'system','sss',1,3,'2017-01-26 22:00:57',1,0);
/*!40000 ALTER TABLE `tbl_system` ENABLE KEYS */;


--
-- Definition of table `tbl_system_usage`
--

DROP TABLE IF EXISTS `tbl_system_usage`;
CREATE TABLE `tbl_system_usage` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `session_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_system_usage_1` (`session_id`),
  CONSTRAINT `FK_tbl_system_usage_1` FOREIGN KEY (`session_id`) REFERENCES `tbl_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_system_usage`
--

/*!40000 ALTER TABLE `tbl_system_usage` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_system_usage` ENABLE KEYS */;


--
-- Definition of table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` (`id`,`username`,`password`,`email`,`first_name`,`last_name`,`updated_on`,`random_uuid`,`status_id`) VALUES 
 (1,'brajbhar','9c408ed1f921b37d54ccfcb3e11072c9','bablu.rajbhar87@gmail.com','Bablu','Rajbhar','2015-06-27 19:17:07','3ef5f5a2-1c11-4cff-be49-f9f98f6675b0',2),
 (3,'bablu','9c408ed1f921b37d54ccfcb3e11072c9','juhi.bhardwaj54@gmail.com1','Bablu','Rajbhar','2015-09-05 19:49:04','1ee38d14-d13f-4ce2-9ddd-55c7fc73b91d',2),
 (4,'bablu1','9c408ed1f921b37d54ccfcb3e11072c9','juhi.bhardwaj54@gmail.com','Bablur','Rajbhar','2015-09-05 20:00:24','fee5700c-80d8-49f3-8cd9-f4a13717a8f5',2);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;


--
-- Definition of table `tbl_visitor`
--

DROP TABLE IF EXISTS `tbl_visitor`;
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
  `updated_by` int(10) unsigned DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_visitor_2` (`cybercafe_id`),
  KEY `FK_tbl_visitor_3` (`id_card_type`),
  KEY `FK_tbl_visitor_1` (`address_id`),
  CONSTRAINT `FK_tbl_visitor_1` FOREIGN KEY (`address_id`) REFERENCES `tbl_address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_visitor_2` FOREIGN KEY (`cybercafe_id`) REFERENCES `tbl_cybercafe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_visitor_3` FOREIGN KEY (`id_card_type`) REFERENCES `tbl_id_card_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_visitor`
--

/*!40000 ALTER TABLE `tbl_visitor` DISABLE KEYS */;
INSERT INTO `tbl_visitor` (`id`,`first_name`,`last_name`,`age`,`sex`,`address_id`,`mobile`,`cybercafe_id`,`id_card_number`,`id_card_type`,`updated_by`,`updated_on`) VALUES 
 (1,'Bablu','Rajbhar',29,'Male',58,'9819034283',1,'12345645',1,NULL,'2017-01-26 20:39:29'),
 (2,'Sudhir','Rajbhar',17,'Male',59,'9967071203',1,'40078',1,NULL,'2017-01-26 20:39:34'),
 (3,'Shivansh','Rajbhar',3,'Male',61,'9967071203',1,'4567891',2,NULL,'2017-01-26 20:39:57'),
 (4,'Ashish','Rajbhar',18,'Male',42,'9819034283',1,'400078',1,NULL,'2016-08-07 09:13:24'),
 (5,'Sandip','Rajbhar',20,'Male',60,'9819034283',1,'400078',3,NULL,'2017-01-26 20:39:38'),
 (6,'Pradeep','Rajbhar',20,'Male',19,'9819034283',1,'45212',3,NULL,'2016-06-23 22:16:45'),
 (7,'Deepika','Rajbhar',18,'Female',47,'9819034283',1,'45487779',1,NULL,'2016-09-04 17:55:38'),
 (8,'Khushi','Rajbhar',5,'Female',48,'9819034283',1,'5656464',1,NULL,'2016-09-04 17:58:40'),
 (9,'Amod','Maroly',25,'Male',49,'9967071203',1,'4556',1,NULL,'2016-09-04 18:05:13'),
 (10,'Indra','Goel',32,'Male',50,'9819034283',1,'7844878',1,NULL,'2016-09-04 18:08:06');
/*!40000 ALTER TABLE `tbl_visitor` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
