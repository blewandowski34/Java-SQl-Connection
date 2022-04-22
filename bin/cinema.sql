-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `movieID` int NOT NULL,
  `movieTitle` varchar(50) DEFAULT NULL,
  `dateReleased` year DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `format` varchar(15) DEFAULT NULL,
  `price` decimal(4,2) DEFAULT NULL,
  `starID` int DEFAULT NULL,
  PRIMARY KEY (`movieID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Star Wars: The Phantom Menace',1999,'USA','Sci-Fi','Netflix',79.49,12),(2,'After Hours',1985,'USA','Thriller','DVD',58.99,17),(3,'Rain Man',1988,'USA','Drama','Amazon Prime',15.99,11),(4,'Oliver!',1968,'USA','Musical','Apple TV',15.49,32),(5,'Adaptation',2002,'USA','Drama','DVD',58.99,31),(6,'On the Waterfront',1954,'USA','Drama','Amazon Prime',13.49,10),(7,'Lantana',2001,'Australia','Thriller','DVD',53.99,23),(8,'Highway Patrolman',1991,'USA','Drama','Netflix',31.49,29),(9,'Dances with Wolves',1990,'USA','Drama','Apple TV',21.49,44),(10,'Edward Scissorhands',1990,'USA','Fantasy','DVD',24.99,67),(11,'Dangerous Moves',1984,'Switzerland','Drama','Amazon Prime',52.99,51),(12,'Ghost Dog: The Way of the Samurai',1999,'USA','Thriller','DVD',68.49,61),(13,'The Triplets of Belleville',2003,'France','Musical','Amazon Prime',30.99,43),(14,'The Godfather Part 2',1974,'USA','Drama','Apple TV',55.99,10),(15,'Rabbit-Proof Fence',2002,'Australia','Drama','DVD',55.49,19),(16,'The Sweet Hereafter',1997,'Canada','Drama','Amazon Prime',11.99,88),(17,'Clay Pigeons',1998,'Germany','Thriller','DVD',28.49,73),(18,'Breakfast at Tiffanys',1961,'USA','Comedy','DVD',22.99,5),(19,'The American Astronaut',2001,'USA','Sci-Fi','Apple TV',27.49,38),(20,'Mephisto',1981,'Hungary','Drama','DVD',15.99,66),(21,'My Fair Lady',1964,'USA','Musical','Netflix',20.99,5),(22,'The Lord of the Rings: The Two Towers',2001,'New Zealand','Fantasy','DVD',83.49,63),(23,'The Ten',2007,'USA','Comedy','Apple TV',27.99,71),(24,'2046',2004,'China','Drama','Amazon Prime',74.49,99),(25,'American Splendor',2003,'USA','Drama','Netflix',50.99,76),(26,'Titanic',1997,'USA','Drama','Apple TV',11.49,55);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stars`
--

DROP TABLE IF EXISTS `stars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stars` (
  `starID` int NOT NULL,
  `star_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`starID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stars`
--

LOCK TABLES `stars` WRITE;
/*!40000 ALTER TABLE `stars` DISABLE KEYS */;
INSERT INTO `stars` VALUES (5,'Audrey Hepburn'),(10,'Marlon Brando'),(11,'Dustin Hoffman'),(12,'Jake Lloyd'),(17,'Griffin Dunne'),(19,'Kenneth Branagh'),(23,'Anthony LaPaglia'),(29,'Roberto Sosa'),(31,'Nicolas Cage'),(32,'Mark Lester'),(38,'Rocco Sisto'),(43,'Beatrice Bonifassi'),(44,'Kevin Costner'),(51,'Liv Ullmann'),(55,'Leonardo Dicaprio'),(61,'Forest Whitaker'),(63,'Elijah Wood'),(66,'Klaus Maria Branauer'),(67,'Johnny Depp'),(71,'Paul Rudd'),(73,'Joaquin Phoenix'),(76,'Josh Hutcherson'),(88,'Ian Holm'),(99,'Tony Leung');
/*!40000 ALTER TABLE `stars` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-08 11:36:36
