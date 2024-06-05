CREATE DATABASE  IF NOT EXISTS `vesthub` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vesthub`;
-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: vesthub
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `houses`
--

DROP TABLE IF EXISTS `houses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `houses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ownerID` int NOT NULL,
  `title` varchar(5000) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `city` varchar(45) NOT NULL,
  `distinct` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
  `country` varchar(45) NOT NULL,
  `fullAddress` varchar(1000) NOT NULL,
  `price` varchar(1000) NOT NULL,
  `numOfBathroom` int NOT NULL,
  `numOfBedroom` int NOT NULL,
  `numOfRooms` varchar(45) NOT NULL,
  `area` int NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `saleRent` varchar(45) NOT NULL,
  `approved` tinyint NOT NULL,
  `floor` int NOT NULL,
  `totalFloor` int NOT NULL,
  `fiberInternet` tinyint NOT NULL,
  `airConditioner` tinyint NOT NULL,
  `floorHeating` tinyint NOT NULL,
  `fireplace` tinyint NOT NULL,
  `terrace` tinyint NOT NULL,
  `satellite` tinyint NOT NULL,
  `parquet` tinyint NOT NULL,
  `steelDoor` tinyint NOT NULL,
  `furnished` tinyint NOT NULL,
  `insulation` tinyint NOT NULL,
  `status` varchar(45) NOT NULL,
  `houseType` varchar(45) NOT NULL,
  `ownerMail` varchar(100) NOT NULL,
  `uploadDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `houses`
--

LOCK TABLES `houses` WRITE;
/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` VALUES (1,1,'ev 1','ev 1 acıklama','İstanbul','Fatih','Cibali','Türkiye','Cibali, Kadir Has Cd. No:1, 34083 Fatih/İstanbul, Türkiye','660',1,1,'2+1',75,41.0251673,28.9588656,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Sold','Apartment','safak@f.com','2024-05-30 16:26:41'),(2,1,'ev 2','ev 2 acıklama','İstanbul','Fatih','Cibali','Türkiye','Cibali, Kadir Has Cd. No:1, 34083 Fatih/İstanbul, Türkiye','659997',1,1,'2+1',75,41.0251673,28.9588656,'Rent',0,2,5,1,1,1,0,1,1,0,1,1,1,'Rented','Apartment','safak@f.com','2024-05-30 16:27:10'),(3,1,'EVVVV','EVVVVVVVVVVVVVVVVV','İstanbul','Gaziosmanpaşa','255. Sokak','Türkiye','Hürriyet, 255. Sk. No:10, 34250 Gaziosmanpaşa/İstanbul, Türkiye','12345',2,2,'3+1',22,41.0659081,28.9002822,'Rent',0,2,2,0,1,1,1,1,1,1,0,0,0,'Available','Apartment','safak@f.com','2024-05-31 02:38:25'),(5,1,'Antalya Ev updated','lara ev','Antalya','Muratpaşa','Metin Kasapoğlu Caddesi','Türkiye','Yeşilbahçe, Metin Kasapoğlu Cd. No:46, 07160 Muratpaşa/Antalya, Türkiye','30000',2,2,'2+1',70,36.868124413471634,30.723379555078118,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment','safak@f.com','2024-05-31 18:34:06'),(6,1,'Antalya\'da bir ev','Deneme için bir ev','Antalya','Kaş','Likya Caddesi','Türkiye','Andifli, Likya Cd. No:41, 07580 Kaş/Antalya, Türkiye','1250000',2,12,'3+1',1212,36.20308320645206,29.639567332635515,'Rent',0,22,22,1,1,0,1,1,1,0,1,1,0,'Available','Apartment','safak@f.com','2024-06-04 12:52:05'),(7,7,'5Haziran ev deneme','EVİMİN DETAYLARI','İstanbul','Fatih','Topkapı Sarayı','Türkiye','Cankurtaran, Topkapı Sarayı No:22, 34122 Fatih/İstanbul, Türkiye','20000',3,4,'4+1',120,41.0115195,28.98337889999999,'Rent',0,3,5,0,0,0,0,0,0,0,0,0,0,'Pending','Villa','aliyigit@ali.com','2024-06-05 18:31:19');
/*!40000 ALTER TABLE `houses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-05 18:36:06
