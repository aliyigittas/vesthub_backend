CREATE DATABASE  IF NOT EXISTS `vesthub` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vesthub`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: vesthub
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `houseID` int NOT NULL,
  `date` varchar(100) NOT NULL,
  `ownerMail` varchar(100) NOT NULL,
  `clientMail` varchar(100) NOT NULL,
  `daytime` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `message` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,33,'2024-06-10','baranaslan@gmail.com','alitas@gmail.com','All','Waiting','Görüşmek istiyorum. '),(2,42,'2024-06-12','ekremyildirim@gmail.com','alitas@gmail.com','Morning','Accepted','Merhabalar, evinizi çok beğendim. Evi görmeyi çok isterim.'),(3,47,'2024-06-09','ekremyildirim@gmail.com','alitas@gmail.com','Evening','Accepted',''),(4,18,'2024-06-11','safakgun@gmail.com','baranaslan@gmail.com','All','Waiting',''),(5,2,'2024-06-14','turgutyilmaz@gmail.com','baranaslan@gmail.com','All','Waiting','Umarım evi gezdirme şansı bulabilirsiniz.'),(6,39,'2024-06-09','ekremyildirim@gmail.com','mehmetkuzucu@gmail.com','Evening','Waiting',''),(7,26,'2024-06-18','alitas@gmail.com','mehmetkuzucu@gmail.com','All','Waiting',''),(8,21,'2024-06-12','mehmetkuzucu@gmail.com','sevvalcetin@gmail.com','All','Waiting',''),(9,18,'2024-06-13','safakgun@gmail.com','sevvalcetin@gmail.com','All','Waiting',''),(10,5,'2024-06-09','turgutyilmaz@gmail.com','alitas@gmail.com','All','Waiting',''),(11,48,'2024-06-11','ekremyildirim@gmail.com','alitas@gmail.com','Afternoon','Waiting',''),(12,40,'2024-06-23','ekremyildirim@gmail.com','alitas@gmail.com','Morning','Waiting','');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-07 14:44:49
