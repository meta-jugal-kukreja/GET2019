SHOW TABLES;

DROP TABLE Stock;
DROP TABLE Images;
DROP TABLE Products;

CREATE TABLE Products(product_name VARCHAR(20), 
    product_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    product_price INT, category_id INT, 
    FOREIGN KEY(category_id) REFERENCES Category(category_id));
    
CREATE TABLE Stock(stock_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    amount_of_product_in_stock INT NOT NULL,
    FOREIGN KEY(product_id) REFERENCES Products(product_id));
    
CREATE TABLE images(product_id INT,
    image_url VARCHAR(50), 
    PRIMARY KEY(product_id, image_url),
    FOREIGN KEY (product_id) REFERENCES products(product_id));