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
  `fullAddress` varchar(1000) NOT NULL,
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
  `ownerMail` varchar(100) NOT NULL,
  `uploadDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `houses`
--

LOCK TABLES `houses` WRITE;
/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` VALUES (1,7,'BEYLİKDÜZÜ SAFA DAN ADNAN KAHVECİDE HAVUZLU DENİZ MANZARALI 3+1','SAFA GAYRİMENKUL\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBEYLİKDÜZÜ ADNAN KAHVECİ MAHALLESİNDE ','Beylikdüzü','Beylikdüzü Organize Sanayi Bölgesi','Adnan Kahveci','Adnan Kahveci, Kafkas Cd. No:10, 34528 Beylikdüzü Organize Sanayi Bölgesi/Beylikdüzü/İstanbul, Türkiye',5249000,1,1,'2+1',75,40.99888032791223,28.621226471533216,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment','testtest@trest.com','2024-05-29 18:05:51'),(2,7,'FAİZLERE İNAT İLK EVİM KAMPANYASI! %40 PEŞİNATLA EV SAHİBİ OLUN','RESİMLER DAİRENİN BİRE BİR KENDİNE AİT OLUP FİRMA OLARAK GERÇEK DAİRE GERÇEK  İLAN !!\n\nLION YAPI & MİMARLIK \'DAN BÖLGENİN EMSALSİZ 2+1 SIFIR DAİRELERİ PROJEDE ARAKAT SEÇENEKLERİ BULUNMAKTADIR.\n\nİLK EVİNİ ALACAKLARA EXPER DEĞERİNİN %80\'E KADAR KREDİ İMKANI İLE FAYDALANABİLİRSİNİZ.\n\nYENİ YAPILACAK METRO PROJESİNE YAKIN\n\nDOĞAN ARASLI BULVARINA 10 DK MESAFEDE\n\nÇİFT KATLI 76D İETT HATTI - OTOBÜS VE MİNUBÜS HATLARI\n\nMETROBÜSE ULAŞIM TOPLU TAŞIMALAR İLE 5 DK MESAFEDE\n\nODA SAYISI: 2+1\n\n120M2 BRÜT\n\nKREDİYE UYGUN\n\n1 YIL İÇİN’DE %40 PRİM GARANTİSİ\n \nLION YAPI MİMARLIK KALİTESİ İLE SİZDE EV SAHİBİ OLUN','İstanbul','Esenyurt','Balıkyolu','Balıkyolu, 482. Sk. No:21, 34510 Esenyurt/İstanbul, Türkiye',1680000,1,1,'2+1',75,41.03928961898912,28.69126431333009,'Sale',0,2,5,0,0,0,0,0,0,0,0,0,0,'Available','Apartment','testtest@trest.com','2024-05-29 18:05:51'),(3,7,'Oyuncak müzesi','descriptionnnnnnn','İstanbul','Fatih','Yavuz Sultan Selim','Yavuz Sultan Selim, Abdülezelpaşa Cd. No:67, 34083 Fatih/İstanbul, Türkiye',1234578,1,1,'2+1',75,41.02772851470656,28.95654729786987,'Sale',0,2,5,1,1,0,1,0,0,1,1,0,1,'Available','Apartment','testtest@trest.com','2024-05-29 18:10:41');
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

-- Dump completed on 2024-05-30 12:40:33
