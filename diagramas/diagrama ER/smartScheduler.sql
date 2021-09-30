-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smartscheduler
-- ------------------------------------------------------
-- Server version	5.7.35-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contacto`
--

DROP TABLE IF EXISTS `contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacto` (
  `idcontact` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `fullname` varchar(45) DEFAULT NULL,
  `organization` varchar(20) DEFAULT NULL,
  `title` varchar(15) DEFAULT NULL,
  `photo` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`idcontact`),
  UNIQUE KEY `idcontacto_UNIQUE` (`idcontact`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto`
--

LOCK TABLES `contacto` WRITE;
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
INSERT INTO `contacto` VALUES (1,'juan carlos','juan carlos garcia zepeda','uam','sr.','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\n 8E/k/gE/A2HwBtoggrmXAg7Xcr/9k=');
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correo`
--

DROP TABLE IF EXISTS `correo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `correo` (
  `email` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `contacto_idcontact` int(11) NOT NULL,
  PRIMARY KEY (`email`,`contacto_idcontact`),
  KEY `fk_correo_contacto1_idx` (`contacto_idcontact`),
  CONSTRAINT `fk_correo_contacto1` FOREIGN KEY (`contacto_idcontact`) REFERENCES `contacto` (`idcontact`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correo`
--

LOCK TABLES `correo` WRITE;
/*!40000 ALTER TABLE `correo` DISABLE KEYS */;
INSERT INTO `correo` VALUES ('2183033750@uam.cua.mx','work',1),('juancarlos.garciazepeda@gmail.com','home',1);
/*!40000 ALTER TABLE `correo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `address` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `contacto_idcontact` int(11) NOT NULL,
  PRIMARY KEY (`address`,`contacto_idcontact`),
  KEY `fk_direccion_contacto_idx` (`contacto_idcontact`),
  CONSTRAINT `fk_direccion_contacto` FOREIGN KEY (`contacto_idcontact`) REFERENCES `contacto` (`idcontact`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES ('av. 16 de septiembre','home',1),('uam santa fe','work',1);
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `number` varchar(15) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `contacto_idcontact` int(11) NOT NULL,
  PRIMARY KEY (`number`,`contacto_idcontact`),
  KEY `fk_telefono_contacto1_idx` (`contacto_idcontact`),
  CONSTRAINT `fk_telefono_contacto1` FOREIGN KEY (`contacto_idcontact`) REFERENCES `contacto` (`idcontact`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
INSERT INTO `telefono` VALUES ('5582849499','home',1),('5588015129','cell',1);
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-29 19:35:08
