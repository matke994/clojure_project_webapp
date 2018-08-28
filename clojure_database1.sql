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
/*Table structure for table `file` */

CREATE TABLE `file` (
  `FILE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(100) NOT NULL,
  `FILE_SIZE` varchar(100) NOT NULL,
  `IMPORT_DATE` date NOT NULL,
  PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `file` */

insert  into `file`(`FILE_ID`,`FILE_NAME`,`FILE_SIZE`,`IMPORT_DATE`) values 
(1,'aaa','33','2018-08-12');

/*Table structure for table `transaction` */

CREATE TABLE `transaction` (
  `TXN_ID` int(10) NOT NULL AUTO_INCREMENT,
  `TXN_TYPE` int(3) NOT NULL,
  `PAN` varchar(19) NOT NULL,
  `ACQ_BIN` varchar(26) NOT NULL,
  `TXN_ONLINE_DATE` date NOT NULL,
  `TXN_AMOUNT` double NOT NULL,
  `TXN_CURRENCY` varchar(3) NOT NULL,
  `FILE_ID` int(10) NOT NULL,
  PRIMARY KEY (`TXN_ID`),
  KEY `file_fk` (`FILE_ID`),
  CONSTRAINT `file_fk` FOREIGN KEY (`FILE_ID`) REFERENCES `file` (`FILE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `transaction` */

insert  into `transaction`(`TXN_ID`,`TXN_TYPE`,`PAN`,`ACQ_BIN`,`TXN_ONLINE_DATE`,`TXN_AMOUNT`,`TXN_CURRENCY`,`FILE_ID`) values 
(1,222,'333','555b','2018-08-12',350,'123',1),
(2,555,'666','777','2018-08-12',333,'666',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
