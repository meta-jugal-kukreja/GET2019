CREATE DATABASE Inventory_System;
USE Inventory_System;

CREATE TABLE Inventory ( id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(20) NOT NULL UNIQUE,
            quantity INT NOT NULL);
            
SELECT * FROM Inventory;

INSERT INTO Inventory (name, quantity) VALUES
    ('apple',10),
    ('grapes',12);
    
truncate table inventory;
    
DELETE FROM Inventory WHERE name='null';