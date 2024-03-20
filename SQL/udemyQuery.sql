-- USE tea_shop;
SELECT database();

CREATE TABLE dogs(
	name VARCHAR(50),
    breed VARCHAR(50),
    age INT
);

CREATE TABLE cats(
	name VARCHAR(50),
    age int
);

show TABLES;
SHOW COLUMNS FROM dogs;
DESCRIBE cats;
DESC dogs;

DROP TABLE cats;

CREATE TABLE pastries(
	name varchar(50),
    quantity INT
);
SHOW TABLES;
DESCRIBE pastries;
DROP TABLE pastries;

INSERT INTO cats(name,age) VALUES("tino",2);

DESC cats;
SELECT * FROM cats;

INSERT INTO cats(age,name) VALUES(3,"luca");

insert into cats(name,age) 
values("rocco",5),("mateo",6),("luna",4);

create table people(
	first_name varchar(20),
    last_name varchar(20),
    age int
);

INSERT INTO people(first_name,last_name,age) 
VALUES ('tina','belcher',13);

INSERT INTO people(first_name,last_name,age) 
VALUES ('bob','belcher',42);

INSERT into people 
VALUES('linda','belcher',45),('phillip','frond',38),("calvin","fischoeder",70);

SELECT * from people;

CREATE TABLE cats2(
		name VARCHAR(50) NOT NULL,
        age INT not null
);

DESC cats2;

create table cats3(
	name varchar(50) DEFAULT 'UNNAMED',
    age int DEFAULT 99
);

create table cats4(
	name varchar(50) not null DEFAULT 'unnamed',
    age int not null DEFAULT 99
);

INSERT INTO cats3 VALUES();

INSERT INTO cats4 VALUES();

DESC cats3;
DESC cats4;
select * from cats3;

select * from cats4;

create table unique_cats(
	id int not null primary key,
    name varchar(100),
    age int
);

DESC unique_cats;

create table unique_cats2(
	id int,
    name varchar(100) not null,
    age int not null,
    PRIMARY KEY (id)
);

DESC unique_cats2;

create table unique_cats3(
	id int AUTO_INCREMENT,
    name varchar(100),
    age int,
    PRIMARY KEY(id)
);
DESC unique_cats3;
insert into unique_cats3(name,age)VALUES('don',3);
insert into unique_cats3(name,age)VALUES('dons',5);
select * from unique_cats3;

create table employees(
	id int AUTO_INCREMENT PRIMARY KEY,
    last_name varchar(50) not NULL,
    first_name varchar(50) not null,
    middle_name varchar(50),
    age int not null,
    current_status varchar(50) not null DEFAULT 'employed'
);
desc employees;

INSERT INTO employees (first_name,last_name,age) 
VALUES('thomas','chickenman',87);

SELECT * FROM employees;

drop TABLE employees;
drop TABLE cats;
drop TABLE cats2;
drop TABLE cats3;
drop TABLE cats4;

CREATE TABLE cats(
	cat_id INT AUTO_INCREMENT,
	name VARCHAR(100),
    breed VARCHAR(100),
    age INT,
    PRIMARY KEY (cat_id)
);
DESC cats;

INSERT INTO cats(name,breed,age)
VALUES('ringo','tabby',4),
('cindy','maine coon',10),
('dumbledore','maine coon',11),
('egg','persian',4),
('misty','tabby',13),
('george michael','ragdoll',9),
('jackson','sphynx',7);

SELECT * FROM cats;

SELECT name FROM cats;
SELECT age FROM cats;
SELECT name,age from cats;
SELECT * FROM cats WHERE age=4;
SELECT name FROM cats WHERE age=4;
SELECT * from cats where name='egg';
SELECT * from cats where name='Egg';
select cat_id from cats;
select name,breed from cats;
select name,age from cats where breed='tabby';
select cat_id,age from cats where cat_id=age;
select cat_id as id from cats;

update cats set breed='shorthair' where breed='tabby';
update employees set 
current_status='laid-off',last_name='who care';
SELECT*from employees;
update cats set age=14 where name='misty';

update cats set name='jack'where name='jackson';
update cats set breed='british shorthair' where name='ringo';
update cats set age=12 where breed='maine coon';

delete from cats where name ='egg';

delete from cats where age=4;
delete from cats where cat_id=age;
delete from cats;

--;

create database shirts_db;
use shirts_db;
create table shirts(
shirt_id int AUTO_INCREMENT PRIMARY key,
article varchar(100) not null,
color varchar(100) not null,
shirt_size varchar(100) not null,
last_worn int not null
);

desc shirts;
insert into shirts(article,color,shirt_size,last_worn) 
values
	('t-shirt', 'white', 'S', 10),
	('t-shirt', 'green', 'S', 200),
	('polo shirt', 'black', 'M', 10),
	('tank top', 'blue', 'S', 50),
	('t-shirt', 'pink', 'S', 0),
	('polo shirt', 'red', 'M', 5),
	('tank top', 'white', 'S', 200),
	('tank top', 'blue', 'M', 15);

