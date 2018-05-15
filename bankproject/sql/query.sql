/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bankProject` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bankProject`;

/*Table structure for table `card_balance` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `passport_number` int(11) DEFAULT NULL,
  `signup_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) references user(id),
  `card_number` int(11) NOT NULL,
  `balance` double DEFAULT -1,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `card_data`;

CREATE TABLE `card_data` (
  `card_id` int(11) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `signup_date` date DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  FOREIGN KEY (`card_id`) REFERENCES `card`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `transaction_history`;

CREATE TABLE `transaction_history` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `card_id` INT(11) DEFAULT NULL,
  `amount` INT(11) DEFAULT NULL,
  `transaction_type` VARCHAR(255) DEFAULT NULL, 
  PRIMARY KEY (`id`),
  FOREIGN KEY (`card_id`) REFERENCES `card`(`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
