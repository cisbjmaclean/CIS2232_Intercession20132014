-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 24, 2014 at 10:27 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `soccer`
--

-- --------------------------------------------------------

--
-- Table structure for table `booked_field`
--

CREATE TABLE IF NOT EXISTS `booked_field` (
  `FIELD_NUM` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `TIME_NUM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booked_field`
--

INSERT INTO `booked_field` (`FIELD_NUM`, `USER_ID`, `DATE`, `TIME_NUM`) VALUES
(1, 1, '2014-06-16', 2),
(2, 1, '2014-06-18', 1),
(1, 1, '2014-06-17', 3),
(5, 1, '2014-06-17', 1),
(1, 2, '2014-06-17', 1),
(3, 2, '2014-06-18', 7),
(1, 1, '2014-06-19', 1),
(1, 3, '2014-06-20', 1),
(3, 2, '2014-06-20', 5),
(1, 3, '2014-06-18', 1),
(1, 1, '2014-06-22', 1),
(2, 1, '2014-06-22', 1),
(1, 1, '2014-06-23', 1),
(3, 1, '2014-06-25', 1),
(5, 1, '2014-06-27', 5),
(4, 2, '2014-06-27', 3),
(3, 2, '2014-06-28', 9),
(3, 3, '2014-06-23', 4),
(1, 1, '2014-06-28', 1),
(4, 1, '2014-06-23', 1),
(1, 1, '2014-06-23', 3),
(3, 1, '2014-06-27', 7),
(1, 1, '2014-06-24', 1),
(4, 1, '2014-06-24', 1),
(3, 6, '2014-06-24', 1),
(1, 1, '2014-06-25', 1),
(4, 3, '2014-06-27', 6),
(1, 3, '2014-06-28', 2),
(5, 10, '2014-06-24', 1),
(4, 1, '2014-06-26', 8),
(5, 1, '2014-06-30', 9),
(2, 1, '2014-06-25', 1),
(3, 1, '2014-06-27', 6);

-- --------------------------------------------------------

--
-- Table structure for table `field`
--

CREATE TABLE IF NOT EXISTS `field` (
  `FIELD_NUM` int(10) NOT NULL,
  `FIELD_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`FIELD_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `field`
--

INSERT INTO `field` (`FIELD_NUM`, `FIELD_NAME`) VALUES
(1, 'Center Field'),
(2, 'Left Field'),
(3, 'Right Field'),
(4, 'Back Field'),
(5, 'Top Field');

-- --------------------------------------------------------

--
-- Table structure for table `time`
--

CREATE TABLE IF NOT EXISTS `time` (
  `TIME_NUM` int(10) NOT NULL,
  `TIME_DEF` varchar(20) NOT NULL,
  PRIMARY KEY (`TIME_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `time`
--

INSERT INTO `time` (`TIME_NUM`, `TIME_DEF`) VALUES
(1, '12:00-1:00'),
(2, '1:00-2:00'),
(3, '2:00-3:00'),
(4, '3:00-4:00'),
(5, '4:00-5:00'),
(6, '5:00-6:00'),
(7, '6:00-7:00'),
(8, '7:00-8:00'),
(9, '8:00-9:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USER_ID`, `NAME`, `PASSWORD`) VALUES
(1, 'Ryan', '1234'),
(2, 'Test', '1234'),
(3, 'Foot', '1234'),
(4, 'ralph', '1234'),
(5, 'Roger', '1234'),
(6, 'George', '1234'),
(7, 'Bill', '1'),
(10, 'Ron', '1'),
(11, 'asdfasd', 'sdf'),
(12, 'Frank', '1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
