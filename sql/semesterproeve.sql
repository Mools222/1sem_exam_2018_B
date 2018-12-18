-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:33067
-- Generation Time: Dec 18, 2018 at 09:39 AM
-- Server version: 5.6.40-log
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `semesterproeve`
--
CREATE DATABASE IF NOT EXISTS `semesterproeve` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `semesterproeve`;

-- --------------------------------------------------------

--
-- Table structure for table `artikel`
--

DROP TABLE IF EXISTS `artikel`;
CREATE TABLE IF NOT EXISTS `artikel` (
  `ArtikelID` int(11) NOT NULL,
  `Forfatter` varchar(45) NOT NULL,
  `Artikeltekst` longtext NOT NULL,
  `Tilhoerende_billede` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artikel`
--

INSERT INTO `artikel` (`ArtikelID`, `Forfatter`, `Artikeltekst`, `Tilhoerende_billede`) VALUES
(1, 'Some Guy', 'Bla bla bla.', 'media\\guy.tiff');

-- --------------------------------------------------------

--
-- Table structure for table `billede`
--

DROP TABLE IF EXISTS `billede`;
CREATE TABLE IF NOT EXISTS `billede` (
  `BilledeID` int(11) NOT NULL,
  `Filtype` varchar(45) NOT NULL,
  `Bredde_i_pixels` int(11) NOT NULL,
  `Hoejde_i_pixels` int(11) NOT NULL,
  `Fotograf` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billede`
--

INSERT INTO `billede` (`BilledeID`, `Filtype`, `Bredde_i_pixels`, `Hoejde_i_pixels`, `Fotograf`) VALUES
(1, 'gif', 595, 842, 'Peter Kurtsen');

-- --------------------------------------------------------

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `VideoID` int(11) NOT NULL,
  `Filtype` varchar(45) NOT NULL,
  `Laengde` varchar(45) NOT NULL,
  `Oploesning` varchar(45) NOT NULL,
  `Fotograf` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `video`
--

INSERT INTO `video` (`VideoID`, `Filtype`, `Laengde`, `Oploesning`, `Fotograf`) VALUES
(1, 'mov', '2:25', '720p', 'Kurt Petersen');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artikel`
--
ALTER TABLE `artikel`
  ADD PRIMARY KEY (`ArtikelID`);

--
-- Indexes for table `billede`
--
ALTER TABLE `billede`
  ADD PRIMARY KEY (`BilledeID`);

--
-- Indexes for table `video`
--
ALTER TABLE `video`
  ADD PRIMARY KEY (`VideoID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artikel`
--
ALTER TABLE `artikel`
  MODIFY `ArtikelID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `billede`
--
ALTER TABLE `billede`
  MODIFY `BilledeID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `video`
--
ALTER TABLE `video`
  MODIFY `VideoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
