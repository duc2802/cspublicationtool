/*
SQLyog Enterprise - MySQL GUI v8.12 
MySQL - 5.0.51b-community-nt-log : Database - cspublicationcrawler
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`cspublicationcrawler` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cspublicationcrawler`;

/*Table structure for table `_rank_author` */

DROP TABLE IF EXISTS `_rank_author`;

CREATE TABLE `_rank_author` (
  `idAuthor` int(10) NOT NULL,
  `publicationCount` int(10) default NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  `coAuthorCount` int(10) default NULL,
  PRIMARY KEY  (`idAuthor`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_author_keyword` */

DROP TABLE IF EXISTS `_rank_author_keyword`;

CREATE TABLE `_rank_author_keyword` (
  `idAuthor` int(10) NOT NULL,
  `idKeyword` int(10) NOT NULL,
  `publicationCount` int(10) default NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  `coAuthorCount` int(10) default NULL,
  PRIMARY KEY  (`idAuthor`,`idKeyword`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_author_subdomain` */

DROP TABLE IF EXISTS `_rank_author_subdomain`;

CREATE TABLE `_rank_author_subdomain` (
  `idAuthor` int(10) NOT NULL,
  `idSubdomain` int(10) NOT NULL,
  `publicationCount` int(10) default NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  `coAuthorCount` int(10) default NULL,
  PRIMARY KEY  (`idAuthor`,`idSubdomain`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_conference_keyword` */

DROP TABLE IF EXISTS `_rank_conference_keyword`;

CREATE TABLE `_rank_conference_keyword` (
  `idConference` int(10) NOT NULL,
  `idKeyword` int(10) NOT NULL,
  `publicationCount` int(10) default NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  PRIMARY KEY  (`idConference`,`idKeyword`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_org` */

DROP TABLE IF EXISTS `_rank_org`;

CREATE TABLE `_rank_org` (
  `idOrg` int(10) NOT NULL,
  `publicationCount` int(10) default NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  `authorCount` int(10) default NULL,
  PRIMARY KEY  (`idOrg`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_org_keyword` */

DROP TABLE IF EXISTS `_rank_org_keyword`;

CREATE TABLE `_rank_org_keyword` (
  `idOrg` int(10) NOT NULL,
  `idKeyword` int(10) NOT NULL,
  `publicationCount` int(10) default NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  `authorCount` int(10) default NULL,
  PRIMARY KEY  (`idOrg`,`idKeyword`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_org_subdomain` */

DROP TABLE IF EXISTS `_rank_org_subdomain`;

CREATE TABLE `_rank_org_subdomain` (
  `idOrg` int(10) NOT NULL,
  `idSubdomain` int(10) NOT NULL,
  `publicationCount` int(10) default NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  `authorCount` int(10) default NULL,
  PRIMARY KEY  (`idOrg`,`idSubdomain`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_paper` */

DROP TABLE IF EXISTS `_rank_paper`;

CREATE TABLE `_rank_paper` (
  `idPaper` int(10) NOT NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  PRIMARY KEY  (`idPaper`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_paper_keyword` */

DROP TABLE IF EXISTS `_rank_paper_keyword`;

CREATE TABLE `_rank_paper_keyword` (
  `idPaper` int(10) NOT NULL,
  `idKeyword` int(10) NOT NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  PRIMARY KEY  (`idPaper`,`idKeyword`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `_rank_paper_subdomain` */

DROP TABLE IF EXISTS `_rank_paper_subdomain`;

CREATE TABLE `_rank_paper_subdomain` (
  `idPaper` int(10) NOT NULL,
  `idSubdomain` int(10) NOT NULL,
  `citationCount` int(10) default NULL,
  `rank` int(10) NOT NULL auto_increment,
  PRIMARY KEY  (`idPaper`,`idSubdomain`),
  KEY `index2` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `idAuthor` int(10) unsigned NOT NULL auto_increment,
  `authorName` varchar(1000) default NULL,
  `image` varchar(1000) default NULL,
  `emailAddress` varchar(1000) default NULL,
  `website` varchar(1000) default NULL,
  `idOrg` int(10) unsigned default NULL,
  `h_index` int(3) default NULL,
  `g_index` int(3) default NULL,
  `url` varchar(1000) default NULL,
  PRIMARY KEY  (`idAuthor`),
  KEY `fk_Author_Org` (`idOrg`),
  KEY `index_Author_url` (`url`(255)),
  CONSTRAINT `fk_Author_Org` FOREIGN KEY (`idOrg`) REFERENCES `org` (`idOrg`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43488 DEFAULT CHARSET=utf8;

/*Table structure for table `author_paper` */

DROP TABLE IF EXISTS `author_paper`;

CREATE TABLE `author_paper` (
  `idAuthor` int(10) unsigned NOT NULL,
  `idPaper` int(10) unsigned NOT NULL,
  CONSTRAINT `fk_Author_has_Paper_Author1` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`idAuthor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Author_has_Paper_Paper1` FOREIGN KEY (`idPaper`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `authorinstance` */

DROP TABLE IF EXISTS `authorinstance`;

CREATE TABLE `authorinstance` (
  `autoID` int(10) unsigned NOT NULL auto_increment,
  `instanceName` varchar(1000) default NULL,
  `idAuthor` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`autoID`),
  KEY `fk_authorInstance_Author1` (`idAuthor`),
  CONSTRAINT `fk_authorInstance_Author1` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`idAuthor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `idComment` int(10) unsigned NOT NULL auto_increment,
  `rating` int(1) default NULL,
  `content` varchar(20000) default NULL,
  `idPaper` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idComment`),
  KEY `fk_Comment_Paper1` (`idPaper`),
  CONSTRAINT `fk_Comment_Paper1` FOREIGN KEY (`idPaper`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `conference` */

DROP TABLE IF EXISTS `conference`;

CREATE TABLE `conference` (
  `idConference` int(10) unsigned NOT NULL auto_increment,
  `conferenceName` varchar(1000) default NULL,
  `website` varchar(1000) default NULL,
  `organization` varchar(1000) default NULL,
  `organizedLocation` varchar(1000) default NULL,
  `duration` varchar(1000) default NULL,
  `yearStart` int(10) unsigned default NULL,
  `yearEnd` int(10) unsigned default NULL,
  `url` varchar(1000) default NULL,
  PRIMARY KEY  (`idConference`),
  KEY `index_Conference_url` (`url`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `conference_pcmember` */

DROP TABLE IF EXISTS `conference_pcmember`;

CREATE TABLE `conference_pcmember` (
  `idConference` int(10) unsigned NOT NULL,
  `idPCMember` int(10) unsigned NOT NULL,
  `year` int(10) unsigned default NULL,
  PRIMARY KEY  (`idConference`,`idPCMember`),
  KEY `fk_Conference_has_pcMember_pcMember1` (`idPCMember`),
  KEY `fk_Conference_has_pcMember_Conference1` (`idConference`),
  CONSTRAINT `fk_Conference_has_pcMember_Conference1` FOREIGN KEY (`idConference`) REFERENCES `conference` (`idConference`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conference_has_pcMember_pcMember1` FOREIGN KEY (`idPCMember`) REFERENCES `pcmember` (`idPCMember`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `domain` */

DROP TABLE IF EXISTS `domain`;

CREATE TABLE `domain` (
  `idDomain` int(10) unsigned NOT NULL auto_increment,
  `domainName` varchar(1000) default NULL,
  PRIMARY KEY  (`idDomain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `journal` */

DROP TABLE IF EXISTS `journal`;

CREATE TABLE `journal` (
  `idJournal` int(10) unsigned NOT NULL auto_increment,
  `journalName` varchar(1000) default NULL,
  `website` varchar(1000) default NULL,
  `yearStart` int(10) unsigned default NULL,
  `yearEnd` int(10) unsigned default NULL,
  `organization` varchar(1000) default NULL,
  `url` varchar(1000) default NULL,
  PRIMARY KEY  (`idJournal`),
  KEY `index_Journal_url` (`url`(255))
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8;

/*Table structure for table `keyword` */

DROP TABLE IF EXISTS `keyword`;

CREATE TABLE `keyword` (
  `idKeyword` int(10) unsigned NOT NULL auto_increment,
  `keyword` varchar(1000) default NULL,
  `stemmingVariations` varchar(10000) default NULL,
  `url` varchar(1000) default NULL,
  PRIMARY KEY  (`idKeyword`),
  KEY `index_Keyword_url` (`url`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `magazine` */

DROP TABLE IF EXISTS `magazine`;

CREATE TABLE `magazine` (
  `idMagazine` int(10) unsigned NOT NULL auto_increment,
  `magazineName` varchar(1000) default NULL,
  `website` varchar(1000) default NULL,
  `yearStart` int(10) unsigned default NULL,
  `yearEnd` int(10) unsigned default NULL,
  `organization` varchar(1000) default NULL,
  `url` varchar(1000) default NULL,
  PRIMARY KEY  (`idMagazine`),
  KEY `index_Magazine_url` (`url`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `org` */

DROP TABLE IF EXISTS `org`;

CREATE TABLE `org` (
  `idOrg` int(10) unsigned NOT NULL auto_increment,
  `orgName` varchar(1000) default NULL,
  `website` varchar(1000) default NULL,
  `continent` varchar(1000) default NULL,
  `idOrgParent` int(10) unsigned default NULL,
  `h_index` int(3) default NULL,
  `url` varchar(1000) default NULL,
  PRIMARY KEY  (`idOrg`),
  KEY `fk_Org_Org1` (`idOrgParent`),
  KEY `index_Org_url` (`url`(255)),
  CONSTRAINT `fk_Org_Org1` FOREIGN KEY (`idOrgParent`) REFERENCES `org` (`idOrg`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `paper` */

DROP TABLE IF EXISTS `paper`;

CREATE TABLE `paper` (
  `idPaper` int(10) unsigned NOT NULL auto_increment,
  `doi` varchar(100) default NULL,
  `isbn` varchar(100) default NULL,
  `url` varchar(1000) default NULL,
  `title` varchar(1000) default NULL,
  `abstract` varchar(10000) default NULL,
  `volume` varchar(100) default NULL,
  `pages` varchar(100) default NULL,
  `year` int(10) unsigned default NULL,
  `viewPublication` text,
  `bibTex` varchar(1000) default NULL,
  `endNote` varchar(1000) default NULL,
  `idJournal` int(10) unsigned default NULL,
  `idConference` int(10) unsigned default NULL,
  `idMagazine` int(10) unsigned default NULL,
  `idPublisher` int(10) unsigned default NULL,
  `idPaperType` int(10) unsigned default NULL,
  `dblpKey` varchar(1000) default NULL,
  `version` int(3) default NULL,
  `paperFile` varchar(1000) default NULL,
  PRIMARY KEY  (`idPaper`),
  KEY `fk_Paper_Journal1` (`idJournal`),
  KEY `fk_Paper_Conference1` (`idConference`),
  KEY `fk_Paper_Magazine1` (`idMagazine`),
  KEY `fk_Paper_Publisher1` (`idPublisher`),
  KEY `fk_Paper_PaperType1` (`idPaperType`),
  KEY `index_Paper_url` (`url`(255)),
  CONSTRAINT `fk_Paper_Conference1` FOREIGN KEY (`idConference`) REFERENCES `conference` (`idConference`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_Journal1` FOREIGN KEY (`idJournal`) REFERENCES `journal` (`idJournal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_Magazine1` FOREIGN KEY (`idMagazine`) REFERENCES `magazine` (`idMagazine`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_PaperType1` FOREIGN KEY (`idPaperType`) REFERENCES `paper_type` (`idPaperType`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_Publisher1` FOREIGN KEY (`idPublisher`) REFERENCES `publisher` (`idPublisher`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=74655 DEFAULT CHARSET=utf8;

/*Table structure for table `paper_keyword` */

DROP TABLE IF EXISTS `paper_keyword`;

CREATE TABLE `paper_keyword` (
  `idPaper` int(10) unsigned NOT NULL,
  `idKeyword` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idPaper`,`idKeyword`),
  KEY `fk_Paper_has_Keyword_Keyword1` (`idKeyword`),
  KEY `fk_Paper_has_Keyword_Paper1` (`idPaper`),
  CONSTRAINT `fk_Paper_has_Keyword_Keyword1` FOREIGN KEY (`idKeyword`) REFERENCES `keyword` (`idKeyword`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_has_Keyword_Paper1` FOREIGN KEY (`idPaper`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `paper_paper` */

DROP TABLE IF EXISTS `paper_paper`;

CREATE TABLE `paper_paper` (
  `idPaper` int(10) unsigned NOT NULL,
  `idPaperRef` int(10) unsigned NOT NULL,
  `citationContext` varchar(20000) default NULL,
  PRIMARY KEY  (`idPaper`,`idPaperRef`),
  KEY `fk_Paper_has_Paper_Paper2` (`idPaperRef`),
  KEY `fk_Paper_has_Paper_Paper1` (`idPaper`),
  CONSTRAINT `fk_Paper_has_Paper_Paper1` FOREIGN KEY (`idPaper`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_has_Paper_Paper2` FOREIGN KEY (`idPaperRef`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `paper_reviewer` */

DROP TABLE IF EXISTS `paper_reviewer`;

CREATE TABLE `paper_reviewer` (
  `idPaper` int(10) unsigned NOT NULL,
  `idReviewer` int(10) unsigned NOT NULL,
  `rating` int(1) default NULL,
  `content` varchar(20000) default NULL,
  PRIMARY KEY  (`idPaper`,`idReviewer`),
  KEY `fk_Paper_has_Reviewer_Reviewer1` (`idReviewer`),
  KEY `fk_Paper_has_Reviewer_Paper1` (`idPaper`),
  CONSTRAINT `fk_Paper_has_Reviewer_Paper1` FOREIGN KEY (`idPaper`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_has_Reviewer_Reviewer1` FOREIGN KEY (`idReviewer`) REFERENCES `reviewer` (`idReviewer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `paper_type` */

DROP TABLE IF EXISTS `paper_type`;

CREATE TABLE `paper_type` (
  `idPaperType` int(10) unsigned NOT NULL auto_increment,
  `nameType` varchar(1000) default NULL,
  PRIMARY KEY  (`idPaperType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `pcmember` */

DROP TABLE IF EXISTS `pcmember`;

CREATE TABLE `pcmember` (
  `idPCMember` int(10) unsigned NOT NULL auto_increment,
  `pcMemberName` varchar(1000) default NULL,
  `image` varchar(1000) default NULL,
  `emailAddress` varchar(1000) default NULL,
  `website` varchar(1000) default NULL,
  `organization` varchar(1000) default NULL,
  PRIMARY KEY  (`idPCMember`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `idPublisher` int(10) unsigned NOT NULL auto_increment,
  `namePublisher` varchar(1000) default NULL,
  PRIMARY KEY  (`idPublisher`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Table structure for table `reviewer` */

DROP TABLE IF EXISTS `reviewer`;

CREATE TABLE `reviewer` (
  `idReviewer` int(10) unsigned NOT NULL auto_increment,
  `reviewerName` varchar(1000) default NULL,
  `image` varchar(1000) default NULL,
  `emailAddress` varchar(1000) default NULL,
  `website` varchar(1000) default NULL,
  `organization` varchar(1000) default NULL,
  PRIMARY KEY  (`idReviewer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `subdomain` */

DROP TABLE IF EXISTS `subdomain`;

CREATE TABLE `subdomain` (
  `idSubdomain` int(10) unsigned NOT NULL auto_increment,
  `subdomainName` varchar(1000) default NULL,
  `idDomain` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idSubdomain`),
  KEY `fk_Subdomain_Domain1` (`idDomain`),
  CONSTRAINT `fk_Subdomain_Domain1` FOREIGN KEY (`idDomain`) REFERENCES `domain` (`idDomain`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
