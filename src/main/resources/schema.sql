CREATE TABLE Tuote (
tuoteid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
date DATE,
category_id INT NOT NULL);

INSERT INTO Tuote (name, date, category_id) 
VALUES ('Maito', '2019-03-28',3),
('Oivariini', '2019-09-28',4), 
('Sikanautaa', '2019-05-28',2),
('Ketsuppi', '2019-09-12', 6),
('PepsiMax', '2025-09-12', 7),
('Roiskeläppä', '2020-05-28',5),
('Omenahillo', '2019-10-30', 8);

CREATE TABLE Category (
category_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
categoryName VARCHAR(50) NOT NULL);

INSERT INTO Category (categoryName) 
VALUES ('HeVi'),
('Liha/kala'), 
('Maitotuotteet'), 
('Rasvat'),
('Einekset'),
('Mausteet'),
('Juomat'),
('Muut');

CREATE TABLE User (
uid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
role VARCHAR(20) NOT NULL,
username VARCHAR(50) NOT NULL,
passwordHash VARCHAR(50) NOT NULL);

INSERT INTO User (role, username, passwordHash) 
VALUES ('USER', 'user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6'),
('ADMIN', 'admin', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C');