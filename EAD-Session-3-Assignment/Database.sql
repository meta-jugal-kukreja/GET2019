CREATE DATABASE Students;

USE Students;

CREATE TABLE student_information(
    student_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email_id VARCHAR(30) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    father_name VARCHAR(40) NOT NULL,
    class INT NOT NULL,
    age INT NOT NULL);
    
SELECT * FROM student_information;

SELECT student_id, email_id, first_name, last_name, father_name, class, age FROM student_information  WHERE first_name = 'Jugal' AND  last_name = 'Kukreja'
