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
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs` (
  `code` varchar(25) NOT NULL,
  `ownerNo` int(11) NOT NULL,
  `staffNo` int(11) NOT NULL,
  `invoiceNo` int(11) DEFAULT NULL,
  `shelf` varchar(45) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `priority` smallint(6) DEFAULT NULL,
  `discountRate` float DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `specialInstructions` text,
  `dateCreated` datetime DEFAULT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_Jobs_Staff_idx` (`staffNo`),
  KEY `fk_Jobs_Customers1_idx` (`ownerNo`),
  KEY `fk_jobs_invoice1_idx` (`invoiceNo`),
  CONSTRAINT `fk_Jobs_Customers1` FOREIGN KEY (`ownerNo`) REFERENCES `customers` (`accountNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jobs_Staff` FOREIGN KEY (`staffNo`) REFERENCES `staff` (`staffNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jobs_invoice1` FOREIGN KEY (`invoiceNo`) REFERENCES `invoices` (`invoiceNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES ('ASL123',10,16,45,'JKJ909',0,0,0,20,'Nothing!','2018-04-19 02:23:47'),('BM101',7,13,43,'SHLF01',0,0,0,58,'Do it quick','2018-04-18 02:04:46'),('FHGH202',10,16,46,'AS010',0,0,0,450,'Take your time','2018-04-19 02:27:30'),('HFHFJ',10,16,45,'123J',0,0,0,11,'n/a','2018-04-19 02:25:25'),('HG100',8,13,42,'LO202',0,0,0,33,'nothing!','2018-04-18 12:12:30'),('JF123',7,16,43,'shelfNo',0,0,0,59,'test','2018-04-17 19:01:17'),('JG987',8,16,42,'shelfNo',0,0,0,110,'URGENT',NULL),('JH404',7,16,43,'shelfNo',0,0,0,0,'not found','2018-04-17 19:00:59'),('JL900',6,13,41,'shelfNo',0,0,0,135,'Make copy of each',NULL),('JL909',9,16,44,'shelfNo',0,0,0,77,'test',NULL);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
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
