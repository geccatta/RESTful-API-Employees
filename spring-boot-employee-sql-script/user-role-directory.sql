USE `employee_directory`;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `users_roles`;
SET foreign_key_checks = 1;

CREATE TABLE `user` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(50) NOT NULL UNIQUE,
  `password` varchar(80) NOT NULL,
  `enabled` tinyint NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `user` (`username`,`password`,`enabled`)
VALUES 
('stef','$2a$12$mB8.TX8eSTq3EREwZ0FHM.bMmRXhJiia3uj8UulPl2k2iyQG6eYhS',1),
('papi','$2a$12$mB8.TX8eSTq3EREwZ0FHM.bMmRXhJiia3uj8UulPl2k2iyQG6eYhS',1),
('geccatta','$2a$12$mB8.TX8eSTq3EREwZ0FHM.bMmRXhJiia3uj8UulPl2k2iyQG6eYhS',1);

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name)
VALUES 
('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');

CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(3, 3);