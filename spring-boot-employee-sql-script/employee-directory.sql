CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL UNIQUE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `employee` VALUES
   (1,'Letisiya','Andreeva','leti@test.com'),
   (2,'Emma','Bogomilova','emma@test.com'),
   (3,'Angel','Grigorov','angel_gr@test.com'),
   (4,'Yordan','Petrov','ypetrov@test.com'),
   (5,'Joan','Hristov','joan@test.com'),
   (6,'Miglena','Maneva','mmaneva@test.com'),
   (7,'Hristiyan','Penev','hrpenev@test.com'),
   (8,'Daniel','Alenov','dancho@test.com'),
   (9,'Bogomil','Bogomilov','bogi@test.com'),
   (10,'Reneta','Dancheva','reni_dan@test.com'),
   (11,'Kristiyana','Shtereva','krisi@test.com'),
   (12,'Kaloyan','Uzunov','uzunovv@test.com'),
   (13,'Yanitsa','Rasheva','yrasheva@test.com'),
   (14,'Alen','Kolev','alennk@test.com'),
   (15,'Radislav','Galenov','galenovR@test.com'),
   (16, 'Viktoriya','Nedyalkova','vik_ned@test.com'),
   (17,'Filip','Dubev','filip_dubev@test.com');

