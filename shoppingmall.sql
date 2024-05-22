SELECT * FROM member;

CREATE DATABASE shoppingmall;
use shoppingmall

CREATE TABLE member (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20) NOT NULL,
    pw VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL UNIQUE,
    contact VARCHAR(20) NOT NULL UNIQUE
);


CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT NOT NULL,
    name VARCHAR(30) NOT NULL,
    price INT NOT NULL,
    description VARCHAR(100) NOT NULL
);