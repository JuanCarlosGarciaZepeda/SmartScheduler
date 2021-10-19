CREATE DATABASE  IF NOT EXISTS `smartsheduler` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `smartsheduler`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: smartsheduler
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
  `idcontact` int(11) NOT NULL,
  `name` varchar(15) DEFAULT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `nickname` varchar(15) DEFAULT NULL,
  `title` varchar(15) DEFAULT NULL,
  `fullname` varchar(45) DEFAULT NULL,
  `organization` varchar(20) DEFAULT NULL,
  `photo` varchar(10000) DEFAULT NULL,
  `complete` tinyint(4) DEFAULT NULL,
  `duplicate` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idcontact`),
  UNIQUE KEY `idcontacto_UNIQUE` (`idcontact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `correo`
--

DROP TABLE IF EXISTS `correo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `correo` (
  `email` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `contacto_idcontact` int(11) NOT NULL,
  KEY `fk_correo_contacto1_idx` (`contacto_idcontact`),
  CONSTRAINT `fk_correo_contacto1` FOREIGN KEY (`contacto_idcontact`) REFERENCES `contacto` (`idcontact`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `type` varchar(25) DEFAULT NULL,
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` varchar(25) DEFAULT NULL,
  `calle` varchar(25) DEFAULT NULL,
  `estado` varchar(25) DEFAULT NULL,
  `ciudad` varchar(25) DEFAULT NULL,
  `cp` varchar(8) DEFAULT NULL,
  `pais` varchar(20) DEFAULT NULL,
  `contacto_idcontact` int(11) NOT NULL,
  KEY `fk_direccion_contacto_idx` (`contacto_idcontact`),
  CONSTRAINT `fk_direccion_contacto` FOREIGN KEY (`contacto_idcontact`) REFERENCES `contacto` (`idcontact`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `number` varchar(15) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `contacto_idcontact` int(11) NOT NULL,
  KEY `fk_telefono_contacto1_idx` (`contacto_idcontact`),
  CONSTRAINT `fk_telefono_contacto1` FOREIGN KEY (`contacto_idcontact`) REFERENCES `contacto` (`idcontact`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-18 23:00:47
