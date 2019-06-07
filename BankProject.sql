/*
SQLyog Community v11.51 (64 bit)
MySQL - 5.7.26-0ubuntu0.16.04.1 : Database - bankProject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bankProject` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bankProject`;

/*Table structure for table `card` */

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `card_type` enum('VISA','MASTER_CARD','DISCOVER') NOT NULL,
  `card_number` int(11) DEFAULT NULL,
  `pin` int(11) NOT NULL,
  `balance` double DEFAULT '-1',
  `signup_date` date DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_number` (`card_number`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `card_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `card` */

insert  into `card`(`id`,`user_id`,`card_type`,`card_number`,`pin`,`balance`,`signup_date`,`expire_date`) values (1,1,'VISA',134456,124,1000,'2018-05-24','2018-11-24');

/*Table structure for table `card_backup` */

DROP TABLE IF EXISTS `card_backup`;

CREATE TABLE `card_backup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `card_number` int(11) NOT NULL,
  `balance` double DEFAULT '-1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_number` (`card_number`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `card_backup_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `card_backup` */

insert  into `card_backup`(`id`,`user_id`,`card_number`,`balance`) values (2,1,12345,3000),(3,1,54321,1000),(4,1,70089,0),(5,2,20615,0),(6,1,48553,0);

/*Table structure for table `card_data` */

DROP TABLE IF EXISTS `card_data`;

CREATE TABLE `card_data` (
  `card_id` int(11) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `signup_date` date DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  KEY `card_id` (`card_id`),
  CONSTRAINT `card_data_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `card_backup` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `card_data` */

insert  into `card_data`(`card_id`,`pin`,`signup_date`,`expire_date`) values (2,123,'2018-05-15','2018-05-30'),(3,124,'2018-05-15','2018-06-14');

/*Table structure for table `transaction_history` */

DROP TABLE IF EXISTS `transaction_history`;

CREATE TABLE `transaction_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `transaction_type` enum('ADD','WITHDRAW') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `card_id` (`card_id`),
  CONSTRAINT `transaction_history_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `card_backup` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaction_history` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `passport_number` int(11) DEFAULT NULL,
  `signup_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`first_name`,`last_name`,`username`,`passport_number`,`signup_date`) values (1,'David','Ryan','dr3',123456789,'2018-05-15'),(2,'Adam','Alaba','adam_a123',0,'2018-05-24'),(3,'David','Freeman','kljasdf;kljasdf',987654321,'2018-05-24'),(4,'abcd','abcd','abc',123123123,'2019-01-21');

/*Table structure for table `user_data` */

DROP TABLE IF EXISTS `user_data`;

CREATE TABLE `user_data` (
  `id` int(11) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_data` */

insert  into `user_data`(`id`,`gender`,`birthdate`,`address`) values (1,'male','2001-11-12','6742 N. Richmond Ave. ');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
