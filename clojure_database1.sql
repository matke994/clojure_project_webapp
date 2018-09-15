/*
SQLyog Community
MySQL - 5.7.14 : Database - clojure_database1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `bank` */

CREATE TABLE `bank` (
  `bank_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `account` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `bank` */

insert  into `bank`(`bank_id`,`name`,`account`) values 
(1,'Intesa','155256565893214599'),
(2,'ProCredit','456598623651247577');

/*Table structure for table `customer` */

CREATE TABLE `customer` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`name`,`address`) values 
(1,'Nikola Matic','Mije Kovacevic 7a'),
(2,'Marko Matic','Mije Kovacevic 7b');

/*Table structure for table `customer_bank` */

CREATE TABLE `customer_bank` (
  `customer_id` varchar(100) NOT NULL,
  `bank_id` varchar(100) NOT NULL,
  PRIMARY KEY (`customer_id`,`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customer_bank` */

insert  into `customer_bank`(`customer_id`,`bank_id`) values 
('Marko Matic','Intesa');

/*Table structure for table `file` */

CREATE TABLE `file` (
  `file_id` int(10) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) NOT NULL,
  `file_size` varchar(100) NOT NULL,
  `import_date` date NOT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `file` */

insert  into `file`(`file_id`,`file_name`,`file_size`,`import_date`) values 
(1,'OUT_989100_37.base2','1024','2018-09-13');

/*Table structure for table `transaction` */

CREATE TABLE `transaction` (
  `txn_id` int(10) NOT NULL AUTO_INCREMENT,
  `txn_type` int(3) NOT NULL,
  `pan` varchar(19) NOT NULL,
  `acq_bin` varchar(26) NOT NULL,
  `txn_online_date` date NOT NULL,
  `txn_amount` double NOT NULL,
  `txn_currency` varchar(3) NOT NULL,
  `file_id` int(10) NOT NULL,
  `bank_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`txn_id`),
  KEY `file_fk` (`file_id`),
  KEY `bank_fk` (`bank_id`),
  CONSTRAINT `bank_fk` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`),
  CONSTRAINT `file_fk` FOREIGN KEY (`file_id`) REFERENCES `file` (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `transaction` */

insert  into `transaction`(`txn_id`,`txn_type`,`pan`,`acq_bin`,`txn_online_date`,`txn_amount`,`txn_currency`,`file_id`,`bank_id`) values 
(1,1,'155256565893214599','969100','2018-09-13',10000,'941',1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
