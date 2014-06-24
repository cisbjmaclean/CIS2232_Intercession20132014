-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 18, 2014 at 07:32 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `student`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(5) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `dob` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Student information';

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `last_name`, `dob`) VALUES
(1, 'Roger', 'Myers', '1988-02-12'),
(2, 'Andrew', 'Reid', '2000-01-01'),
(1020, 'a', 'b', 'c'),
(1026, 'A', 'B', 'C'),
(1027, 'a', 'B', 'c'),
(1028, 'a', 'b', 'c'),
(1221, 'A', 'B', 'C'),
(1337, 'Roger', 'Myers', '8797987'),
(5644, 'Super', 'Obvious', '456454'),
(11111, 'Andrew', 'Macleean', '1999-01-02'),
(12222, 'Michael', 'Fesser', '22222222'),
(12345, 'BJ', 'MacLean', '2222222'),
(33333, 'John', 'Power', '1888-11-14'),
(65456, 'Mike', 'Fesser2', '33333333'),
(66554, 'Ryan', 'Forrester', '19930303'),
(88888, 'John', 'Smith', '2001-01-05'),
(99999, 'Steve', 'Bell', '1998-02-09'),
(123885, 'Ash', 'Ketchum', '06061995'),
(1221321, 'Bruce', 'Sprinsteen', '4456464'),
(5318008, 'Hashmaps', 'AreLame', '1998-02-19'),
(45646544, 'Bruce', 'Moose', '5464654'),
(65465499, 'Lord', 'Gaben', '5646546');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
