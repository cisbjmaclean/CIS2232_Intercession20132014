-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2014 at 04:37 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `storage_units_db`
--
DROP DATABASE IF EXISTS `storage_units_db`;
CREATE DATABASE `storage_units_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `storage_units_db`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_first_name` varchar(20) NOT NULL,
  `admin_last_name` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_id` (`admin_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_first_name`, `admin_last_name`) VALUES
(1, 'Michael', 'Fesser');

-- --------------------------------------------------------

--
-- Table structure for table `admin_login`
--

DROP TABLE IF EXISTS `admin_login`;
CREATE TABLE IF NOT EXISTS `admin_login` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_login_code` int(11) NOT NULL,
  `admin_login_username` varchar(20) NOT NULL,
  `admin_login_password` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `admin_login`
--

INSERT INTO `admin_login` (`admin_id`, `admin_login_code`, `admin_login_username`, `admin_login_password`) VALUES
(1, 378, 'admin.pyrolight', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_first_name` varchar(20) NOT NULL,
  `cus_middle_initial` varchar(1) DEFAULT NULL,
  `cus_last_name` varchar(20) NOT NULL,
  `cus_address` varchar(20) NOT NULL,
  `cus_city` varchar(20) NOT NULL,
  `cus_province` varchar(20) NOT NULL,
  `cus_postal_code` varchar(20) NOT NULL,
  `cus_phone` varchar(20) NOT NULL,
  `cus_email` varchar(20) NOT NULL,
  PRIMARY KEY (`cus_id`),
  UNIQUE KEY `cus_id` (`cus_id`),
  UNIQUE KEY `cus_id_2` (`cus_id`),
  UNIQUE KEY `cus_id_3` (`cus_id`),
  UNIQUE KEY `cus_id_4` (`cus_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `cus_first_name`, `cus_middle_initial`, `cus_last_name`, `cus_address`, `cus_city`, `cus_province`, `cus_postal_code`, `cus_phone`, `cus_email`) VALUES
(1, 'Bruce', 'J', 'Maclean', '2338 hereabouts', 'Charlottetown', 'PE', 'C1C2C2', '1234567890', '1@2.com'),
(2, 'Mike', 'A', 'Fesser', '251 Keppoch RD', 'Startford', 'PE', 'C1C2C2', '1234567890', '1@2.com'),
(3, 'Roger', 'J', 'Myers', '221 over yonder', 'Startford', 'PE', 'C1C2C2', '1234567890', '1@2.com'),
(4, 'Andrew', '', 'Reid', '987 over yonder', 'Charlottetown', 'PE', 'C1C2C2', '9028765309', '1@2.com');

-- --------------------------------------------------------

--
-- Table structure for table `customer_login`
--

DROP TABLE IF EXISTS `customer_login`;
CREATE TABLE IF NOT EXISTS `customer_login` (
  `cus_id` int(11) NOT NULL,
  `cus_login_username` varchar(20) NOT NULL,
  `cus_login_password` varchar(20) NOT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_login`
--

INSERT INTO `customer_login` (`cus_id`, `cus_login_username`, `cus_login_password`) VALUES
(1, 'BJ', 'password'),
(2, 'Pyrolight', 'password2'),
(3, 'DOTA2', 'password3'),
(4, 'Drew', 'password4');

-- --------------------------------------------------------

--
-- Table structure for table `customer_unit`
--

DROP TABLE IF EXISTS `customer_unit`;
CREATE TABLE IF NOT EXISTS `customer_unit` (
  `unit_id` int(11) NOT NULL,
  `cus_id` int(11) NOT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_id` (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `unit_id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_type` varchar(20) NOT NULL,
  `unit_dimensions` varchar(20) NOT NULL,
  `unit_avalibility` tinyint(1) NOT NULL,
  `unit_date_from` varchar(20) NOT NULL,
  `unit_date_to` varchar(20) NOT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_id` (`unit_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`unit_id`, `unit_type`, `unit_dimensions`, `unit_avalibility`, `unit_date_from`, `unit_date_to`) VALUES
(1, 'small', '10x10', 0, '', ''),
(2, 'large', '20x20', 0, '', ''),
(3, 'large', '20x20', 0, '', ''),
(4, 'small', '10x10', 0, '', ''),
(5, 'medium', '15x15', 0, '', ''),
(6, 'medium', '15x15', 0, '', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
