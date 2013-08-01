SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Aug 15, 2011 at 04:04 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `cspublicationcrawler`
-- 

-- 
-- Dumping data for table `domain`
-- 

INSERT INTO `domain` (`idDomain`, `domainName`) VALUES (2, 'Computer Science');

-- 
-- Dumping data for table `subdomain`
-- 

INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (1, 'Algorithms & Theory', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (2, 'Security & Privacy', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (3, 'Hardware & Architecture', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (4, 'Software Engineering', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (5, 'Artificial Intelligence', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (6, 'Machine Learning & Pattern Recognition', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (7, 'Data Mining', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (8, 'Information Retrieval', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (9, 'Natural Language & Speech', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (10, 'Graphics', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (11, 'Computer Vision', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (12, 'Human-Computer Interaction', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (13, 'Multimedia', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (14, 'Networks & Communications', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (15, 'World Wide Web', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (16, 'Distributed & Parallel Computing', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (17, 'Operating Systems', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (18, 'Databases', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (19, 'Real-Time & Embedded Systems', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (20, 'Simulation', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (21, 'Bioinformatics & Computational Biology', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (22, 'Scientific Computing', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (23, 'Computer Education', 2);
INSERT INTO `subdomain` (`idSubdomain`, `subdomainName`, `idDomain`) VALUES (24, 'Programming Languages', 2);

SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
