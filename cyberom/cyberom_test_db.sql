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
-- Create schema db_cyberom_test
--

CREATE DATABASE IF NOT EXISTS db_cyberom_test;
USE db_cyberom_test;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_address`
--

/*!40000 ALTER TABLE `tbl_address` DISABLE KEYS */;
INSERT INTO `tbl_address` (`id`,`address_line1`,`address_line2`,`pin_no`,`city_id`) VALUES 
 (1,'shop no 2','station road','400079',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_city`
--

/*!40000 ALTER TABLE `tbl_city` DISABLE KEYS */;
INSERT INTO `tbl_city` (`id`,`name`,`state_id`) VALUES 
 (1,'Mohali',1),
 (2,'Mumbai',2),
 (3,'Pune',2),
 (4,'Nasik',2),
 (5,'Thane',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cybercafe`
--

/*!40000 ALTER TABLE `tbl_cybercafe` DISABLE KEYS */;
INSERT INTO `tbl_cybercafe` (`id`,`name`,`phone_no`,`address_id`,`updated_on`,`status_id`,`user_id`) VALUES 
 (1,'Macros','25746596',1,'2017-03-19 21:05:46',2,1),
 (2,'Surabhi','32427479',1,'2017-03-19 21:05:46',2,1);
/*!40000 ALTER TABLE `tbl_cybercafe` ENABLE KEYS */;


--
-- Definition of table `tbl_id_card_type`
--

DROP TABLE IF EXISTS `tbl_id_card_type`;
CREATE TABLE `tbl_id_card_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_id_card_type`
--

/*!40000 ALTER TABLE `tbl_id_card_type` DISABLE KEYS */;
INSERT INTO `tbl_id_card_type` (`id`,`name`) VALUES 
 (1,'Election ID'),
 (2,'Pan Card'),
 (3,'Aadhar Card');
/*!40000 ALTER TABLE `tbl_id_card_type` ENABLE KEYS */;


--
-- Definition of table `tbl_session`
--

DROP TABLE IF EXISTS `tbl_session`;
CREATE TABLE `tbl_session` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `visitor_id` int(10) unsigned NOT NULL,
  `updated_on` datetime NOT NULL,
  `updated_by` int(10) unsigned NOT NULL,
  `created_on` datetime NOT NULL,
  `cybercafe_id` int(10) unsigned NOT NULL,
  `session_status_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_session_1` (`visitor_id`),
  KEY `FK_tbl_session_2` (`cybercafe_id`),
  KEY `FK_tbl_session_3` (`session_status_id`),
  CONSTRAINT `FK_tbl_session_1` FOREIGN KEY (`visitor_id`) REFERENCES `tbl_visitor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_session_2` FOREIGN KEY (`cybercafe_id`) REFERENCES `tbl_cybercafe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_session_3` FOREIGN KEY (`session_status_id`) REFERENCES `tbl_session_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_session`
--

/*!40000 ALTER TABLE `tbl_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_session` ENABLE KEYS */;


--
-- Definition of table `tbl_session_status`
--

DROP TABLE IF EXISTS `tbl_session_status`;
CREATE TABLE `tbl_session_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_session_status`
--

/*!40000 ALTER TABLE `tbl_session_status` DISABLE KEYS */;
INSERT INTO `tbl_session_status` (`id`,`name`) VALUES 
 (1,'New'),
 (2,'In Progress'),
 (3,'Completed');
/*!40000 ALTER TABLE `tbl_session_status` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_state`
--

/*!40000 ALTER TABLE `tbl_state` DISABLE KEYS */;
INSERT INTO `tbl_state` (`id`,`name`) VALUES 
 (1,'Punjab'),
 (2,'Maharashtra'),
 (3,'Gujarat'),
 (4,'Madhya Pradesh'),
 (5,'Rajasthan');
/*!40000 ALTER TABLE `tbl_state` ENABLE KEYS */;


--
-- Definition of table `tbl_status`
--

DROP TABLE IF EXISTS `tbl_status`;
CREATE TABLE `tbl_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
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
  `is_occupied` tinyint(1) DEFAULT NULL,
  `cybercafe_id` int(10) unsigned NOT NULL,
  `updated_on` datetime NOT NULL,
  `updated_by` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_system_1` (`cybercafe_id`),
  KEY `FK_tbl_system_2` (`updated_by`),
  KEY `FK_tbl_system_3` (`status_id`) USING BTREE,
  CONSTRAINT `FK_tbl_system_1` FOREIGN KEY (`cybercafe_id`) REFERENCES `tbl_cybercafe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_system_2` FOREIGN KEY (`updated_by`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_system_3` FOREIGN KEY (`status_id`) REFERENCES `tbl_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_system`
--

/*!40000 ALTER TABLE `tbl_system` DISABLE KEYS */;
INSERT INTO `tbl_system` (`id`,`name`,`serial`,`status_id`,`is_occupied`,`cybercafe_id`,`updated_on`,`updated_by`) VALUES 
 (1,'System1','ABC',1,0,1,'2016-06-23 22:16:45',1),
 (2,'System2','EFG',1,0,1,'2016-06-23 22:16:45',1),
 (3,'System3','HIJ',1,0,1,'2016-06-23 22:16:45',1),
 (4,'System4','KLM',1,0,1,'2016-06-23 22:16:45',1),
 (5,'System5','NOP',1,0,1,'2016-06-23 22:16:45',1),
 (6,'System6','QRS',1,0,1,'2016-06-23 22:16:45',1),
 (7,'System7','TUV',1,0,1,'2016-06-23 22:16:45',1),
 (8,'System8','WXY',1,0,1,'2016-06-23 22:16:45',1),
 (9,'System9','ZAB',1,0,1,'2016-06-23 22:16:45',1),
 (10,'System10','CDF',1,0,1,'2016-06-23 22:16:45',1);
/*!40000 ALTER TABLE `tbl_system` ENABLE KEYS */;


--
-- Definition of table `tbl_system_usage`
--

DROP TABLE IF EXISTS `tbl_system_usage`;
CREATE TABLE `tbl_system_usage` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `system_id` int(10) unsigned NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_system_usage_1` (`system_id`),
  CONSTRAINT `FK_tbl_system_usage_1` FOREIGN KEY (`system_id`) REFERENCES `tbl_system` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` (`id`,`username`,`password`,`email`,`first_name`,`last_name`,`updated_on`,`random_uuid`,`status_id`) VALUES 
 (1,'bablur','password_123','bablu.rajbhar87@gmail.com','bablu','rajbhar','2017-03-19 21:05:46',NULL,2);
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
  `updated_on` datetime NOT NULL,
  `updated_by` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_visitor_2` (`cybercafe_id`),
  KEY `FK_tbl_visitor_3` (`id_card_type`),
  KEY `FK_tbl_visitor_1` (`address_id`),
  CONSTRAINT `FK_tbl_visitor_1` FOREIGN KEY (`address_id`) REFERENCES `tbl_address` (`id`),
  CONSTRAINT `FK_tbl_visitor_2` FOREIGN KEY (`cybercafe_id`) REFERENCES `tbl_cybercafe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbl_visitor_3` FOREIGN KEY (`id_card_type`) REFERENCES `tbl_id_card_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_visitor`
--

/*!40000 ALTER TABLE `tbl_visitor` DISABLE KEYS */;
INSERT INTO `tbl_visitor` (`id`,`first_name`,`last_name`,`age`,`sex`,`address_id`,`mobile`,`cybercafe_id`,`id_card_number`,`id_card_type`,`updated_on`,`updated_by`) VALUES 
 (1,'Bablu','Rajbhar',29,'Male',1,'9819034283',1,'1234567',1,'2016-07-10 23:20:00',NULL),
 (2,'Sudhir','Rajbhar',17,'Male',1,'9967071203',1,'40078',1,'2016-07-10 23:22:09',NULL),
 (3,'Shivansh','Rajbhar',3,'Male',1,'9967071203',1,'456789',2,'2016-07-10 23:16:31',NULL),
 (4,'Ashish','Rajbhar',18,'Male',1,'9819034283',1,'400078',1,'2016-07-10 22:21:03',NULL),
 (5,'Sandip','Rajbhar',20,'Male',1,'9819034283',1,'400078',3,'2016-06-19 17:15:09',NULL),
 (6,'Pradeep','Rajbhar',20,'Male',1,'9819034283',1,'45212',3,'2016-06-23 22:16:45',NULL),
 (7,'Amit','Rajbhar',29,'Male',1,'9819034283',1,'6483837',1,'2016-07-10 23:20:00',NULL),
 (8,'Sumit','Rajbhar',17,'Male',1,'9967071203',1,'638393',1,'2016-07-10 23:22:09',NULL),
 (9,'Ganesh','Rajbhar',3,'Male',1,'9967071203',1,'1214253',2,'2016-07-10 23:16:31',NULL),
 (10,'Ramesh','Rajbhar',18,'Male',1,'9819034283',1,'363839',1,'2016-07-10 22:21:03',NULL),
 (11,'Shivam','Rajbhar',20,'Male',1,'9819034283',1,'363920',3,'2016-06-19 17:15:09',NULL),
 (12,'Naresh','Rajbhar',20,'Male',1,'9819034283',1,'342730',3,'2016-06-23 22:16:45',NULL);
/*!40000 ALTER TABLE `tbl_visitor` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
