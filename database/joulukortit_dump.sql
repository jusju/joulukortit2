-- MySQL dump 10.15  Distrib 10.0.31-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: joulukortit
-- ------------------------------------------------------
-- Server version	10.0.31-MariaDB-0ubuntu0.16.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `joulukortit`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `joulukortit` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `joulukortit`;

--
-- Table structure for table `Osoitteet`
--

DROP TABLE IF EXISTS `Osoitteet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Osoitteet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nimi` varchar(255) NOT NULL,
  `katuosoite` varchar(255) NOT NULL,
  `postinumero` varchar(10) NOT NULL,
  `postitoimipaikka` varchar(255) NOT NULL,
  `osavaltio` varchar(255) NOT NULL,
  `maa` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Osoitteet`
--

LOCK TABLES `Osoitteet` WRITE;
/*!40000 ALTER TABLE `Osoitteet` DISABLE KEYS */;
INSERT INTO `Osoitteet` VALUES (2,'Sakari ja Leila Lukkarinen','Ojahaantie 8 B 28','01600','Vantaa','Uusimaa','FINLAND'),(3,'Minna ja Mikko Minkkinen','Lauttasaarentie 38 C 26','00200','Helsinki','Uusimaa','FINLAND'),(4,'Kirsi Makkonen perheineen','Akselinkatu 3 B 11','57130','Savonlinna','Karjala','FINLAND'),(5,'Wayne and Tammy Cooke','11 Pinerock DR.','29690','Travelers Rest','SC','USA'),(6,'Tuija Auvinen','Lehikuja 10','13720','Parola','Häme','FINLAND'),(7,'Sami Itkonen','Mäenrinne 3-5 L 99','02160','Helsinki','Uusimaa','FINLAND'),(8,'Jane and Bill Helling','301 N. Grace Ave.','47933','Crawfordsville','IN','USA'),(9,'Simo ja Kaija Pihamaki','Korventie 281','05100','Roykka','Uusimaa','FINLAND'),(12,'Manis Shakirova','Vasilevskogo 14-27','153037','Ivanovo','','Russia'),(13,'&#1076;','','','','','');
/*!40000 ALTER TABLE `Osoitteet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `henkilo`
--

DROP TABLE IF EXISTS `henkilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `henkilo` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `etunimi` varchar(255) NOT NULL,
  `sukunimi` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `henkilo`
--

LOCK TABLES `henkilo` WRITE;
/*!40000 ALTER TABLE `henkilo` DISABLE KEYS */;
INSERT INTO `henkilo` VALUES (1,'Matti','Meikäläinen'),(2,'Mikko','Mallikas'),(3,'Outi','Opiskelija'),(4,'Tiina','Tikolainen'),(5,'oletusetunimi',''),(6,'oletusetunimi',''),(7,'oletusetunimi',''),(8,'oletusetunimi','');
/*!40000 ALTER TABLE `henkilo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-12 11:34:59
