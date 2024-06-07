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
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `houseID` int unsigned NOT NULL,
  `pixels` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,'1&0.txt'),(1,'1&1.txt'),(1,'1&2.txt'),(1,'1&3.txt'),(1,'1&4.txt'),(2,'2&0.txt'),(2,'2&1.txt'),(2,'2&2.txt'),(2,'2&3.txt'),(2,'2&4.txt'),(2,'2&5.txt'),(3,'3&0.txt'),(3,'3&1.txt'),(3,'3&2.txt'),(3,'3&3.txt'),(3,'3&4.txt'),(4,'4&0.txt'),(4,'4&1.txt'),(4,'4&2.txt'),(4,'4&3.txt'),(4,'4&4.txt'),(4,'4&5.txt'),(5,'5&0.txt'),(5,'5&1.txt'),(5,'5&2.txt'),(5,'5&3.txt'),(6,'6&0.txt'),(6,'6&1.txt'),(6,'6&2.txt'),(6,'6&3.txt'),(6,'6&4.txt'),(7,'7&0.txt'),(7,'7&1.txt'),(7,'7&2.txt'),(8,'8&0.txt'),(8,'8&1.txt'),(8,'8&2.txt'),(8,'8&3.txt'),(9,'9&0.txt'),(9,'9&1.txt'),(9,'9&2.txt'),(9,'9&3.txt'),(10,'10&0.txt'),(10,'10&1.txt'),(10,'10&2.txt'),(10,'10&3.txt'),(11,'11&0.txt'),(11,'11&1.txt'),(11,'11&2.txt'),(12,'12&0.txt'),(12,'12&1.txt'),(12,'12&2.txt'),(13,'13&0.txt'),(13,'13&1.txt'),(13,'13&2.txt'),(14,'14&0.txt'),(14,'14&1.txt'),(14,'14&2.txt'),(15,'15&0.txt'),(15,'15&1.txt'),(15,'15&2.txt'),(15,'15&3.txt'),(16,'16&0.txt'),(16,'16&1.txt'),(16,'16&2.txt'),(16,'16&3.txt'),(17,'17&0.txt'),(17,'17&1.txt'),(17,'17&2.txt'),(17,'17&3.txt'),(18,'18&0.txt'),(18,'18&1.txt'),(18,'18&2.txt'),(19,'19&0.txt'),(19,'19&1.txt'),(19,'19&2.txt'),(19,'19&3.txt'),(20,'20&0.txt'),(20,'20&1.txt'),(20,'20&2.txt'),(20,'20&3.txt'),(21,'21&0.txt'),(21,'21&1.txt'),(21,'21&2.txt'),(22,'22&0.txt'),(22,'22&1.txt'),(22,'22&2.txt'),(23,'23&0.txt'),(23,'23&1.txt'),(23,'23&2.txt'),(23,'23&3.txt'),(24,'24&0.txt'),(24,'24&1.txt'),(24,'24&2.txt'),(24,'24&3.txt'),(25,'25&0.txt'),(25,'25&1.txt'),(25,'25&2.txt'),(26,'26&0.txt'),(26,'26&1.txt'),(26,'26&2.txt'),(27,'27&0.txt'),(27,'27&1.txt'),(27,'27&2.txt'),(28,'28&0.txt'),(28,'28&1.txt'),(28,'28&2.txt'),(29,'29&0.txt'),(29,'29&1.txt'),(29,'29&2.txt'),(30,'30&0.txt'),(30,'30&1.txt'),(30,'30&2.txt'),(31,'31&0.txt'),(31,'31&1.txt'),(31,'31&2.txt'),(32,'32&0.txt'),(32,'32&1.txt'),(32,'32&2.txt'),(33,'33&0.txt'),(33,'33&1.txt'),(33,'33&2.txt'),(34,'34&0.txt'),(34,'34&1.txt'),(34,'34&2.txt'),(35,'35&0.txt'),(35,'35&1.txt'),(35,'35&2.txt'),(35,'35&3.txt'),(36,'36&0.txt'),(36,'36&1.txt'),(36,'36&2.txt'),(36,'36&3.txt'),(37,'37&0.txt'),(37,'37&1.txt'),(37,'37&2.txt'),(38,'38&0.txt'),(38,'38&1.txt'),(38,'38&2.txt'),(39,'39&0.txt'),(39,'39&1.txt'),(39,'39&2.txt'),(40,'40&0.txt'),(40,'40&1.txt'),(40,'40&2.txt'),(41,'41&0.txt'),(41,'41&1.txt'),(41,'41&2.txt'),(41,'41&3.txt'),(42,'42&0.txt'),(42,'42&1.txt'),(42,'42&2.txt'),(43,'43&0.txt'),(43,'43&1.txt'),(43,'43&2.txt'),(44,'44&0.txt'),(44,'44&1.txt'),(44,'44&2.txt'),(45,'45&0.txt'),(45,'45&1.txt'),(45,'45&2.txt'),(46,'46&0.txt'),(46,'46&1.txt'),(46,'46&2.txt'),(46,'46&3.txt'),(47,'47&0.txt'),(47,'47&1.txt'),(47,'47&2.txt'),(47,'47&3.txt'),(48,'48&0.txt'),(48,'48&1.txt'),(48,'48&2.txt');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
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
