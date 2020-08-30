CREATE DATABASE IF NOT EXISTS `mybatis_study`;

USE `mybatis_study`;

CREATE TABLE IF NOT EXISTS `tb_account`(
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) DEFAULT NULL,
  `money` FLOAT(5.2) DEFAULT 0,
  PRIMARY KEY( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `tb_account`(`id`,`name`,`money`) VALUES
(1,'小张',1000.0),
(2,'小李',2000.0),
(3,'小丽',1500.0);
