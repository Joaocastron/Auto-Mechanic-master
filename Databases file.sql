-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: gers
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `status` int DEFAULT NULL,
  `time_stamp` date DEFAULT NULL,
  `type` int DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `vehicle_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtpm65yup17nf5o2fn0ll9be93` (`customer_id`),
  KEY `FKejehywt60rdh29uvn8ejths82` (`vehicle_id`),
  CONSTRAINT `FKejehywt60rdh29uvn8ejths82` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`),
  CONSTRAINT `FKtpm65yup17nf5o2fn0ll9be93` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,NULL,'lights ',0,0,'2020-08-15',0,1,1),(2,NULL,'lights ',0,0,'2020-08-14',2,2,2);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_supplies`
--

DROP TABLE IF EXISTS `booking_supplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_supplies` (
  `booking_id` bigint NOT NULL,
  `supply_id` bigint NOT NULL,
  PRIMARY KEY (`booking_id`,`supply_id`),
  KEY `FKe3tqhblk6svwykybtcuonvjmb` (`supply_id`),
  CONSTRAINT `FK804jbdy2pxpb82srrqtb9nn5y` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `FKe3tqhblk6svwykybtcuonvjmb` FOREIGN KEY (`supply_id`) REFERENCES `supply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_supplies`
--

LOCK TABLES `booking_supplies` WRITE;
/*!40000 ALTER TABLE `booking_supplies` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_supplies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supply`
--

DROP TABLE IF EXISTS `supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supply` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `supply_name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply`
--

LOCK TABLES `supply` WRITE;
/*!40000 ALTER TABLE `supply` DISABLE KEYS */;
INSERT INTO `supply` VALUES (1,'Break disc',70),(2,'Break drums',80),(3,'Abs sensor',120),(4,'Break Pads',95),(5,'Head Lights',40),(6,'Rear Light',60),(7,'Headlights switch',60),(8,'Front fog lights',35),(9,'Air filter',25),(10,'Oil filter',35),(11,'Distributor Caps',27),(12,'Ignition switch',45),(13,'Spark plugs ',26),(14,'Ignition Leads',50),(15,'Oil Browser',75),(16,'ATF Fluid ',55),(17,'Hidraulic Fluid',85),(18,'Break Fluid',55),(19,'Grease',45),(20,'Gear Oil',66),(21,'Battery',150),(22,'Bulb',15),(23,'Miror',45),(24,'Bumper ',115),(25,'Radiator Grilles',97),(26,'Bonnet',210),(27,'Wings',175),(28,'Wheel Nuts',67),(29,'Wheel bearing',55);
/*!40000 ALTER TABLE `supply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jc@jc','joao','$2a$10$WVlNMFEuJvpyVhZRDFyQkuatgfHAey9IB3ERWu64mFUvnCZQaBYGu','0830001234','castro'),(2,'luishenriquestolfi@gmail.com','luis ','$2a$10$otoG3yN2GejyD3S/UHmNje/QMai5RQHfmwD3ZditTVUJgTxSh8vDe','0833641412','stolfi'),(3,'admin@admin','Admin','$2a$10$7iVRB8na3UAhRY.DCexLNO0fHoM.1hHYL04GH67lOcVAM.Xw8l3Yi','12121','Admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `engine` int DEFAULT NULL,
  `licence` varchar(255) DEFAULT NULL,
  `make` int DEFAULT NULL,
  `model` int DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `owner_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1yryuhbbu92ctakdu8t3mdo62` (`licence`),
  KEY `FK2l3ygnjxunr1d74aril4ogtcy` (`owner_id`),
  CONSTRAINT `FK2l3ygnjxunr1d74aril4ogtcy` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'',1,'2019-tt',1,4,'2018',1),(2,'classic',0,'789',1,2,'2019',2),(3,'',0,'1234a',8,1,'2017',1);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_booking`
--

DROP TABLE IF EXISTS `vehicle_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_booking` (
  `vehicle_id` bigint NOT NULL,
  `booking_id` bigint NOT NULL,
  UNIQUE KEY `UK_2ghcyu0r2rn1ul55g3bo241vo` (`booking_id`),
  KEY `FK2imblv3x26fx3q77utptyogju` (`vehicle_id`),
  CONSTRAINT `FK2imblv3x26fx3q77utptyogju` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`),
  CONSTRAINT `FKmqrvlg32abn8ce1cji789bmi0` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_booking`
--

LOCK TABLES `vehicle_booking` WRITE;
/*!40000 ALTER TABLE `vehicle_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_id`
--

DROP TABLE IF EXISTS `vehicle_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_id` (
  `user_id` bigint NOT NULL,
  `vehicle_id` bigint NOT NULL,
  UNIQUE KEY `UK_navejhyc0cjpbiddk0x7xk4y0` (`vehicle_id`),
  KEY `FKauch7wjfgkj4woeh042wj8c05` (`user_id`),
  CONSTRAINT `FKauch7wjfgkj4woeh042wj8c05` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKq8q9aax64l6yvlycnvb7duvwc` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_id`
--

LOCK TABLES `vehicle_id` WRITE;
/*!40000 ALTER TABLE `vehicle_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gers'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-15 21:05:30
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: auto_mechanic
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time_stamp` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `user_email` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKejehywt60rdh29uvn8ejths82` (`vehicle_id`),
  CONSTRAINT `FKejehywt60rdh29uvn8ejths82` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'joao.c.neto@hotmail.com','Joao Castro','$2a$10$18Zqdi1BRb42OzLVuFgmku9dvWmtucAZbJwcehQwUWUj0MGuRaebG',NULL,NULL),(2,'jc@jc','joao','$2a$10$ccP61F7jyUlZYXGrwbkt/uRiggn2DHCnszEwKEKwskMQ7UEL4pKOy','1234','castro'),(3,'hq@hq','HENRIQUE','$2a$10$wVFWoJYfDSmbw8uKO6vCaOOM61UNfpoCwSuVRMx812igG.XQ9A59W','784512','Stolfi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_id`
--

DROP TABLE IF EXISTS `user_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_id` (
  `customer_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK62689ng3t08oswvkvomcely5k` FOREIGN KEY (`id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_id`
--

LOCK TABLES `user_id` WRITE;
/*!40000 ALTER TABLE `user_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `engine` varchar(255) DEFAULT NULL,
  `licence` varchar(255) DEFAULT NULL,
  `make` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `owner_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1yryuhbbu92ctakdu8t3mdo62` (`licence`),
  KEY `FK2l3ygnjxunr1d74aril4ogtcy` (`owner_id`),
  CONSTRAINT `FK2l3ygnjxunr1d74aril4ogtcy` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'','','1234a','ford','golf',NULL,'',NULL),(2,'','','1111','ford','gol',NULL,'2018',NULL),(5,'','','','2','',NULL,'',NULL),(6,'ss','1','1212','1','1',NULL,'2017',NULL),(7,'ss','1','2121','1','0',NULL,'',NULL),(8,'','1','789','3','7',NULL,'2018',NULL),(9,'','3','741','4','11',NULL,'2019',NULL),(10,'','1','7474','5','15',NULL,'2017',NULL);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_booking`
--

DROP TABLE IF EXISTS `vehicle_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_booking` (
  `vehicle_id` bigint NOT NULL,
  `booking_id` bigint NOT NULL,
  UNIQUE KEY `UK_2ghcyu0r2rn1ul55g3bo241vo` (`booking_id`),
  CONSTRAINT `FKmqrvlg32abn8ce1cji789bmi0` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_booking`
--

LOCK TABLES `vehicle_booking` WRITE;
/*!40000 ALTER TABLE `vehicle_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_id`
--

DROP TABLE IF EXISTS `vehicle_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_id` (
  `user_id` bigint NOT NULL,
  `vehicle_id` bigint NOT NULL,
  UNIQUE KEY `UK_navejhyc0cjpbiddk0x7xk4y0` (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_id`
--

LOCK TABLES `vehicle_id` WRITE;
/*!40000 ALTER TABLE `vehicle_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'auto_mechanic'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-15 21:05:30
