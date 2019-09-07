CREATE DATABASE Parking_System;
USE Parking_System;
CREATE TABLE Employee(
    name VARCHAR(40),
    gender VARCHAR(1),
    email VARCHAR(40) PRIMARY KEY,
    password VARCHAR(20),
    contact_number VARCHAR(10),
    organization VARCHAR(40)
);
 
CREATE TABLE Vehicle(
    email VARCHAR(40),
    vehicle_name VARCHAR(40),
    type VARCHAR(20),
    vehicle_number VARCHAR(30) PRIMARY KEY,
    identification VARCHAR(100),
    FOREIGN KEY (email) REFERENCES Employee(email)
);

CREATE TABLE Pass(
    pass_number INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(40),
    price varchar(30),
    FOREIGN KEY (email) REFERENCES Employee(email)
);

SELECT * From Employee;
SELECT * From Vehicle;
SELECT * from pass;
