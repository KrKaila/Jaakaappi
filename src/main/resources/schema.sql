CREATE TABLE Jaakaappi (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
date DATE,
category_id BIGINT NOT NULL);


INSERT INTO Jaakaappi (name, date, category_id) 
VALUES ('Maito', '2019-03-28',1),
('Juusto', '2019-05-28',1), 
('Ketsuppi', '2019-09-12', 2);