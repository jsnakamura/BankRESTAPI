CREATE DATABASE IF NOT EXISTS bankdb;
USE bankdb;

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
	id int NOT NULL AUTO_INCREMENT,
    accountName varchar(45) NOT NULL,
    accountNumber int NOT NULL UNIQUE,
    balance double NOT NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
