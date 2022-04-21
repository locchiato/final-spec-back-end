CREATE USER 'superuser'@'%'IDENTIFIED BY 'superuser';
CREATE USER 'movies'@'%'IDENTIFIED BY 'movies';

CREATE DATABASE movies_database;

GRANT ALL ON movies_database.* TO 'superuser'@'%';