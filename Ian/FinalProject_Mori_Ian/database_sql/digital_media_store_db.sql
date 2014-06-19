CREATE DATABASE `digital_media_store_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `digital_media_store_db`;
 
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00"; 
 
-- ------------------------------------------------------

CREATE TABLE IF NOT EXISTS `product_tb` (
  `product_id` int(11) unsigned NOT NULL UNIQUE PRIMARY KEY,
  `product_name` varchar(30) NOT NULL,
  `quantity_on_hand` int(10) NOT NULL,
  `product_description` varchar(160) NOT NULL,
  `product_price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This contains info for the digital media store';

 
CREATE TABLE IF NOT EXISTS `customer_tb` (
  `customer_id` int(11) unsigned NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `customer_username` varchar(20) NOT NULL UNIQUE,
  `customer_password` varchar(20) NOT NULL,
  `customer_first_name` varchar(20) NOT NULL,
  `customer_last_name` varchar(20) NOT NULL,
  `customer_email` varchar(30) NOT NULL,
  `customer_street_address` varchar(30) NOT NULL,
  `customer_city` varchar(30) NOT NULL,
  `customer_province` varchar(2) NOT NULL,
  `customer_postal_code` varchar(6) NOT NULL,
  `customer_telephone` varchar(20) NOT NULL,
  `customer_balance` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This contains info for the digital media store';

CREATE TABLE IF NOT EXISTS `order_tb` (
  `order_id` int(11) unsigned NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `customer_id` int(11) unsigned NOT NULL,
  `order_date` DATE NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer_tb(customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This contains info for the digital media store';


CREATE TABLE IF NOT EXISTS `order_line_tb` (
  `order_line_id` int(11) unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  `order_id` int(11) unsigned NOT NULL,
  `product_id` int(11) unsigned NOT NULL,
  `quantity_ordered` int(10) unsigned NOT NULL,
  `sale_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (order_line_id, order_id),  
  FOREIGN KEY (product_id) REFERENCES product_tb(product_id)  
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This contains info for the digital media store';

CREATE TABLE IF NOT EXISTS `support_session_tb` (
  `support_session_id` int(11) unsigned NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `customer_id` int(11) unsigned NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `support_session_date` DATE NOT NULL,
  `support_session_description` varchar(1000),
  FOREIGN KEY (customer_id) REFERENCES customer_tb(customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This contains info for the digital media store';

INSERT INTO product_tb VALUES
(100,'Microsoft Windows 7 Ultimate',1000,'Windows 7 Ultimate upgrade',109.99),
(200,'Kaspersky Pure 3.0',1000,'Kaspersky Pure 3.0 1 year licence',89.99),
(300,'$25 iTunes Gift Card',1000,'$25 iTunes Canadian Gift Card',25.00),
(400,'Borderlands 2 PC',1000,'Borderlands 2 PC Redeemable worldwide',29.99),
(999,'A Game Of Thrones Digital Set',1000,'Includes all Game of Thrones books released',49.99);