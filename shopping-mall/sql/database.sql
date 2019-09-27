CREATE DATABASE shopping_mall;

use shopping_mall;

CREATE TABLE `admin_db` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `admin_password` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `tell_number` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `bank` varchar(30) COLLATE utf8_unicode_ci DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `custom_db` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `logo_image_url` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_db` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pd_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pd_price` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `pd_amount` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `pd_image_url` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `pd_date` date NOT NULL,
  `pd_content` longtext COLLATE utf8_unicode_ci NOT NULL,
  `pd_category` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;