USE cspublicationcrawler
go

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

DELIMITER $$
CREATE PROCEDURE insertJournal(nameJournal NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT journalName FROM journal WHERE journalName = nameJournal;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO journalName(journalName) VALUES (nameJournal);	
	END IF;
	CLOSE a;	
END$$


DELIMITER $$
CREATE PROCEDURE insertPublisher(publisherName NVARCHAR(50))
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT namePublisher FROM publisher WHERE namePublisher = publisherName;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;journal
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO publisher(namePublisher) VALUES (publisherName);	
	END IF;
	CLOSE a;	
END$$


DELIMITER $$
CREATE PROCEDURE insertPaper(isbn VARCHAR(10), url VARCHAR(100), )
BEGIN	
	DECLARE fetchable INT DEFAULT 0;	
	DECLARE a1 NVARCHAR(50);
	DECLARE a CURSOR FOR SELECT namePublisher FROM publisher WHERE namePublisher = publisherName;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;journal
	OPEN a;
	FETCH NEXT FROM a INTO a1;	
	IF fetchable THEN INSERT INTO publisher(namePublisher) VALUES (publisherName);	
	END IF;
	CLOSE a;	
END$$



