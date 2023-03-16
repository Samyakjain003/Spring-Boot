CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Samyak','Jain','samyakj820@gmail.com'),
	(2,'Satyam','Jha','iamjha007.com'),
	(3,'Kushal','Sharma','kushalsharma@gmail.com'),
	(4,'Naman','Singh','naman.e21@nsut.ac.in'),
	(5,'Ashwini','Ojha','ojhaashwini@gmail.com');

