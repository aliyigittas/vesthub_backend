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
  `country` varchar(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  `distinct` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `houses`
--

LOCK TABLES `houses` WRITE;
/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` VALUES (1,2,'Fırsat!Fiyat düştü.Kalkanda deniz manzaralı,2000m2 bahçeli villa','Kalkan İslamlarda sahibinden  satılık villa. Villanın imar barışı ve  yapı kayıt belgesi vardır. Kültür turizm bakanlığı tarafından ticari belge onayı mevcuttur. ( bu bölge için zor bir belge) Villamız Patara , Kalkan denizi ve orman manzarası bulunmaktadır. Hem ticari olarak kiralamaya hemde yaz kış oturmaya uygundur. Sezonda yüksek kira getirisi mevcut. Bu bölgede turizm  ruhsatı alınabilen nadir yapılardan  olup,   sorunsuz bir villadır.   iki dönümlük bakımlı bahçemizde  palmiye ve tropikal ağaçların yanı sıra zeytin, üzüm, incir ve nar gibi ağaçlar bulunmaktadır. Ev eşyalı verilecektir. ','Türkiye','Antalya','Kaş','İslamlar Köyü Yolu','Kalkan, İslamlar Köyü Yolu No:128, 07960 Kaş/Antalya, Türkiye','10750000',3,3,'4+1',145,36.31018100587012,29.420492243408205,'Sale',0,3,3,0,0,0,0,0,0,0,0,0,0,'Pending','Villa','sevvalcetin@gmail.com','2024-06-06 20:22:06'),(2,7,'Suadiye Sahil Taşyapı Kumru Yuvası Sitesi Bahçe Dubleksi','Sahibinden, Suadiye sahilinde bulunan Taşyapı Kumru Yuvası Sitesi içerisinde, çok nadir bulunan satılık bahçe dubleksi daire.\n\n**Özellikler:**\n\n- 7/24 güvenlik hem sahil cephesi hem bağdat caddesi giriş cephesi personel durmaktadır. Personeller özel bir güvenlik firması tarafından hizmet vermekte olup gündüz ve gece denetlenmektedirler.\n- Sabit apartman görevlisi (c blok\'ta bulunan kendine ait görevli dairesinde ailesi ile yaşamaktadır) sadece sabah servisi ve çöp toplama dışında gün içinde her an alışveriş, kuru temizlemeye kıyafet gönderme ve bunun gibi aklınıza gelebilecek her görevi yerine getirebilen kişisel asistan gibi çalışır ayrıca sitenin teknikeridir)\n- Bahçe peyzajını dışardan profesyonel bir peyzaj firması yönetmektedir.\n- Açık havuz ve sezlonglar (Sahil cephesinde) Havuz kenarı toplam 20 kişilik oturma alanı ve tam donanım ortak kullanıma açık mutfak\n- Kapalı ısıtmalı havuz (-1 otopark katında)\n- (-1 otopark katında) Spor salonu / Sauna / Duş,Tuvalet\n- Sosyal alan ve büyük bahçe\n- Site 20 daireden ve 3 bloktan oluşmaktadır\n- Dairemiz C bloktadır. Sitenin en çok güneş alan en değerli bahçe dubleksidir.\n- Siteyi elektrik kesintilerine karşı koruyup besleyebilecek jeneratör\n- Su kesintilerine karşı 1 hafta dayanabilecek su deposu\n- Bahçe sulaması için yağmur sularının biriktiği ayrı bir su deposu\n- 2 katlı ve girişi çıkışı çok rahat manevra yapılabilen otopark (istenmesi durumunda otopark yerinizin olduğu duvara elektrikli araçlar için duvar şarj unitesi takma imkanı)\n- Yalı parseli (sitenin önünden çıkış yaptıktan sonra sahil kısmında ufak bir özel marina bulunmaktadır. Ücreti karşılığı 14metreye kadar boyu olan bir tekneninizi bağlayabilirsiniz)\n- Dairenin yüksek arsa payına sahip olması\n- Dairelerin ısıtma sistemi her daireye özel kombi ile sağlanmaktadır. Kombiler otopark katında bulunan kazan dairesinde yer almakta olup daire içinde yer kaplamamaktadır.\n- Oturan tüm site sakinleri site yapıldığı günden beri sitede yaşıyordur.','Türkiye','İstanbul','Kadıköy','Yazmacı Tahir Sokak','Bostancı, Yazmacı Tahir Sk. No:15, 34744 Kadıköy/İstanbul, Türkiye','87500000',3,3,'4+1',350,40.956274949707016,29.08823502380369,'Sale',0,0,2,1,1,0,1,0,1,1,1,0,0,'Available','Apartment','turgutyilmaz@gmail.com','2024-06-06 20:58:09'),(3,7,'BUTİK SİTE İÇİ VİLLA TİPİ KIŞ BAHÇELİ 4+1 ARAÇ TAKASLI','mantıklı 1.500 1.600 civarı araç takası olur\n\n\n\nİÇ MİMARDAN ÖZEL DEKOR EDİLMİŞ !! \n\nKIŞ BAHÇELİ + 40 M2 MÜSTAKİL BAHÇELİ \n\n4+1 175 m2 \n\nANA CEDDEYE YAKIN MERKEZİ KONUMDA !!!\n\nDETAYLI BİLGİ İÇİN LÜTFEN ARAYIN !! \n\n\n\n\n\n           …BİR HAFTALIĞINA GEÇERLİ FİYAT…','Türkiye','İstanbul','Beykoz','Özlem Sokak','Gümüşsuyu, Özlem Sk. No:7, 34820 Beykoz/İstanbul, Türkiye','4799999',1,3,'4+1',160,41.132719,29.10569,'Sale',0,0,3,0,0,0,0,0,0,0,0,0,0,'Pending','Villa','turgutyilmaz@gmail.com','2024-06-06 21:02:26'),(4,7,'SAHİBİNDEN MALTEPE YALI SAHİLDE SATILIK 3+2 TERAS DUBLEKS','Dragos sahile 800 metre/10 dakika  yürüme mesafesindedir.\n\n\nİskanlı ve müstakil kat mülkiyeti tapusu vardır. \n\n\nSahibinden, komisyonsuz , kiracısız , boş.\n\n\n\n\n3+2 Çatı Dubleks 150 m2 net\n\n\nAlt Kat ; 2 Oda - Banyo - Açık Mutfaklı Salon - Giriş Holü - Balkon\n\n\nÜst Kat ; Geniş Ferah Yüksek Klimalı Salon - 1 Oda - Banyo - Teras - Çatı Arası Küçük Depo','Türkiye','İstanbul','Maltepe','Turgut Özal Bulvarı','Yalı, Turgut Özal Blv. No:261, 34844 Maltepe/İstanbul, Türkiye','7490000',2,2,'3+2',150,40.914217754562685,29.1335816793457,'Sale',0,7,8,0,0,0,0,0,0,0,0,0,0,'Available','Apartment','turgutyilmaz@gmail.com','2024-06-06 21:06:12'),(5,7,'SAHİBİNDEN METROBÜSE YAKIN KONUMDA 2+1 SİTE İÇİNDE SATILIK DAİRE','** ESENYURT  / CUMHURİYET MAHALLESİNDE \n\n\n** 2+1\n\n\n** ARAKAT \n\n\n** SİTE İÇERİSİNDE \n\n\n**AÇIK & KAPALI OTOPARK MEVCUT \n\n\n** OTURUMA HAZIR İÇİNDE KİRACI YOKTUR \n\n\n** KONUM İLE DAİRENİN ARASINDA 1 DK MEVCUTDUR ','Türkiye','İstanbul','Esenyurt','653. Sokak','Sultaniye, 653. Sk. No:1, 34510 Esenyurt/İstanbul, Türkiye','1300000',1,1,'2+1',95,41.038486162703144,28.685023266992165,'Sale',0,2,6,0,0,0,0,0,0,0,0,0,0,'Available','Apartment','turgutyilmaz@gmail.com','2024-06-06 21:12:20'),(6,7,'ACİL EŞYALI SİTEDE 3+1 DAİRE DENİZ VE HAVUZLU SİTE SAHİBİNDEN','PARKKOY YAKINI UYUM 2 SITESINDE MANZARA ANLAMINDA EN ONU ACIK DAIREDIR \n\nEVIMIZ TADILATLIDIR EVIMIZIN ISTENILDIGI TAKTIRDE ANLASMA DURUMUNDA CATI KATINI ODAYA CEVIRME ISLEMI UYGULANABILMEKTEDIR \n\nSITEMIZDE EMSALLERI VARDIR \n\nISTENIRSE BALKON USTUNE TERAS YAPILABILMEKTEDIR \n\nKIRALIK DEGILDIR LUTFEN SORMAYINIZ \n\nTUM ARACLARINIZ TAKASTA DEGERLENDIREBILIRIZ\n\nGAYRIMENKUL TAKASI UYGUN DEGILDIR \n\nEVIMIZDE SITEDE COGU EVDE OLMAYAN DOGALGAZ KOMBI SISTEMI MEVCUTTUR \n\nSOMINEMIZ FAALDIR \n\nEVIMIZ 4 DAIRELIK 2 KATLI BLOKLARDAN OLUSAN BIR SITE ICERISINDEDIR \n\nSILIVRININ EN BUYUK HAVUZLU SITESIDR ','Türkiye','İstanbul','Silivri','Alibey','Alibey, Terminal, 34570 Silivri/İstanbul, Türkiye','3490000',1,2,'3+1',130,41.07203076229863,28.26428633908691,'Sale',0,2,2,1,1,0,0,1,1,1,1,0,1,'Pending','Villa','turgutyilmaz@gmail.com','2024-06-06 21:17:15'),(7,7,'BOĞA\'YA RIHTIMA YAKIN FATURALAR DAHİL FULL EŞYALI 1+0 STÜDYO','BOĞAYA VE RIHTIMA ÇOK YAKIN\n\n\n· VAPUR,METRO,OTOBÜS DURAKLARINA 2 DK\n\n\n· METROBÜSE VE MARMARAYA İSE 5 DK YÜRÜME MESAFESİNDE\n\n\n\n· TÜM FATURALAR DAHİL EMLAK KOMİSYONU YOK\n','Türkiye','İstanbul','Kadıköy','Vahap Bey Sokak','Osmanağa, Vahap Bey Sk. No:11, 34714 Kadıköy/İstanbul, Türkiye','7000',1,1,'1+0',20,40.9914317,29.0270806,'Rent',0,0,4,0,0,0,0,0,0,0,0,0,0,'Available','Studio','turgutyilmaz@gmail.com','2024-06-06 21:23:11'),(8,7,'Maslak Agaoglu My Home Eşyalı 1+1 Kiralık','Taşınmaya hazır ve komple mobilyalı bu daire 09-05-2024 tarihinden itibaren müsait olacaktır.\n\nFor English support, please dial our office number.\n\nBlueground’la nerede yaşamayı seçerseniz orada kendinizi evinizde hissedin. Modern dekorlu, eksiksiz biçimde donatılmış mutfağı ve muhteşem manzarasına sahip huzurlu salonuyla bu ferah Maslak\'deki dayalı döşeli tek odalı daireyi çok seveceksiniz. İdeal konumu sayesinde Istanbul şehrinin size sunduğu her türlü avantaja yakınsınız! (ID #IST723)','Türkiye','İstanbul','Sarıyer','Maslak','Maslak, Ahi Evran Cd., 34485 Sarıyer/İstanbul, Türkiye','39990',1,1,'1+1',60,41.1121849,29.019965,'Rent',0,3,30,1,1,0,0,0,1,1,1,1,1,'Available','Studio','turgutyilmaz@gmail.com','2024-06-06 21:26:03'),(9,7,'İSTİNYEPARK TA KİRALIK 6+1 BAHÇE DUBLEKSİ','İstinye Park\n\n   residence\n\n\n\nİSTİNYE PARK EVLERİNDE SATILIK 1.FAZDA 6+1 BAHÇE DUBLEKS DAİRE\n\n','Türkiye','İstanbul','Sarıyer','Budak Sokak','Pınar, Budak Sk. No:10, 34460 Sarıyer/İstanbul, Türkiye','400000',4,5,'6+1',355,41.11465483422137,29.030290707409677,'Rent',0,0,5,1,1,1,1,1,1,1,1,0,1,'Available','Villa','turgutyilmaz@gmail.com','2024-06-06 21:29:44'),(10,2,'Memur evlerinde 3+1 kiralık daire','3.kat,140 m,güney batı cephe,3+1,pazara,okula,hastaneye,çarşıya,otobüs ve tramvay duraklarına yakın','Türkiye','Antalya','Muratpaşa','210. Sokak','Memurevleri, 210. Sk. No:6, 07050 Muratpaşa/Antalya, Türkiye','15000',1,1,'3+1',14,36.8963747,30.6897242,'Rent',0,3,5,1,1,0,0,0,1,1,1,0,0,'Available','Apartment','sevvalcetin@gmail.com','2024-06-06 21:47:55'),(11,2,'ELÇİ EMLAK\'TAN SATILIK AYRI MUTFAKLI İSKANLI ARA KAT 2+1 DAİRE','SATILIK\n\n“HEM YATIRIMLIK HEM OTURUMLUK”','Türkiye','Antalya','Finike','619. Sokak','Karşıyaka Mh., 619. Sk No:27, 07740 Finike/Antalya, Türkiye','3150000',2,2,'3+2',150,36.29200263719032,30.140458005249016,'Sale',0,1,6,0,0,0,0,0,1,1,1,0,1,'Available','Apartment','sevvalcetin@gmail.com','2024-06-06 21:50:44'),(12,2,'ÜNİVERSİTE YANI ÖĞRENCİYE UYGUN','Öğrenciye uygun\n\nÜniversiteye yürüme mesafesinde ','Türkiye','Antalya','Kepez','3718. Sokak','Gülveren, 3718. Sk. No:7, 07220 Bahtılı Köyü Köyü/Kepez/Antalya, Türkiye','12500',1,1,'1+0',45,36.90301754166873,30.646146867077626,'Rent',0,3,8,1,0,0,0,0,1,0,1,1,0,'Available','Studio','sevvalcetin@gmail.com','2024-06-06 21:52:42'),(13,2,'BAHÇELİ LÜKS VİLLA','\nBahçeli lüks doğayla iç içe\n\nKaçmaz fırsat','Türkiye','İstanbul','Beykoz','Kirazlı Yayla Caddesi','Gümüşsuyu, Kirazlı Yayla Cd. No:123, 34820 Beykoz/İstanbul, Türkiye','12500000',3,4,'5+1',250,41.12577998769162,29.11613381429442,'Sale',0,0,2,0,0,1,1,1,1,0,1,0,1,'Available','Villa','sevvalcetin@gmail.com','2024-06-06 21:55:30'),(14,3,'RİTİM İSTANBUL\'DA KİRALIK EŞYALI STÜDYO DAİRE','DETAYLI BİLGİ VE RANDEVU İÇİN ARAYINIZ','Türkiye','İstanbul','Maltepe','No:46','Cevizli, Zuhal Cd. No:46 D:F, 34846 Maltepe/İstanbul, Türkiye','18500',1,1,'1+0',25,40.92236284132584,29.157597669836427,'Rent',0,6,30,1,1,1,1,0,1,1,1,1,1,'Available','Apartment','safakgun@gmail.com','2024-05-06 22:37:36'),(15,3,'ANKARA ÇANKAYA\'DAN KAÇMAZ FIRSAT','METRO 5 DK.\nHASTANE 10 DK.\nAVM 5 DK.','Türkiye','Ankara','Çankaya','1551. Caddesi','Çiğdem, 1551. Cd. No:6, 06530 Çankaya/Ankara, Türkiye','4250000',2,2,'3+1',120,39.884676028953436,32.80363426796874,'Sale',0,3,5,0,0,0,0,0,1,1,1,0,0,'Available','Apartment','safakgun@gmail.com','2024-06-06 22:39:59'),(16,3,'LÜKS YAPILI FIRSAT EV','Duşakabin\n\nLüks yapılı\n\nAyrı mutfaklı','Türkiye','İstanbul','Beylikdüzü','No:6','Adnan Kahveci, Köpek Parkı, Kışla Cd. No:6, 34528 Beylikdüzü/İstanbul, Türkiye','18500',1,1,'2+1',90,41.010177723691534,28.63431144453126,'Rent',0,1,3,1,0,0,1,0,1,1,1,0,0,'Available','Apartment','safakgun@gmail.com','2024-06-06 22:42:16'),(17,3,'ETİMESGUT MERKEZDE HER YERE YAKIN','Paylaşımlı yaşama uygun','Türkiye','Ankara','Yenimahalle','Cengiz Aytmatov Caddesi','İnönü, Cengiz Aytmatov Cd No:16, 06370 Yenimahalle/Ankara, Türkiye','13000',1,2,'2+0',55,39.957729909359905,32.723672466308585,'Rent',0,2,6,1,0,0,0,0,1,0,1,0,0,'Available','Apartment','safakgun@gmail.com','2024-06-06 22:48:43'),(18,3,'ANTALYA KONYAALTI UNCALI 3M MİGROS YANI SATILIK HAVUZLU LÜKS 3+1 ARAKAT DAİRE','GÜNEY BATI KUZEY CEPHE\nUNCALI 3 M MİGROS YANI\nUNCALI CADDESİNE 50 M. MESAFEDE\nAYRI MUTFAKLI\nEBEVEYN BANYOLU','Türkiye','Antalya','Konyaaltı','24. Caddesi','Uncalı, 24. Cd. No:73, 07070 Bahtılı Köyü Köyü/Konyaaltı/Antalya, Türkiye','1850000',2,1,'3+1',140,36.8791228671955,30.62492583652343,'Sale',0,3,7,1,1,0,0,0,1,0,1,0,1,'Available','Apartment','safakgun@gmail.com','2024-06-06 22:51:34'),(19,5,'YILDIRIM BEYAZIT MAH. 5+1 KAPALI OTOPARK ULTRA LÜX SATILIK DAİRE','Oda Sayısı 5+1\n\nGiyinme Odası\n\nDaire 240 M2\'dir.\n\nSalon Ve Oturma Odasında Klima Mevcuttur.','Türkiye','Kayseri','Kocasinan','Atatürk Bulvarı','Hacı Saki, Atatürk Blv. No:65, 38010 Kocasinan/Kayseri, Türkiye','8990000',2,3,'5+1',240,38.720489,35.48259700000001,'Sale',0,5,12,1,0,1,1,0,1,1,1,0,0,'Available','Apartment','mehmetkuzucu@gmail.com','2024-06-06 22:55:34'),(20,5,'Mimsinde Emsallerine Göre Uygun Fiyatlı Acil Satılık 3+1 Daire','DAİREMİZ MİMSİNDE BULUNMAKTADIR.\n\nMİMSİNDE BULUNAN DAİREMİZ 3+1 VE 12.KATTADIR.\n\nTOPLU TAŞIMA DURAĞI APARTMANIN ÖNÜNDEDİR.','Türkiye','Kayseri','Melikgazi','Şengül Sokak','Mimarsinanşirintepe, Şengül Sk. No:6, 38350 Melikgazi/Kayseri, Türkiye','1900000',2,1,'3+1',130,38.7347797,35.5772649,'Sale',0,12,12,1,0,0,0,0,1,0,1,1,0,'Available','Apartment','mehmetkuzucu@gmail.com','2024-06-06 22:57:09'),(21,5,'ÖZEL MİMARİ İLE, MUHTEŞEM ŞEHİR MANZARALI ULTRA LÜX VİLLALAR','CAMLAR PVC ISICAM ( SALAMANDER ) MARKA\n\nKAPILAR LAKE\n\nHER CAMDA SİNEKLİK VE PANJUR\n\nTERS TAVAN UYGULAMALARI','Türkiye','Kayseri','Hacılar','şaşoglu Caddesi','Akdam, şaşoglu Cd No:20, 38210 Hacılar/Kayseri, Türkiye','10000000',4,5,'7+1',400,38.64604893541308,35.45676170373535,'Sale',0,0,2,1,0,1,0,1,1,1,1,0,0,'Available','Villa','mehmetkuzucu@gmail.com','2024-06-06 22:59:58'),(22,5,'Hulusi Akar Bulvarı Üzerinde Lüks 4+1 Daire','DAİREMİZDE DUVAR KAĞIDI UYGULAMALARI YAPILMIŞTIR\nMERKEZİ SİSTEM OLAN DAİREMİZDE GİYİNME ODASI, ISI VE SES YALITIM SİSTEMİ , TERS TAVAN UYGULAMALARI MEVCUTTUR.\n    ODALARDA PARKE ZEMİN VE ISLAK ZEMİNLERDE FAYANS UYGULAMALARI YER ALMAKTADIR.','Türkiye','Kayseri','Melikgazi','Eşmekaya Sokak','Köşk, Eşmekaya Sk. No:10, 38030 Melikgazi/Kayseri, Türkiye','30000',2,2,'4+1',170,38.7153337,35.5147281,'Rent',0,3,9,0,0,1,0,0,1,1,1,0,1,'Available','Apartment','mehmetkuzucu@gmail.com','2024-06-06 23:00:55'),(23,5,'KAÇMAZ AİLE APARTMANI FIRSATI','Ankara-Eskişehir Yoluna 2300 m.\nOkullara 450 m.\nMarkete/Alışveriş Yerine 300 m.','Türkiye','Ankara','Sincan','Timuçin Sokak','Plevne, Timuçin Sk. No:19, 06934 Sincan Osb/Sincan/Ankara, Türkiye','10500',1,1,'2+1',80,39.96821117017307,32.595735376953115,'Rent',0,1,3,0,0,1,0,0,1,0,1,0,0,'Available','Apartment','mehmetkuzucu@gmail.com','2024-06-06 23:02:59'),(24,5,'SAHİBİNDEN ACİL KİRALIK','KİRACI AY BAŞINDA ÇIKACAKTIR\nSORUNSUZ KİRA ÖDEYEN KEFİLLİ KİRACI\n','Türkiye','İstanbul','Esenyurt','Tonguç Baba Caddesi','Zafer, Tonguç Baba Cd. No:20/U, 34513 Esenyurt/İstanbul, Türkiye','13750',2,3,'3+1',135,41.01461299758129,28.685818253906262,'Rent',0,-1,4,0,0,0,0,0,1,0,1,0,0,'Pending','Apartment','mehmetkuzucu@gmail.com','2024-06-06 23:05:11'),(25,5,'MUHTEŞEM PROJE ARALIKTA TESLİM','ARALIKTA TESLİM 2+1 VE 3+1 DAİRELER','Türkiye','İstanbul','Başakşehir','10. Caddesi','Başak, 10. Cd. No:2012, 34490 Başakşehir/İstanbul, Türkiye','7000000',1,1,'1+0',90,41.085837010466435,28.80731481249998,'Sale',0,3,9,0,1,1,0,0,1,1,1,0,1,'Available','Apartment','mehmetkuzucu@gmail.com','2024-06-06 23:09:09'),(26,4,'AİLEYE UYGUN EYÜPSULTANDA MÜKEMMEL KONUM','Duşakabinli\nFiyatta pazarlık yoktur\nKefil aranmaktadır','Türkiye','İstanbul','Eyüpsultan','Sevimli Sokak','Esentepe, Sevimli Sk. No:33, 34065 Eyüpsultan/İstanbul, Türkiye','16200',1,1,'2+1',75,41.06820626954,28.935005876953113,'Rent',0,1,5,0,0,1,0,0,1,0,1,0,0,'Available','Apartment','alitas@gmail.com','2024-06-06 23:12:50'),(27,4,'TEK KİŞİLİK SÜPER LOKASYON','İZMİR FOÇA\'DA TEK KİŞİLİK\nEŞYALI OLARAK SATILACAKTIR','Türkiye','İzmir','Foça','Foça İzmir Karayolu','Ilıpınar, Foça İzmir Karayolu 59 A, 35680 Foça/İzmir, Türkiye','1210000',1,1,'1+1',40,38.680374800123275,26.917694675000003,'Sale',0,8,15,1,0,0,0,0,1,1,1,1,0,'Available','Apartment','alitas@gmail.com','2024-06-06 23:14:23'),(28,4,'SAHİLE YAKIN LÜKS VİLLA SÜPER YAZLIK','SAHİLE YÜRÜYÜŞ MESAFESİNDE VİLLA\nTERASLI\nBUTİK MİMARİ','Türkiye','İzmir','Çeşme','3011. Sokak','Dalyan, 3011. Sk. No:4, 35930 Çeşme/İzmir, Türkiye','23500000',3,3,'5+1',250,38.326839394747246,26.307865062499992,'Sale',0,3,3,1,1,0,0,1,1,1,1,0,1,'Available','Apartment','alitas@gmail.com','2024-06-06 23:16:22'),(29,4,'ÖĞRENCİ YA DA BEKARA KİRALIK','ODTÜ\'YE YAKIN\n\nKOLAY ULAŞIM\n\nMERKEZİ KONUM','Türkiye','Ankara','Çankaya','1550/1. Caddesi','Çiğdem, 1550/1. Cd. 2 A, 06530 Çankaya/Ankara, Türkiye','18400',1,1,'2+1',75,39.88970648772009,32.794848878417966,'Rent',0,1,3,1,0,0,0,0,1,0,1,0,0,'Available','Apartment','alitas@gmail.com','2024-06-06 23:18:20'),(30,4,'CADDEDE ULAŞIMA YAKIN','SAHİBİNDEN ACİL SATILIK\n\n\nFİYATTA PAZARLIK YAPILIR\n\nTAKAS KABUL EDİLMEMEKTEDİR','Türkiye','İzmir','Konak','Gaziler Caddesi','Etiler, Gaziler Cd 643B, 35240 Konak/İzmir, Türkiye','8420000',2,2,'3+2',110,38.42164944129668,27.145057597900383,'Sale',0,3,5,0,0,0,1,0,1,1,1,0,1,'Available','Apartment','alitas@gmail.com','2024-06-06 23:20:00'),(31,6,'RWDEN KUZEY KUŞAK BAĞLANTI YOLU ÜZERİNDE 5 KATLI BİNADA 3+1','REALTY WORLD CADDE GAYRİMENKULDEN\n\nYEŞİLTEPE BÖLGESİNDE \n\nKUZEY KUŞAK BAĞLANTI YOLU ÜZERİNDE\n\n5 YAŞINDA 3 BLOKLU SİTEDE \n\n5 KATLI BİNANIN 4. KATINDA\n\n140 METRE KARE NET BÜYÜKLÜKTE \n\nSİTE İÇERİSİNDE AÇIK OTOPARKLI\n\nMARKETLERE YÜRÜME MESAFESİNDE\n\nANA CADDE ÜZERİNDE ULAŞIM PROBLEMİ OLMAYAN NOKTADA\n\nCAM BALKONU YAPILI SATILIK 3+1 DAİRE​','Türkiye','Malatya','Yeşilyurt','24','Hamidiye, Mahmut Çalık Dokuma Anıt Parkı, İnce Sk. No:24, 44900 Yeşilyurt/Malatya, Türkiye','2550000',1,1,'3+1',140,38.30098248293914,38.25039324340822,'Sale',0,4,5,1,0,0,1,0,1,1,1,0,0,'Pending','Apartment','baranaslan@gmail.com','2024-06-06 23:50:21'),(32,6,'REFERANS\'TAN BAŞHARIK MAHALLESİNDE 3+1 ULTRA LÜKS DAİRE PROJESİ','Tapu Durumu Kat Mülkiyetli\n\nDaire\n\n3 Oda 1 Salon\n\n1 Banyo \n\n1 Yatak Odası \n\nAçık Otopark ','Türkiye','Malatya','Battalgazi','Mustafa Yılmaz Caddesi','Alacakapı, Mustafa Yılmaz Cd. No:1, 44210 Battalgazi/Malatya, Türkiye','3650000',1,1,'3+1',137,38.4249723,38.3650093,'Sale',0,2,4,1,0,0,0,0,1,1,1,0,0,'Available','Apartment','baranaslan@gmail.com','2024-06-06 23:52:14'),(33,6,'İSTASYON MAH 2+1 SATILIK ARAKAT DAİRE','Dairemiz 2+1 olup arakattır.\n\nBina yeni teslim edilmiş olup, hasarsız raporu mevcuttur.\n\nZemin + 3 katlıdır. \n\nKullanışlı bir dairedir.\n\nOturuma hazırdır.\n\nBalkon bulunmaktadır.\n\nAsansör vardır.','Türkiye','Malatya','Yeşilyurt','Yurt Sokak','İnönü, Yurt Sk. No:25, 44070 Yeşilyurt/Malatya, Türkiye','2000000',1,1,'2+1',55,38.3499313,38.2885555,'Sale',0,2,4,1,0,0,0,1,0,1,1,0,0,'Available','Apartment','baranaslan@gmail.com','2024-06-06 23:53:46'),(34,6,'ÇÖŞNÜK\'TE 5+1 ÇİFT TERASLI DUBLEKS DAİRE','5 Oda 1 Salon\n2 Adet Klima\nCam Balkon\nEbeveyn Banyosu Var','Türkiye','Malatya','Malatya Merkez','9. Sokak','Çöşnük, 9. Sk. No:9, 44320 Malatya Merkez/Malatya, Türkiye','16000',2,3,'5+1',170,38.3446719,38.346715,'Rent',0,4,4,1,1,0,0,1,1,1,1,0,1,'Available','Apartment','baranaslan@gmail.com','2024-06-07 00:01:17'),(35,6,'bostanbaşın da 6 yılık 1.ci kat 2+1 daire ( daire şuan boş )','8 katlı binanın 1.ci katı daire\n\neşyalar çıkartıldı daire boş binada full herkes oturuyor','Türkiye','Malatya','Yeşilyurt','Malabadi Sokağı','Çilesiz, Malabadi Sok. 3/c, 44090 Yeşilyurt/Malatya, Türkiye','15000',1,1,'2+1',90,38.33656783586343,38.272940194873044,'Rent',0,1,8,0,1,1,1,0,1,1,1,0,0,'Available','Apartment','baranaslan@gmail.com','2024-06-07 00:03:30'),(36,8,'ACİL SATILIK ŞIK DEKORLU 2+1 DAİRE',' ■ Site içi\n\n\n\n ■ 2+1 \n\n\n\n ■ 90 M2\n\n\n\n ■ Ankastre\n\n\n\n ■ Güvenlik','Türkiye','İstanbul','Beylikdüzü','Vatan Caddesi','Gürpınar, Vatan Cd. No:6, 34528 Beylikdüzü/İstanbul, Türkiye','2149000',1,1,'2+1',95,40.9866014,28.6060578,'Sale',0,2,4,1,0,0,1,1,1,1,1,0,0,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 11:18:27'),(37,8,'SATILIK 2+1 SIFIR LÜKS PROJEDE ÇINAR CADDESİ PARALEL KOMİSYONSUZ','Dairemiz 2+1 ve Sıfırdır.\n\nYerden Bağımsız, Havada ve Altında Daire Bulunmakta, Led Spot Aydınlatmalı, Balkonlu ve Güney Cepheye Bakmaktadır, Kira Getirisi 19-20 Bin Civarındadır, En Lüks Malzemelerden , 60*120 Seramik, Yer-Tezgah Arası-Banyo Yer ve Duvar Olmak Üzere Kullanılmıştır, Asansörlü, Kapalı Otoparklı, Geniş Mutfaklı, 8 Cm Parke Süpürgelikli ve En İnce Ayrıntılarına Kadar Düşünülmüştür.\n','Türkiye','İstanbul','Maltepe','Gazi Mustafa Kemal Caddesi','Fındıklı, Gazi Mustafa Kemal Cd. 125b, 34854 Maltepe/İstanbul, Türkiye','3350000',1,2,'2+1',75,40.971382533305096,29.133725731738274,'Sale',0,0,4,0,0,0,0,0,1,1,1,0,0,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 11:21:01'),(38,8,'SANCAKTEPE SAMANDIRA İÇİ YENİLENDİ SİTE İÇİ 130 m2','ACİL İHTİYAÇTAN SATILIK\n\nYATIRIMLIK FIRSAT\n\n BÜTÜN EKSİKLER TAMAMLANIP TESLİM EDİLECEKTİR.\n\n\n\n\n\nDETAYLI BİLGİ ve RANDEVU İÇİN ARAYINIZ..','Türkiye','İstanbul','Sancaktepe','Yakacık Caddesi','Fatih, İETT Fatih Mahallesi Durağı, Yakacık Cad., 34885 Sancaktepe/İstanbul, Türkiye','2595000',1,1,'3+1',130,40.9601111,29.2147149,'Sale',0,2,7,0,0,0,0,0,1,1,1,0,0,'Pending','Apartment','ekremyildirim@gmail.com','2024-06-07 11:26:16'),(39,8,'Seferihisarda yaşamak istiyorum diyenler için muazzam bir daire','Bina 23 perde beton kolondan inşaa edilmiş c35 beton kullanılmıştır. çift duvar izalasyon özelliği aliminyum doğrama elektrikli panjurlqr bazali sistem balkon camlari porselen tezgah lake kapilar ve dolaplar','Türkiye','İzmir','Seferihisar','Sığacık Caddesi','Camikebir, Sığacık Cd. No:190, 35460 Seferihisar/İzmir, Türkiye','8000000',1,1,'2+1',117,38.19420702167447,26.832462230468742,'Sale',0,2,4,1,1,0,0,0,1,1,1,0,1,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 11:29:27'),(40,8,'SAHİBİNDEN 3+1 /130 METRE 3 CEPHE 3 BALKON','Bina siteden bozulduğu için her bina kendi içinde yönetime sahip binada toplamda 8 daire var.\nBina cephesi korkulukları ve asansörü yeni yapıldı tahmini (5Ay)','Türkiye','İzmir','Selçuk','4001. Sokak','14 Mayıs, 4001. Sk. No:29, 35920 Selçuk/İzmir, Türkiye','13500',2,2,'3+1',130,37.95001326119352,27.37508384301757,'Rent',0,3,7,0,0,0,0,0,1,0,1,0,0,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:00:14'),(41,8,'SAHİBİNDEN SATILIK 3+1 GÜNEY CEPHE SIFIR DAİRE','Ara kat güney cepheli olan dairemizde ebeveyn banyo mevcuttur. Kapalı otoparklı ve peyzaj işleri tamamlanmış olan sitemizde iskan alınmış ve oturum başlamıştır. ','Türkiye','İstanbul','Pendik','Yavru Sokak','Kavakpınar Mh, Yavru Sk. No:4/A, 34899 Pendik/İstanbul, Türkiye','17300',2,1,'3+1',125,40.885718009089,29.279788621875007,'Rent',0,4,7,1,0,1,0,0,1,1,1,0,0,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:02:15'),(42,8,'GENİŞ SIFIR AYARINDA 3+1 DAİRE','DAİREMİZ 8 YILLIKTIR.\nİÇİ TERTEMİZ YAPILI, ÇOK GENİŞ, ÇOK FERAH KALABALIK AİLELER TERCİH EDEBİLİR. MARKET, OKUL, KURS MERKEZLERİ VE PAZARA 1-2 DK MESAFEDEDİR.','Türkiye','Ankara','Keçiören','Çamlık Sokak','19 Mayıs, Çamlık Sk. No:12, 06290 Keçiören/Ankara, Türkiye','8250000',2,2,'3+1',180,39.98494241475807,32.858368608984364,'Sale',0,6,8,0,0,1,0,0,1,0,1,0,1,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:04:09'),(43,8,'Muhteşem Konuma Sahip Yatırımlık Daire','Kentsel dönüşüm sürecinde olan evimiz satılıktır. Ev için planlanan projede çatı dubleks olarak çizimler yapılmış olup toplantı ve karar süreçleri devam etmektedir','Türkiye','İstanbul','Beyoğlu','Ayhan Işık Sokak','Kuloğlu, Ayhan Işık Sk. No: 32, 34433 Beyoğlu/İstanbul, Türkiye','5000000',1,1,'2+1',80,41.03348827038992,28.980733357147212,'Sale',0,4,4,1,0,1,0,0,1,0,1,0,0,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:06:14'),(44,8,'SAHİBİNDE SATILIK YENİ YAPILI TERTEMİZ DAİRE','3450 M2 ARSA ÜZERİNDE 2 BLOKTAN OLUŞAN\n\nSİTE İÇERİSİNDEDİR\n\nDIŞ CEPHE KAPLAMA ORTAK DEPO KULLANIM ALANI\n\nOTOPARK KAMELYA ÇOCUK OYUN PARKI MEVCUTTUR','Türkiye','İstanbul','Arnavutköy','Karadut Sokak','Nenehatun, Karadut Sk. No:4, 34275 Arnavutköy/İstanbul, Türkiye','9500000',1,3,'3+1',145,41.19542007047599,28.74008135273438,'Sale',0,6,7,1,0,1,0,0,1,1,1,0,1,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:10:58'),(45,8,'Sahibinden Orman Manzaralı 4+1 Daire','Herhangi bir tadilat gereksinimi bulunmamakla birlikte tüm pencereleri ısıcam konfor ile değiştirilmiş, tavanına balkonu da içine alacak şekilde cam yünüyle ısı yalıtımı yapılmıştır.\n\nCephesi tamamen orman vasfındaki araziye bakmaktadır. Görüşü engelleyecek hiçbir unsurun olmadığı eşsiz bir manzaraya sahiptir.','Türkiye','İstanbul','Sultanbeyli','Tayyip Sokağı','Yavuz Selim, Tayyip Sokağı No:18, 34925 Sultanbeyli/İstanbul, Türkiye','4800000',3,2,'4+1',185,40.950060113479296,29.27566704882811,'Sale',0,3,5,1,0,1,0,1,1,0,1,0,1,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:12:59'),(46,8,'KİRALIK 2+1 DAİRE','UYGUN FİYATLI\n\nAYRI MUTFAKLI','Türkiye','İstanbul','Çatalca','Nar Sokak','Ferhatpaşa, Nar Sk. No:1, 34888 Çatalca/İstanbul, Türkiye','11000',1,1,'2+1',87,41.14386270071517,28.462682067578147,'Rent',0,5,5,0,0,0,0,0,1,0,1,0,0,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:16:02'),(47,8,'Lüx 2+1 Kiralık Daire ','7/24 güvenlikli daire','Türkiye','İstanbul','Ümraniye','Küçüksu Caddesi','Yamanevler, Küçüksu Cd. No:32, 34768 Ümraniye/İstanbul, Türkiye','24000',1,1,'2+1',110,41.02676553903272,29.1029761036133,'Rent',0,2,4,1,1,1,1,0,1,1,1,0,0,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:17:59'),(48,8,'DENİZ MANZARALI 3+1 TEMİZ DAİRE','............','Türkiye','İstanbul','Beykoz','Şehit Eray Karataş Sokak','İncirköy, Şht. Eray Karataş Sk. No:54, 34800 Beykoz/İstanbul, Türkiye','21000',2,2,'3+1',106,41.11580413033482,29.109498935937495,'Rent',0,3,5,1,0,0,0,0,1,0,1,0,1,'Available','Apartment','ekremyildirim@gmail.com','2024-06-07 12:19:48');
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

-- Dump completed on 2024-06-07 14:44:49
