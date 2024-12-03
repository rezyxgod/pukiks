-- MySQL dump 10.19  Distrib 10.3.39-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db04
-- ------------------------------------------------------
-- Server version	10.3.39-MariaDB-0+deb10u2

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `admin_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAdmin`),
  KEY `admin_ibfk_1_idx` (`admin_user`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`admin_user`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,11);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent` (
  `idAgent` int(11) NOT NULL AUTO_INCREMENT,
  `agent_User` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAgent`),
  KEY `agent_ibfk_1_idx` (`agent_User`),
  CONSTRAINT `agent_ibfk_1` FOREIGN KEY (`agent_User`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,12);
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `client_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  KEY `client_ibfk_1_idx` (`client_user`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`client_user`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (2,9),(1,10);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultations`
--

DROP TABLE IF EXISTS `consultations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultations` (
  `id_consultations` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `topic` varchar(100) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_consultations`),
  KEY `consultation_ibfk1_idx` (`client_id`),
  CONSTRAINT `consultation_ibfk1` FOREIGN KEY (`client_id`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultations`
--

LOCK TABLES `consultations` WRITE;
/*!40000 ALTER TABLE `consultations` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desired_packages`
--

DROP TABLE IF EXISTS `desired_packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `desired_packages` (
  `desired_package_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `package_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`desired_package_id`),
  KEY `desired_ibfk1_idx` (`client_id`),
  KEY `desired_ibfk2_idx` (`package_id`),
  CONSTRAINT `desired_ibfk1` FOREIGN KEY (`client_id`) REFERENCES `client` (`idClient`),
  CONSTRAINT `desired_ibfk2` FOREIGN KEY (`package_id`) REFERENCES `packages` (`package_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desired_packages`
--

LOCK TABLES `desired_packages` WRITE;
/*!40000 ALTER TABLE `desired_packages` DISABLE KEYS */;
/*!40000 ALTER TABLE `desired_packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `director` (
  `idDirector` int(11) NOT NULL AUTO_INCREMENT,
  `director_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDirector`),
  KEY `director_ibfk_1_idx` (`director_user`),
  CONSTRAINT `director_ibfk_1` FOREIGN KEY (`director_user`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,14);
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excursions`
--

DROP TABLE IF EXISTS `excursions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excursions` (
  `id_excursions` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `available_slots` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id_excursions`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursions`
--

LOCK TABLES `excursions` WRITE;
/*!40000 ALTER TABLE `excursions` DISABLE KEYS */;
INSERT INTO `excursions` VALUES (1,'asd','asd',100.00,100,'2020-01-01','2020-01-01');
/*!40000 ALTER TABLE `excursions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excursionsales`
--

DROP TABLE IF EXISTS `excursionsales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excursionsales` (
  `id_sale` int(11) NOT NULL AUTO_INCREMENT,
  `sale_date` date DEFAULT NULL,
  `number_of_tickets` int(11) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `excursion_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sale`),
  KEY `sale1_ibfk_idx` (`excursion_id`),
  KEY `sale2_ibfk_idx` (`client_id`),
  CONSTRAINT `sale1_ibfk` FOREIGN KEY (`excursion_id`) REFERENCES `excursions` (`id_excursions`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sale2_ibfk` FOREIGN KEY (`client_id`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursionsales`
--

LOCK TABLES `excursionsales` WRITE;
/*!40000 ALTER TABLE `excursionsales` DISABLE KEYS */;
/*!40000 ALTER TABLE `excursionsales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `idHotel` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `kolvoNomerov` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `kolvoStar` int(11) DEFAULT NULL,
  PRIMARY KEY (`idHotel`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'jopa','8438534954305',43,5,'asdkasdk',NULL);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_bookings`
--

DROP TABLE IF EXISTS `hotel_bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel_bookings` (
  `id_booking` int(11) NOT NULL AUTO_INCREMENT,
  `check_in_date` date DEFAULT NULL,
  `check_out_date` date DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_booking`),
  KEY `booking_ibfk1_idx` (`hotel_id`),
  KEY `booking_ibfk2_idx` (`client_id`),
  CONSTRAINT `booking_ibfk1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`idHotel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booking_ibfk2` FOREIGN KEY (`client_id`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_bookings`
--

LOCK TABLES `hotel_bookings` WRITE;
/*!40000 ALTER TABLE `hotel_bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `idManager` int(11) NOT NULL AUTO_INCREMENT,
  `manager_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idManager`),
  KEY `manager_ibfk_1_idx` (`manager_user`),
  CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`manager_user`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,13);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_sales`
--

DROP TABLE IF EXISTS `package_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package_sales` (
  `package_sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_date` date DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `package_id` int(11) DEFAULT NULL,
  `id_ticket` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`package_sale_id`),
  KEY `salepack_ibfk1_idx` (`package_id`),
  KEY `salepack_ibfk2_idx` (`client_id`),
  KEY `salepack_ibfk3_idx` (`id_ticket`),
  CONSTRAINT `asdasdasdsaasddas` FOREIGN KEY (`client_id`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salepack_ibfk1` FOREIGN KEY (`package_id`) REFERENCES `packages` (`package_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salepack_ibfk3` FOREIGN KEY (`id_ticket`) REFERENCES `ticket` (`id_ticket`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_sales`
--

LOCK TABLES `package_sales` WRITE;
/*!40000 ALTER TABLE `package_sales` DISABLE KEYS */;
INSERT INTO `package_sales` VALUES (6,'2021-01-01',4000.00,10,1,5,NULL),(7,'2024-10-22',45000.00,8,2,5,'Куплен'),(8,'2024-10-22',69455.00,8,1,5,'Куплен');
/*!40000 ALTER TABLE `package_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_wishes`
--

DROP TABLE IF EXISTS `package_wishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package_wishes` (
  `wish_id` int(11) NOT NULL AUTO_INCREMENT,
  `wish_description` varchar(100) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `package_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`wish_id`),
  KEY `wish_ibfk1_idx` (`package_id`),
  KEY `wish_ibfk2_idx` (`client_id`),
  CONSTRAINT `wish_ibfk1` FOREIGN KEY (`package_id`) REFERENCES `packages` (`package_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `wish_ibfk2` FOREIGN KEY (`client_id`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_wishes`
--

LOCK TABLES `package_wishes` WRITE;
/*!40000 ALTER TABLE `package_wishes` DISABLE KEYS */;
INSERT INTO `package_wishes` VALUES (3,'qwe',10,1);
/*!40000 ALTER TABLE `package_wishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packages`
--

DROP TABLE IF EXISTS `packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packages` (
  `package_id` int(11) NOT NULL AUTO_INCREMENT,
  `destination` varchar(45) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`package_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES (1,'Финляндия','2000-01-01','2000-01-02','45000','авиарейс'),(2,'Питер','2000-01-01','2000-01-20','20000','поезд');
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_sales`
--

DROP TABLE IF EXISTS `room_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_sales` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_date` date DEFAULT NULL,
  `number_of_rooms` int(11) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `roomsales_ibfk1_idx` (`hotel_id`),
  KEY `roomsales_ibfk2_idx` (`client_id`),
  CONSTRAINT `roomsales_ibfk1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`idHotel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `roomsales_ibfk2` FOREIGN KEY (`client_id`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_sales`
--

LOCK TABLES `room_sales` WRITE;
/*!40000 ALTER TABLE `room_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id_ticket` int(11) NOT NULL AUTO_INCREMENT,
  `name_ticket` varchar(45) DEFAULT NULL,
  `flight_number` varchar(45) DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `arrival_date` date DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ticket`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (5,'Прокопьевск','45','2020-01-01','2020-01-02',24455),(6,'Москва','46','2024-01-01','2024-01-02',21521),(7,'Москва','47','2023-02-02','2023-02-03',123124);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_sales`
--

DROP TABLE IF EXISTS `ticket_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_sales` (
  `id_tsale` int(11) NOT NULL AUTO_INCREMENT,
  `sale_date` date DEFAULT NULL,
  `id_ticket` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_tsale`),
  KEY `1_idx` (`id_ticket`),
  KEY `2_idx` (`id_client`),
  CONSTRAINT `1` FOREIGN KEY (`id_ticket`) REFERENCES `ticket` (`id_ticket`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `2` FOREIGN KEY (`id_client`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_sales`
--

LOCK TABLES `ticket_sales` WRITE;
/*!40000 ALTER TABLE `ticket_sales` DISABLE KEYS */;
INSERT INTO `ticket_sales` VALUES (1,'2024-10-22',5,2),(2,'2024-11-22',6,2),(4,'2024-11-22',5,2);
/*!40000 ALTER TABLE `ticket_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `Imya` varchar(45) DEFAULT NULL,
  `Familiya` varchar(45) DEFAULT NULL,
  `Otchestvo` varchar(45) DEFAULT NULL,
  `dataRoj` date DEFAULT NULL,
  `dataTruda` date DEFAULT NULL,
  `passportSeries` varchar(45) DEFAULT NULL,
  `passportNumber` varchar(45) DEFAULT NULL,
  `snils` varchar(45) DEFAULT NULL,
  `photolink` text DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `Podtverzdenie` varchar(45) DEFAULT NULL,
  `login` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (8,'КАакак','ВФЫ','фывфы','2000-01-01','2000-01-01','5454','123456','12345678910','uploads/Безымянный.png',NULL,'1','4321','4321'),(9,'Матвей','Доваргин','Павлович','2000-01-01','2000-02-01','1231','421412','21412412412','uploads/Безымянный.png',NULL,'0','zxczxczxc','zxczxczxc'),(10,'Глеб','Михайлов','Витальевич','2005-10-10','2005-10-10','1624','892176','46165498434','uploads/Безымянный.png',NULL,'1','client','client'),(11,'asfada','sadadas','sfafasf','2050-10-10','2050-10-10','3487','254673','54687327857','uploads/Безымянный.png',NULL,'1','admin','admin'),(12,'sad','faf','asdf','2003-12-12','2003-12-12','1231','141551','51251643515','uploads/Безымянный.png',NULL,'0','agent','agent'),(13,'asfafg','asf','qwsd','2003-12-12','2003-12-12','4152','143155','46362171363','uploads/Безымянный.png',NULL,'0','manager','manager'),(14,'safaf','afqw','dfca','2003-12-12','2003-12-12','1455','151143','12341445156','uploads/Безымянный.png',NULL,'0','director','director');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db04'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-03 11:41:20
