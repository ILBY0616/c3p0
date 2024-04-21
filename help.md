CREATE DATABASE c3p0;

USE c3p0;

CREATE TABLE user
(
uid INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(255) NOT NULL,
status VARCHAR(255) NOT NULL DEFAULT '正常'
) DEFAULT CHARSET = UTF8;

insert into user (name, password, role)
values ("张三", 123456, "管理员"),
("李四", 123456, "商家"),
("王五", 123456, "消费者");