insert into shirts(article,color,shirt_size,last_worn)  
values ('polo shirt','purple', 'M', 50);

select article, color from shirts;

SELECT article,color,shirt_size,last_worn from shirts where shirt_size='m';

update shirts 
set shirt_size='L' 
where article='polo shirt';

select * from shirts;

update shirts 
set last_worn=0 
where last_worn=15;

update shirts 
set shirt_size='xs',
	color='off white' 
where color ='white';

delete from shirts 
where last_worn='200';

DELETE FROM shirts 
WHERE article='tank top';
SELECT SUBSTRING('HelloWorld', 6, 5);
SELECT REPLACE('Hello World', "World", "Hello");
SELECT REVERSE('Hello');
SELECT CHAR_LENGTH('Hello');
SELECT UPPER('Hello');
SELECT LOWER('hello');

--
CREATE TABLE books 
	(
		book_id INT AUTO_INCREMENT,
		title VARCHAR(100),
		author_fname VARCHAR(100),
		author_lname VARCHAR(100),
		released_year INT,
		stock_quantity INT,
		pages INT,
		PRIMARY KEY(book_id)
	);
 
INSERT INTO books (title, author_fname, author_lname, released_year, stock_quantity, pages)
VALUES
('The Namesake', 'Jhumpa', 'Lahiri', 2003, 32, 291),
('Norse Mythology', 'Neil', 'Gaiman',2016, 43, 304),
('American Gods', 'Neil', 'Gaiman', 2001, 12, 465),
('Interpreter of Maladies', 'Jhumpa', 'Lahiri', 1996, 97, 198),
('A Hologram for the King: A Novel', 'Dave', 'Eggers', 2012, 154, 352),
('The Circle', 'Dave', 'Eggers', 2013, 26, 504),
('The Amazing Adventures of Kavalier & Clay', 'Michael', 'Chabon', 2000, 68, 634),
('Just Kids', 'Patti', 'Smith', 2010, 55, 304),
('A Heartbreaking Work of Staggering Genius', 'Dave', 'Eggers', 2001, 104, 437),
('Coraline', 'Neil', 'Gaiman', 2003, 100, 208),
('What We Talk About When We Talk About Love: Stories', 'Raymond', 'Carver', 1981, 23, 176),
("Where I'm Calling From: Selected Stories", 'Raymond', 'Carver', 1989, 12, 526),
('White Noise', 'Don', 'DeLillo', 1985, 49, 320),
('Cannery Row', 'John', 'Steinbeck', 1945, 95, 181),
('Oblivion: Stories', 'David', 'Foster Wallace', 2004, 172, 329),
('Consider the Lobster', 'David', 'Foster Wallace', 2005, 92, 343);

SELECT CONCAT('pi', 'ckle');
 
SELECT CONCAT(author_fname,' ', author_lname) 
AS author_name FROM books;
 
SELECT 
    CONCAT_WS('-', title, author_fname, author_lname)
FROM
    books;

SELECT SUBSTRING('Hello World', 1, 4);
 
SELECT SUBSTRING('Hello World', 7);
 
SELECT SUBSTRING('Hello World', - 3);
 
SELECT SUBSTRING(title, 1, 10) AS 'short title'
FROM books;
 
SELECT 
    SUBSTR(title, 1, 10) AS 'short title'
FROM
    books;

SELECT CONCAT
    (
        SUBSTRING(title, 1, 10),
        '...'
    ) AS 'short title'
FROM books;

SELECT REPLACE('Hello World', 'Hell', '%$#@');
 
SELECT REPLACE('Hello World', 'l', '7');
 
SELECT REPLACE('Hello World', 'o', '0');
 
SELECT REPLACE('HellO World', 'o', '*');
 
SELECT 
    REPLACE('cheese bread coffee milk',
        ' ',
        ' and ');
 
SELECT 
    REPLACE(title, 'e ', '3')
FROM
    books;
 
SELECT 
    REPLACE(title, ' ', '-')
FROM
    books;


SELECT REVERSE('Hello World');
 
SELECT REVERSE('meow meow');
 
SELECT REVERSE(author_fname) FROM books;
 
SELECT CONCAT('woof', REVERSE('woof'));
 
SELECT CONCAT(author_fname, REVERSE(author_fname)) 
FROM books;

SELECT CHAR_LENGTH('Hello World');
 
SELECT CHAR_LENGTH(title) 
as length, title
FROM books;
 
SELECT author_lname, CHAR_LENGTH(author_lname)
 AS 'length'
 FROM books;
 
SELECT 
CONCAT(author_lname, ' is ', CHAR_LENGTH(author_lname), ' characters long') 
FROM books;

SELECT UPPER('Hello World');
 
