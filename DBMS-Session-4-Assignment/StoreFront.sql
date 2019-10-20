DROP SCHEMA StoreFront;
CREATE DATABASE StoreFront;

USE StoreFront;

CREATE TABLE Users(user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email_id VARCHAR(30) NOT NULL,
    user_name VARCHAR(30) NOT NULL,
    phone_no VARCHAR(10) NOT NULL,
    date_of_birth DATE NOT NULL,
    type_of_user varchar(1) NOT NULL CHECK(type_of_user IN ("S", "A")));
    
CREATE TABLE Category(category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
     category_name VARCHAR(20) NOT NULL, 
     parent_category INT,
     FOREIGN KEY(parent_category) REFERENCES Category(category_id));


CREATE TABLE Products(product_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    product_name VARCHAR(30) NOT NULL, 
    product_price FLOAT NOT NULL, 
    category_id INT NOT NULL, 
    issue_date Date NOT NULL,
    FOREIGN KEY(category_id) REFERENCES Category(category_id));
    
    SET FOREIGN_KEY_CHECKS = 0;
    
CREATE TABLE Images(product_id INT NOT NULL,
    image_url VARCHAR(50) NOT NULL, 
    PRIMARY KEY(product_id, image_url),
    FOREIGN KEY (product_id) REFERENCES Products(product_id));
    
    SET FOREIGN_KEY_CHECKS = 0;
    
CREATE TABLE Orders(order_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    order_status VARCHAR(20) NOT NULL CHECK(order_status IN ('Shipped' , 'Not Shipped', 'Cancelled')), 
    order_amount FLOAT NOT NULL, 
    product_id INT NOT NULL,
    order_date DATE NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES User(user_id),
    FOREIGN KEY(product_id) REFERENCES Products(product_id));

SET FOREIGN_KEY_CHECKS = 0;
CREATE TABLE ShippingAddress (address_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    area VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    country VARCHAR(30) NOT NULL,
    user_id INT NOT NULL,
    pincode VARCHAR(10) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES User(user_id));
    
CREATE TABLE Stock(stock_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    amount_of_product_in_stock INT NOT NULL NOT NULL,
    FOREIGN KEY(product_id) REFERENCES Products(product_id));
    
CREATE TABLE Cart(cart_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	quantity INT NOT NULL,
	amount INT NOT NULL,
	order_status VARCHAR(20) NOT NULL CHECK(order_status IN ('Shipped' , 'Not Shipped', 'Cancelled')),
	FOREIGN KEY(product_id) REFERENCES Products(product_id),
	FOREIGN KEY(order_id) REFERENCES Orders(order_id)
);
    