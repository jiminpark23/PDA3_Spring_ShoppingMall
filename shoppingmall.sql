SELECT * FROM member;

CREATE DATABASE shoppingmall;
use shoppingmall

CREATE TABLE member (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20) NOT NULL,
    pw VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    contact VARCHAR(20) NOT NULL
);