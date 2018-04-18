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
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `taskID` int(11) NOT NULL AUTO_INCREMENT,
  `jobCode` varchar(25) NOT NULL,
  `assigneeId` int(11) DEFAULT NULL,
  `price` decimal(10,0) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `shelfSlot` varchar(45) DEFAULT NULL,
  `discountRate` float DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `department` smallint(6) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`taskID`),
  UNIQUE KEY `taskID_UNIQUE` (`taskID`),
  KEY `fk_tasks_jobs1_idx` (`jobCode`),
  KEY `fk_tasks_enum_departments1_idx` (`department`),
  KEY `fk_tasks_enum_status1_idx` (`status`),
  CONSTRAINT `fk_tasks_jobs1` FOREIGN KEY (`jobCode`) REFERENCES `jobs` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (15,'JL909',17,23,'','shelfNo',0,'2018-04-16 13:38:23','2018-04-16 13:39:38',2,2),(17,'JL900',17,35,'Make photos B/W','shelfNo',0,'2018-04-16 14:14:43','2018-04-16 14:16:23',1,2),(18,'JL900',19,100,'Pack into golden foil','shelfNo',0,'2018-04-16 14:15:14','2018-04-16 14:18:40',3,2),(20,'JG987',19,10,'Make photo b/w?','shelfNo',0,'2018-04-16 19:28:32','2018-04-16 19:37:44',1,2),(21,'JF123',18,59,'n/a','shelfNo',0,'2018-04-17 19:02:23','2018-04-17 19:02:55',0,2),(22,'BM101',NULL,13,'Pack it ','shelfNo',0,NULL,NULL,3,0),(23,'BM101',NULL,25,'Make 20 copies','shelfNo',0,NULL,NULL,0,0),(24,'BM101',NULL,20,'Make photos B/W','shelfNo',0,NULL,NULL,1,0),(25,'HG100',NULL,10,'Make photos b/w',NULL,0,NULL,NULL,1,0),(26,'HG100',NULL,23,'Pack it in golden foil',NULL,0,NULL,NULL,3,0);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-18 13:24:26
