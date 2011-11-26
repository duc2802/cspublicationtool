USE cspublicationcrawler
go
DROP PROCEDURE insertAuthor;
DELIMITER $$
CREATE PROCEDURE insertAuthor(nameAuthor NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT authorName FROM author WHERE authorName = nameAuthor;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO author(authorName) VALUES (nameAuthor);	
	END IF;
	CLOSE a;	
END$$

DROP PROCEDURE insertJournal;
DELIMITER $$
CREATE PROCEDURE insertJournal(nameJournal NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT journalName FROM journal WHERE journalName = nameJournal;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO journal(journalName) VALUES (nameJournal);	
	END IF;
	CLOSE a;	
END$$

DROP PROCEDURE insertPublisher;
DELIMITER $$
CREATE PROCEDURE insertPublisher(publisherName NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT namePublisher FROM publisher WHERE namePublisher = publisherName;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO publisher(namePublisher) VALUES (publisherName);	
	END IF;
	CLOSE a;	
END$$

DROP PROCEDURE insertConference;
DELIMITER $$
CREATE PROCEDURE insertConference(conferName NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT conferenceName FROM conference WHERE conferenceName = conferName;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO conference(conferenceName) VALUES (conferName);	
	END IF;
	CLOSE a;	
END$$

DROP PROCEDURE insertMagazine;
DELIMITER $$
CREATE PROCEDURE insertMagazine(magaName NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT magazineName FROM magazine WHERE magazineName = magaName;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO magazine(magazineName) VALUES (magaName);	
	END IF;
	CLOSE a;	
END$$

DROP PROCEDURE insertPaperType;
DELIMITER $$
CREATE PROCEDURE insertPaperType(typePaper NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT nameType FROM paper_type WHERE nameType = typePaper;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO paper_type(nameType) VALUES (typePaper);	
	END IF;
	CLOSE a;	
END$$

DROP PROCEDURE insertPaper;
DELIMITER $$
CREATE PROCEDURE insertPaper(doiInput VARCHAR(10), isbnInput VARCHAR(10), urlInput VARCHAR(50), titleInput VARCHAR(100), abstractInput VARCHAR(1000), volumeInput VARCHAR(10), pagesInput VARCHAR(10), 
yearInput INT, viewPublicationInput VARCHAR(10), bibTexInput VARCHAR(100), endNoteInput VARCHAR(100), nameJournalInput VARCHAR(50),  namePublisherInput VARCHAR(50), namePapertype VARCHAR(50), 
nameMagazine VARCHAR(50), nameConference VARCHAR(50), dblpKeyInput VARCHAR(50), versionInput VARCHAR(50), paperFileInput VARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE jo NVARCHAR(50);
	DECLARE pu NVARCHAR(50);
	DECLARE co NVARCHAR(50);
	DECLARE ma NVARCHAR(50);
	DECLARE pa NVARCHAR(50);
	DECLARE idJournalCursor CURSOR FOR SELECT idJournal FROM journal WHERE journalName = nameJournalInput;
	DECLARE idPublisherCursor CURSOR FOR SELECT idPublisher FROM publisher WHERE namePublisher = namePublisherInput;
	DECLARE idConferenceCursor CURSOR FOR SELECT idConference FROM conference WHERE conferenceName = nameConference;
	DECLARE idMagazineCursor CURSOR FOR SELECT idMagazine FROM magazine WHERE magazineName = nameMagazine;
	DECLARE idPaperTypeCursor CURSOR FOR SELECT idPaperType FROM paper_type WHERE nameType = namePapertype;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN idJournalCursor;
	FETCH NEXT FROM idJournalCursor INTO jo;
	CLOSE idJournalCursor;	
	OPEN idPublisherCursor;
	FETCH NEXT FROM idPublisherCursor INTO pu;
	CLOSE idPublisherCursor;	
	OPEN idConferenceCursor;
	FETCH NEXT FROM idConferenceCursor INTO co;
	CLOSE idConferenceCursor;	
	OPEN idMagazineCursor;
	FETCH NEXT FROM idMagazineCursor INTO ma;
	CLOSE idMagazineCursor;	
	OPEN idPaperTypeCursor;
	FETCH NEXT FROM idPaperTypeCursor INTO pa;
	CLOSE idPaperTypeCursor;	
	INSERT INTO paper(doi, isbn, url, title, abstract, volume, pages, paper.year, viewPublication, bibTex, endNote, idJournal, idConference, idMagazine, idPublisher, idPaperType, dblpKey, paper.version, paperFile) 
	VALUES (doiInput, isbnInput , urlInput, titleInput, abstractInput, volumeInput, pagesInput, yearInput, viewPublicationInput, bibTexInput, endNoteInput, jo,  co, ma, pu, pa, dblpKeyInput, versionInput, paperFileInput);
	
END$$

DROP PROCEDURE insertPaperAuthor;
DELIMITER $$
CREATE PROCEDURE insertPaperAuthor(namePaper NVARCHAR(100), nameAuthor NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;
	DECLARE a1 INT;
	DECLARE a2 INT;
	DECLARE a CURSOR FOR SELECT idAuthor FROM author WHERE authorName = nameAuthor;
	DECLARE b CURSOR FOR SELECT idPaper FROM paper WHERE title = namePaper;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;
	OPEN b;
	FETCH NEXT FROM b INTO a2;
	INSERT INTO author_paper(idAuthor, idPaper) VALUES (a1, a2);		
	CLOSE a;
	CLOSE b;	
END$$

DROP PROCEDURE insertPaperAuthor;
CALL insertPaperAuthor('fkjgka','Geoffrey L. Burn');

SELECT idPaper FROM paper WHERE title = 'fkjgka';
SELECT idAuthor FROM author WHERE authorName = 'Geoffrey L. Burn';

SELECT * FROM author_paper
SELECT * FROM author
SELECT conferenceName FROM conference

CALL insertAuthor('D. I. Bevan1');
CALL insertAuthor('Geoffrey L. Burn');
CALL insertAuthor('R. J. Karia');
CALL insertAuthor('J. D. Robson');

CALL insertPaper('122', '3215', 'ldkfj', 'fkjgka', 'ldkfmlkd', 'ld,mflk', '18', 2009, 'lkdfm', 'lkdf', 'ldkf', 'fdsf', 'dafsds', 'dfasdf', 'fdsaf', 'dfkljldkjf','dffasf', 'dfasfa', 'dflpdf');
CALL insertPaper('', 'isbn', 'url', 'title', '', 'volume', 'papge', 2009, '', '', '', 'journal', '', '', 'publisher', 'papertype','keydf', '', '');

SELECT * FROM paper