SELECT LOWER('Hello World');
 
SELECT 
    UPPER(title)
FROM
    books;
 
SELECT 
    CONCAT('MY FAVORITE BOOK IS ', UPPER(title))
FROM
    books;
 
SELECT 
    CONCAT('MY FAVORITE BOOK IS ', LOWER(title))
FROM
    books;
    
    --
SELECT REVERSE(UPPER('Why does my cat look at me with such hatred?'));
 
SELECT REPLACE(title, ' ', '->') AS title FROM books;
 
SELECT 
    author_lname AS forwards, REVERSE(author_lname) AS backwards
FROM
    books;
    
 
SELECT UPPER(CONCAT(author_fname, ' ', author_lname)) AS 'full name in caps' FROM books;
 
 
SELECT CONCAT(title, ' was released in ', released_year) AS blurb FROM books;
 
SELECT title, CHAR_LENGTH(title) AS character_count FROM books;
 
SELECT 
    CONCAT(SUBSTR(title, 1, 10), '...') AS short_title,
    CONCAT(author_lname, ',', author_fname) AS author,
    CONCAT(stock_quantity, ' in stock') AS quantity
FROM
    books;
    
    INSERT INTO books
    (title, author_fname, author_lname, released_year, stock_quantity, pages)
    VALUES ('10% Happier', 'Dan', 'Harris', 2014, 29, 256), 
           ('fake_book', 'Freida', 'Harris', 2001, 287, 428),
           ('Lincoln In The Bardo', 'George', 'Saunders', 2017, 1000, 367);
           
SELECT 
    author_lname
FROM
    books;
 
SELECT DISTINCT
    author_lname
FROM
    books;
 
SELECT 
    author_fname, author_lname
FROM
    books;
 
SELECT DISTINCT
    CONCAT(author_fname, ' ', author_lname)
FROM
    books;
 
SELECT DISTINCT
    author_fname, author_lname
FROM
    books;
    
SELECT 
    *
FROM
    books
ORDER BY author_lname;
 
SELECT 
    *
FROM
    books
ORDER BY author_lname DESC;
 
SELECT 
    *
FROM
    books
ORDER BY released_year;

SELECT book_id, author_fname, author_lname, pages
FROM books ORDER BY 2 desc;
 
SELECT book_id, author_fname, author_lname, pages
FROM books ORDER BY author_lname, author_fname;

SELECT title FROM books LIMIT 3;
 
SELECT title FROM books LIMIT 1;
 
SELECT title FROM books LIMIT 10;
 
SELECT * FROM books LIMIT 1;
 
SELECT title, released_year FROM books 
ORDER BY released_year DESC LIMIT 5;
 
SELECT title, released_year FROM books 
ORDER BY released_year DESC LIMIT 1;
 
SELECT title, released_year FROM books 
ORDER BY released_year DESC LIMIT 14;
 
SELECT title, released_year FROM books 
ORDER BY released_year DESC LIMIT 0,5;
 
SELECT title, released_year FROM books 
ORDER BY released_year DESC LIMIT 0,3;
 
SELECT title, released_year FROM books 
ORDER BY released_year DESC LIMIT 1,3;
 
SELECT title, released_year FROM books 
ORDER BY released_year DESC LIMIT 10,1;
 
SELECT * FROM tbl LIMIT 95,18446744073709551615;
 
SELECT title FROM books LIMIT 5;
 
SELECT title FROM books LIMIT 5, 123219476457;
 
SELECT title FROM books LIMIT 5, 50;

SELECT title, author_fname, author_lname, pages 
FROM books
WHERE author_fname LIKE '%da%';
 
SELECT title, author_fname, author_lname, pages 
FROM books
WHERE title LIKE '%:%';
 
SELECT * FROM books
WHERE author_fname LIKE '____';
 
SELECT * FROM books
WHERE author_fname LIKE '_a_';

-- To select books with '%' in their title:
SELECT * FROM books
WHERE title LIKE '%\%%';
 
-- To select books with an underscore '_' in title:
SELECT * FROM books
WHERE title LIKE '%\_%';

select title from books where title like '%stories%';

SELECT 
    title, pages
FROM
    books
ORDER BY pages DESC
LIMIT 1;

SELECT 
    CONCAT_WS(' - ', title, released_year) AS summary
FROM
    books
ORDER BY released_year DESC
LIMIT 3;

SELECT 
    title, author_lname
FROM
    books
WHERE
    author_lname LIKE '% %';
    
SELECT 
    title, released_year, stock_quantity
FROM
    books
ORDER BY stock_quantity,title ASC
LIMIT 3;

SELECT 
    title, author_lname
FROM
    books
ORDER BY author_lname , title DESC;

SELECT 
    upper(CONCAT('my favorite author is ',
            author_fname,
            ' ',
            author_lname,
            ' !')) AS yell
FROM
    books
ORDER BY author_lname ASC;