CREATE DATABASE StoreFront;

USE StoreFront;

CREATE TABLE User(email_id VARCHAR(30) PRIMARY KEY,
    user_name VARCHAR(30) NOT NULL,
    phone_no VARCHAR(10) NOT NULL,
    date_of_birth DATE NOT NULL,
    type_of_user varchar(1) NOT NULL CHECK(type_of_user IN ("S", "A")));
    
CREATE TABLE Category(category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
     category_name VARCHAR(20) NOT NULL, 
     parent_category INT,
     FOREIGN KEY(parent_category) REFERENCES Category(category_id));
    
CREATE TABLE Products(product_name VARCHAR(30), 
    product_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    product_price FLOAT, category_id INT, 
    issue_date Date,
    FOREIGN KEY(category_id) REFERENCES Category(category_id));
    
CREATE TABLE images(product_id INT,
    image_url VARCHAR(50), 
    PRIMARY KEY(product_id, image_url),
    FOREIGN KEY (product_id) REFERENCES products(product_id));
    
CREATE TABLE ORDERS (order_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    order_status VARCHAR(20), 
    order_amount FLOAT, 
    product_id INT,
    number_of_products INT, 
    order_date DATE,
    email_id VARCHAR(30),
    FOREIGN KEY(email_id) REFERENCES User(email_id),
    FOREIGN KEY(product_id) REFERENCES Products(product_id));

CREATE TABLE Shipping_Address (address_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    area VARCHAR(30),
    city VARCHAR(30),
    state VARCHAR(30),
    country VARCHAR(30),
    email_id VARCHAR(30),
    FOREIGN KEY(email_id) REFERENCES User(email_id));
    
CREATE TABLE Shipment(shipping_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    address_id INT,
    FOREIGN KEY(address_id) REFERENCES Shipping_Address(address_id));

CREATE TABLE Stock(stock_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    amount_of_product_in_stock INT NOT NULL,
    FOREIGN KEY(product_id) REFERENCES Products(product_id));
    