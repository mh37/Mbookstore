 CREATE TABLE IF NOT EXISTS book (
    book_id int(5) NOT NULL AUTO_INCREMENT,
    title varchar(100) DEFAULT NULL,
    author varchar(100) DEFAULT NULL,
    year int(5) DEFAULT NULL,
    isbn varchar(22) DEFAULT NULL,
    price float DEFAULT NULL,
    inventory int(6) DEFAULT NULL,
    PRIMARY KEY(book_id)
  );

 CREATE TABLE IF NOT EXISTS category (
    category_id int(5) NOT NULL AUTO_INCREMENT,
    name varchar(100) DEFAULT NULL,
    PRIMARY KEY(category_id)
  );