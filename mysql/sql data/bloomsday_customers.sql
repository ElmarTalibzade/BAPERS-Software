-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bloomsday
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `accountNo` int(11) NOT NULL AUTO_INCREMENT,
  `holderName` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `isValued` tinyint(1) DEFAULT '0',
  `isSuspended` tinyint(1) DEFAULT '0',
  `isDefault` tinyint(1) DEFAULT '0',
  `address` varchar(45) DEFAULT NULL,
  `phoneNo` varchar(45) DEFAULT NULL,
  `discountType` smallint(6) NOT NULL,
  `discountRate` double DEFAULT '0',
  `emailAddress` varchar(45) DEFAULT NULL,
  `debtRemindedAmount` int(2) DEFAULT '0',
  PRIMARY KEY (`accountNo`),
  UNIQUE KEY `accountNo_UNIQUE` (`accountNo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (6,'City, University London','David','Rhind',1,0,0,'Northampton Square, London EC1V 0HB','0207 040 8000',2,1,'david.rhind@city.ac.uk',0),(7,'InfoPharma Ltd','Alex','Wright',1,0,0,'25, Bond Street, London WC1V 8LS','0207 321 8001',1,NULL,'alex.wright@infopharma.com',0),(8,'Hello Magazine','Sarah','Brocklehurst',0,1,0,'12 Bond Street, London WC1V 8NS','0203 456 7809',1,NULL,'sarah.brocklehurst@hello.com',0),(9,'Ms Eva Bauyer','Eva','Bauyer',1,0,0,'1, Liverpool street, London EC2V 8NS','0208 555 8989',2,3,'eva.bauyer@gmail.com',0),(10,'Amazon Ltd','John','Bezos',0,0,0,'Amazon street','7439-52423-22',0,0,'amazon@amazon',0);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-19  2:33:09
