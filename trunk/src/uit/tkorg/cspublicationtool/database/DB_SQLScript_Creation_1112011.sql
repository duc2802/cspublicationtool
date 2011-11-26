SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `CSPublicationCrawler` ;
CREATE SCHEMA IF NOT EXISTS `CSPublicationCrawler` DEFAULT CHARACTER SET utf8 ;
USE `CSPublicationCrawler` ;

-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Org`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Org` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Org` (
  `idOrg` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `orgName` VARCHAR(1000) NULL ,
  `website` VARCHAR(1000) NULL DEFAULT NULL ,
  `continent` VARCHAR(1000) NULL DEFAULT NULL ,
  `idOrgParent` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `h_index` INT(3) NULL DEFAULT NULL ,
  `url` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idOrg`) ,
  INDEX `fk_Org_Org1` (`idOrgParent` ASC) ,
  INDEX `index_Org_url` (`url` ASC) ,
  CONSTRAINT `fk_Org_Org1`
    FOREIGN KEY (`idOrgParent` )
    REFERENCES `CSPublicationCrawler`.`Org` (`idOrg` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Author` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Author` (
  `idAuthor` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `authorName` VARCHAR(1000) NULL ,
  `image` VARCHAR(1000) NULL DEFAULT NULL ,
  `emailAddress` VARCHAR(1000) NULL DEFAULT NULL ,
  `website` VARCHAR(1000) NULL DEFAULT NULL ,
  `idOrg` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `h_index` INT(3) NULL DEFAULT NULL ,
  `g_index` INT(3) NULL DEFAULT NULL ,
  `url` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idAuthor`) ,
  INDEX `fk_Author_Org` (`idOrg` ASC) ,
  INDEX `index_Author_url` (`url` ASC) ,
  CONSTRAINT `fk_Author_Org`
    FOREIGN KEY (`idOrg` )
    REFERENCES `CSPublicationCrawler`.`Org` (`idOrg` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Paper_Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Paper_Type` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Paper_Type` (
  `idPaperType` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nameType` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idPaperType`)  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Conference`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Conference` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Conference` (
  `idConference` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `conferenceName` VARCHAR(1000) NULL ,
  `website` VARCHAR(1000) NULL DEFAULT NULL ,
  `organization` VARCHAR(1000) NULL DEFAULT NULL ,
  `organizedLocation` VARCHAR(1000) NULL DEFAULT NULL ,
  `duration` VARCHAR(1000) NULL DEFAULT NULL ,
  `yearStart` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `yearEnd` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `url` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idConference`) ,
  INDEX `index_Conference_url` (`url` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Publisher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Publisher` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Publisher` (
  `idPublisher` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `namePublisher` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idPublisher`)  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-------------------------------
-- Table `CSPublicationCrawler`.`Journal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Journal` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Journal` (
  `idJournal` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `journalName` VARCHAR(1000) NULL ,
  `website` VARCHAR(1000) NULL DEFAULT NULL ,
  `yearStart` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `yearEnd` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `organization` VARCHAR(1000) NULL DEFAULT NULL ,
  `url` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idJournal`) ,
  INDEX `index_Journal_url` (`url` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Keyword` (
  `idKeyword` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `keyword` VARCHAR(1000) NULL ,
  `stemmingVariations` VARCHAR(10000) NULL DEFAULT NULL ,
  `url` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idKeyword`) ,
  INDEX `index_Keyword_url` (`url` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Magazine`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Magazine` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Magazine` (
  `idMagazine` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `magazineName` VARCHAR(1000) NULL ,
  `website` VARCHAR(1000) NULL DEFAULT NULL ,
  `yearStart` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `yearEnd` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `organization` VARCHAR(1000) NULL DEFAULT NULL ,
  `url` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idMagazine`) ,
  INDEX `index_Magazine_url` (`url` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Paper` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Paper` (
  `idPaper` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `doi` VARCHAR(100) NULL DEFAULT NULL ,
  `isbn` VARCHAR(100) NULL DEFAULT NULL ,
  `url` VARCHAR(1000) NULL DEFAULT NULL ,
  `title` VARCHAR(1000) NULL ,
  `abstract` VARCHAR(10000) NULL DEFAULT NULL ,
  `volume` VARCHAR(100) NULL DEFAULT NULL ,
  `pages` VARCHAR(100) NULL DEFAULT NULL ,
  `year` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `viewPublication` TEXT(20000) NULL DEFAULT NULL ,
  `bibTex` VARCHAR(1000) NULL DEFAULT NULL ,
  `endNote` VARCHAR(1000) NULL DEFAULT NULL ,
  `idJournal` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `idConference` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `idMagazine` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `idPublisher` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `idPaperType` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `dblpKey` VARCHAR(1000) NULL DEFAULT NULL ,
  `version` INT(3) NULL DEFAULT NULL ,
  `paperFile` VARCHAR(1000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPaper`) ,
  INDEX `fk_Paper_Journal1` (`idJournal` ASC) ,
  INDEX `fk_Paper_Conference1` (`idConference` ASC) ,
  INDEX `fk_Paper_Magazine1` (`idMagazine` ASC) ,
  INDEX `fk_Paper_Publisher1` (`idPublisher` ASC) ,
  INDEX `fk_Paper_PaperType1` (`idPaperType` ASC) ,
  INDEX `index_Paper_url` (`url` ASC) ,
  CONSTRAINT `fk_Paper_Journal1`
    FOREIGN KEY (`idJournal` )
    REFERENCES `CSPublicationCrawler`.`Journal` (`idJournal` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `fk_Paper_Publisher1`
    FOREIGN KEY (`idPublisher` )
    REFERENCES `CSPublicationCrawler`.`Publisher` (`idPublisher` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `fk_Paper_PaperType1`
    FOREIGN KEY (`idPaperType` )
    REFERENCES `CSPublicationCrawler`.`Paper_Type` (`idPaperType` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_Conference1`
    FOREIGN KEY (`idConference` )
    REFERENCES `CSPublicationCrawler`.`Conference` (`idConference` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_Magazine1`
    FOREIGN KEY (`idMagazine` )
    REFERENCES `CSPublicationCrawler`.`Magazine` (`idMagazine` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Domain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Domain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Domain` (
  `idDomain` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `domainName` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idDomain`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Subdomain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Subdomain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Subdomain` (
  `idSubdomain` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `subdomainName` VARCHAR(1000) NULL ,
  `idDomain` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idSubdomain`) ,
  INDEX `fk_Subdomain_Domain1` (`idDomain` ASC) ,
  CONSTRAINT `fk_Subdomain_Domain1`
    FOREIGN KEY (`idDomain` )
    REFERENCES `CSPublicationCrawler`.`Domain` (`idDomain` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Paper_Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Paper_Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Paper_Keyword` (
  `idPaper` INT(10) UNSIGNED NOT NULL ,
  `idKeyword` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idPaper`, `idKeyword`) ,
  INDEX `fk_Paper_has_Keyword_Keyword1` (`idKeyword` ASC) ,
  INDEX `fk_Paper_has_Keyword_Paper1` (`idPaper` ASC) ,
  CONSTRAINT `fk_Paper_has_Keyword_Paper1`
    FOREIGN KEY (`idPaper` )
    REFERENCES `CSPublicationCrawler`.`Paper` (`idPaper` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_has_Keyword_Keyword1`
    FOREIGN KEY (`idKeyword` )
    REFERENCES `CSPublicationCrawler`.`Keyword` (`idKeyword` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Paper_Paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Paper_Paper` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Paper_Paper` (
  `idPaper` INT(10) UNSIGNED NOT NULL ,
  `idPaperRef` INT(10) UNSIGNED NOT NULL ,
  `citationContext` VARCHAR(20000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPaper`, `idPaperRef`) ,
  INDEX `fk_Paper_has_Paper_Paper2` (`idPaperRef` ASC) ,
  INDEX `fk_Paper_has_Paper_Paper1` (`idPaper` ASC) ,
  CONSTRAINT `fk_Paper_has_Paper_Paper1`
    FOREIGN KEY (`idPaper` )
    REFERENCES `CSPublicationCrawler`.`Paper` (`idPaper` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_has_Paper_Paper2`
    FOREIGN KEY (`idPaperRef` )
    REFERENCES `CSPublicationCrawler`.`Paper` (`idPaper` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Publisher_Conference`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Publisher_Conference` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Publisher_Conference` (
  `idPublisher` INT(10) UNSIGNED NOT NULL ,
  `idConference` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idPublisher`, `idConference`) ,
  INDEX `fk_Publisher_has_Conference1` (`idPublisher` ASC) ,
  INDEX `fk_Confence_of_Publisher1` (`idConference` ASC) ,
  CONSTRAINT `fk_Publisher_has_Conference1`
    FOREIGN KEY (`idPublisher` )
    REFERENCES `CSPublicationCrawler`.`Publisher` (`idPublisher` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Confence_of_Publisher1`
    FOREIGN KEY (`idConference` )
    REFERENCES `CSPublicationCrawler`.`Conference` (`idConference` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Author_Paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Author_Paper` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Author_Paper` (
  `idAuthor` INT(10) UNSIGNED NOT NULL ,
  `idPaper` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idAuthor`, `idPaper`) ,
  INDEX `fk_Author_has_Paper_Paper1` (`idPaper` ASC) ,
  INDEX `fk_Author_has_Paper_Author1` (`idAuthor` ASC) ,
  CONSTRAINT `fk_Author_has_Paper_Author1`
    FOREIGN KEY (`idAuthor` )
    REFERENCES `CSPublicationCrawler`.`Author` (`idAuthor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Author_has_Paper_Paper1`
    FOREIGN KEY (`idPaper` )
    REFERENCES `CSPublicationCrawler`.`Paper` (`idPaper` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`PCMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`PCMember` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`PCMember` (
  `idPCMember` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `pcMemberName` VARCHAR(1000) NULL ,
  `image` VARCHAR(1000) NULL DEFAULT NULL ,
  `emailAddress` VARCHAR(1000) NULL DEFAULT NULL ,
  `website` VARCHAR(1000) NULL DEFAULT NULL ,
  `organization` VARCHAR(1000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPCMember`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Conference_PCMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Conference_PCMember` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Conference_PCMember` (
  `idConference` INT(10) UNSIGNED NOT NULL ,
  `idPCMember` INT(10) UNSIGNED NOT NULL ,
  `year` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`idConference`, `idPCMember`) ,
  INDEX `fk_Conference_has_pcMember_pcMember1` (`idPCMember` ASC) ,
  INDEX `fk_Conference_has_pcMember_Conference1` (`idConference` ASC) ,
  CONSTRAINT `fk_Conference_has_pcMember_Conference1`
    FOREIGN KEY (`idConference` )
    REFERENCES `CSPublicationCrawler`.`Conference` (`idConference` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conference_has_pcMember_pcMember1`
    FOREIGN KEY (`idPCMember` )
    REFERENCES `CSPublicationCrawler`.`PCMember` (`idPCMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`AuthorInstance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`AuthorInstance` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`AuthorInstance` (
  `autoID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `instanceName` VARCHAR(1000) NULL ,
  `idAuthor` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`autoID`) ,
  INDEX `fk_authorInstance_Author1` (`idAuthor` ASC) ,
  CONSTRAINT `fk_authorInstance_Author1`
    FOREIGN KEY (`idAuthor` )
    REFERENCES `CSPublicationCrawler`.`Author` (`idAuthor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Comment` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Comment` (
  `idComment` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `rating` INT(1) NULL DEFAULT NULL ,
  `content` VARCHAR(20000) NULL DEFAULT NULL ,
  `idPaper` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idComment`) ,
  INDEX `fk_Comment_Paper1` (`idPaper` ASC) ,
  CONSTRAINT `fk_Comment_Paper1`
    FOREIGN KEY (`idPaper` )
    REFERENCES `CSPublicationCrawler`.`Paper` (`idPaper` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Reviewer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Reviewer` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Reviewer` (
  `idReviewer` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `reviewerName` VARCHAR(1000) NULL ,
  `image` VARCHAR(1000) NULL DEFAULT NULL ,
  `emailAddress` VARCHAR(1000) NULL DEFAULT NULL ,
  `website` VARCHAR(1000) NULL DEFAULT NULL ,
  `organization` VARCHAR(1000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idReviewer`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Paper_Reviewer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Paper_Reviewer` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Paper_Reviewer` (
  `idPaper` INT(10) UNSIGNED NOT NULL ,
  `idReviewer` INT(10) UNSIGNED NOT NULL ,
  `rating` INT(1) NULL ,
  `content` VARCHAR(20000) NULL ,
  PRIMARY KEY (`idPaper`, `idReviewer`) ,
  INDEX `fk_Paper_has_Reviewer_Reviewer1` (`idReviewer` ASC) ,
  INDEX `fk_Paper_has_Reviewer_Paper1` (`idPaper` ASC) ,
  CONSTRAINT `fk_Paper_has_Reviewer_Paper1`
    FOREIGN KEY (`idPaper` )
    REFERENCES `CSPublicationCrawler`.`Paper` (`idPaper` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paper_has_Reviewer_Reviewer1`
    FOREIGN KEY (`idReviewer` )
    REFERENCES `CSPublicationCrawler`.`Reviewer` (`idReviewer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Author_Subdomain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Author_Subdomain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Author_Subdomain` (
  `idAuthor` INT(10) NOT NULL ,
  `idSubdomain` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  `coAuthorCount` INT(10) NULL ,
  PRIMARY KEY (`idAuthor`, `idSubdomain`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Author` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Author` (
  `idAuthor` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  `coAuthorCount` INT(10) NULL ,
  PRIMARY KEY (`idAuthor`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Paper` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Paper` (
  `idPaper` INT(10) NOT NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idPaper`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Paper_Subdomain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Paper_Subdomain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Paper_Subdomain` (
  `idPaper` INT(10) NOT NULL ,
  `idSubdomain` INT(10) NOT NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idPaper`, `idSubdomain`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Paper_Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Paper_Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Paper_Keyword` (
  `idPaper` INT(10) NOT NULL ,
  `idKeyword` INT(10) NOT NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idPaper`, `idKeyword`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Author_Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Author_Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Author_Keyword` (
  `idAuthor` INT(10) NOT NULL ,
  `idKeyword` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  `coAuthorCount` INT(10) NULL ,
  PRIMARY KEY (`idAuthor`, `idKeyword`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Org_Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Org_Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Org_Keyword` (
  `idOrg` INT(10) NOT NULL ,
  `idKeyword` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  `authorCount` INT(10) NULL ,
  PRIMARY KEY (`idOrg`, `idKeyword`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Org_Subdomain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Org_Subdomain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Org_Subdomain` (
  `idOrg` INT(10) NOT NULL ,
  `idSubdomain` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  `authorCount` INT(10) NULL ,
  PRIMARY KEY (`idOrg`, `idSubdomain`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Org`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Org` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Org` (
  `idOrg` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  `authorCount` INT(10) NULL ,
  PRIMARY KEY (`idOrg`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Conference_Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Conference_Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Conference_Keyword` (
  `idConference` INT(10) NOT NULL ,
  `idKeyword` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idConference`, `idKeyword`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Conference_Subdomain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Conference_Subdomain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Conference_Subdomain` (
  `idConference` INT(10) NOT NULL ,
  `idSubdomain` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idConference`, `idSubdomain`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Conference`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Conference` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Conference` (
  `idConference` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idConference`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Journal_Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Journal_Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Journal_Keyword` (
  `idJournal` INT(10) NOT NULL ,
  `idKeyword` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idJournal`, `idKeyword`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Journal_Subdomain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Journal_Subdomain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Journal_Subdomain` (
  `idJournal` INT(10) NOT NULL ,
  `idSubdomain` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idJournal`, `idSubdomain`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Journal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Journal` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Journal` (
  `idJournal` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idJournal`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Magazine_Keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Magazine_Keyword` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Magazine_Keyword` (
  `idMagazine` INT(10) NOT NULL ,
  `idKeyword` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idMagazine`, `idKeyword`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Magazine_Subdomain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Magazine_Subdomain` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Magazine_Subdomain` (
  `idMagazine` INT(10) NOT NULL ,
  `idSubdomain` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idMagazine`, `idSubdomain`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`_Rank_Magazine`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`_Rank_Magazine` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`_Rank_Magazine` (
  `idMagazine` INT(10) NOT NULL ,
  `publicationCount` INT(10) NULL ,
  `citationCount` INT(10) NULL ,
  `rank` INT(10) NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idMagazine`) ,
  INDEX `index2` (`rank` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CSPublicationCrawler`.`Subdomain_Paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CSPublicationCrawler`.`Subdomain_Paper` ;

CREATE  TABLE IF NOT EXISTS `CSPublicationCrawler`.`Subdomain_Paper` (
  `idPaper` INT(10) UNSIGNED NOT NULL ,
  `idSubdomain` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idPaper`, `idSubdomain`) ,
  INDEX `fk_Subdomain_has_Paper_Paper1` (`idPaper` ASC) ,
  INDEX `fk_Subdomain_has_Paper_Subdomain1` (`idSubdomain` ASC) ,
  CONSTRAINT `fk_Subdomain_has_Paper_Subdomain1`
    FOREIGN KEY (`idSubdomain` )
    REFERENCES `CSPublicationCrawler`.`Subdomain` (`idSubdomain` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subdomain_has_Paper_Paper1`
    FOREIGN KEY (`idPaper` )
    REFERENCES `CSPublicationCrawler`.`Paper` (`idPaper` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;