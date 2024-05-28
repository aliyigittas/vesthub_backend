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
  `title` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  `city` varchar(45) NOT NULL,
  `distinct` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `fullAddress` varchar(500) NOT NULL,
  `price` int NOT NULL,
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `houses`
--

LOCK TABLES `houses` WRITE;
/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` VALUES (1,1,'EVVVVtitle','                <HomeModal show={show} setShow={() => setShow(false)} home={Home} />\n','Istanbul','Maltepe','Cinar','fullladresss',12345555,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,1,1,0,0,0,0,1,0,0,'Available','Apartment'),(2,1,'EVVVVtitle','                <HomeModal show={show} setShow={() => setShow(false)} home={Home} />\n','Istanbul','Maltepe','Cinar','fullladresss',12345555,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(3,1,'EVVVVtitle','                <HomeModal show={show} setShow={() => setShow(false)} home={Home} />\n','Istanbul','Maltepe','Cinar','fullladresss',12345555,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(4,1,'aaa','11','Istanbul','Maltepe','Cinar','a',2,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(5,1,'aaa','11','Istanbul','Maltepe','Cinar','a',2,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(6,1,'aaa','11','Istanbul','Maltepe','Cinar','a',2,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(7,1,'aaa','11','Istanbul','Maltepe','Cinar','a',2,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(8,0,'mehmet','woıuehfuhef','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',1000000,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(9,0,'mehmet','gjygyjgjhgjhg','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',1000000,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(10,0,'mehmet','gjygyjgjhgjhg','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',1000000,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(11,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(12,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(13,0,'hgahgds','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(14,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(15,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(16,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(17,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(18,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(19,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(20,0,'hhhghjg','jffjdfhhdfdfgfgd','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',5464,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(21,1,'27may','EV','Istanbul','Maltepe','Cinar','Hürriyet, 256. Sk. No:7, 34250 Gaziosmanpaşa/İstanbul, Türkiye',123444444,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(22,0,'27may','EV','Istanbul','Maltepe','Cinar','Hürriyet, 256. Sk. No:7, 34250 Gaziosmanpaşa/İstanbul, Türkiye',123444444,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(23,0,'28mayıs','okul','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',1234,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(24,0,'28mayıs','okul','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',1234,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment'),(25,0,'khas','okul','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',1234,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,1,1,1,0,0,1,1,1,1,0,'Available','Apartment'),(26,0,'khas','okul','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',1234,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,1,1,1,0,0,1,1,1,1,0,'Available','Apartment'),(27,0,'khas2','okul2','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',12342,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,1,1,0,1,0,1,1,1,1,0,'Available','Apartment'),(28,0,'khas2','okul2','Istanbul','Maltepe','Cinar','Cibali, Kadir Has Cd. NO:3/A, 34000 Fatih/İstanbul, Türkiye',12342,1,1,'2+1',75,45.2,45.2,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment');
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

-- Dump completed on 2024-05-28 11:19:12
