CREATE DATABASE shopping_mall;

use shopping_mall;
# 외래키 설정이 있기 때문에 ****테이블 생성 스크립트 순서 중요함****
CREATE TABLE `admin_db` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `admin_id` varchar(40) NOT NULL,
    `admin_password` mediumtext NOT NULL,
    `name` varchar(20) NOT NULL,
    `tell_number` varchar(30) NULL default 0,
    `bank` varchar(30) NULL default 0 ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `user_db` (
   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
   `user_id` varchar(40) NOT NULL,
   `user_password` mediumtext  NOT NULL,
   `name` varchar(20) NOT NULL,
   `tell_number` varchar(20) NOT NULL,
   `address` varchar(45) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `address_db` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `tell_number` varchar(20) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `address_db_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_db` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `custom_db` (
     `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
     `title` varchar(20) NOT NULL,
     `logo_image_url` varchar(30) DEFAULT NULL,
     `tell_number` varchar(20) DEFAULT NULL,
     `bank` varchar(30) DEFAULT NULL,
     `bank_admin` varchar(20) DEFAULT NULL,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `product_db` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pd_name` varchar(45) NOT NULL,
  `pd_price` varchar(20) NOT NULL,
  `pd_amount` varchar(45) NOT NULL,
  `pd_image_url` mediumtext NOT NULL,
  `pd_date` date NOT NULL,
  `pd_content` longtext NOT NULL,
  `pd_category` varchar(10) NOT NULL,
  `pd_detail` mediumtext NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `order_db` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `date` datetime NOT NULL,
    `price` int(11) unsigned NULL,
    `product_id` int(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `deliveries_db` (
     `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
     `address_id` int(11) unsigned NOT NULL,
     `address_user_id` int(11) unsigned NOT NULL,
     `order_id` int(11) unsigned NOT NULL,
     `order_user_id` int(11) unsigned NOT NULL,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `purchase_db` (
   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
   `purchase_date` datetime NOT NULL,
   `user_id` int(11) unsigned NOT NULL,
   `order_id` int(11) unsigned NOT NULL,
   `order_user_id` int(11) unsigned NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `cart_db` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `product_id` int(20) NOT NULL,
    `user_id` varchar(20) NOT NULL,
    `date` datetime NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB;