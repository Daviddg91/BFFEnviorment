-- create databases
CREATE DATABASE IF NOT EXISTS `ifapadb`;
CREATE DATABASE IF NOT EXISTS `keycloakdb`;

-- create root user and grant rights
CREATE USER 'user'@'%' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;

USE ifapadb;


