CREATE DATABASE Parking_System;
USE Parking_System;
CREATE TABLE Employee(
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40),
    gender VARCHAR(1),
    email VARCHAR(40) UNIQUE,
    password VARCHAR(20),
    contact_number VARCHAR(10),
    organization VARCHAR(40)
);
 
CREATE TABLE Vehicle(
    vehicle_id INT AUTO_INCREMENT,
    employee_Id int(10),
    vehicle_name VARCHAR(40),
    type VARCHAR(20),
    vehicle_number VARCHAR(30),
    identification VARCHAR(100),
    FOREIGN KEY (employee_Id) REFERENCES Employee(employee_id),
    PRIMARY KEY(vehicle_id, employee_id)
);

CREATE TABLE Pass(
    pass_id INT AUTO_INCREMENT,
    employee_id INT,
    price varchar(30),
    FOREIGN KEY (employee_Id) REFERENCES Employee(employee_id),
    PRIMARY KEY(pass_id, employee_id)
);

SELECT * From Employee;