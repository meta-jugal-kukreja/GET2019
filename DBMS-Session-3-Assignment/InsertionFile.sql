INSERT INTO user VALUES
	('abc98@gmail.com', 'abc', '8947804883', '1997-10-25', 'A'),
	('rs98@gmail.com', 'rs', '8947804889',  '1998-10-25', 'S'),
	('def@gmail.com', 'def', '7737596610', '1997-03-10', 'S'),
	('xyz@gmail.com', 'xyz', '1234567893',  '1995-03-31', 'S'),
	('pqr@gmail.com', 'pqr', '7877235269', '1997-12-25', 'S');
    
INSERT INTO Category(category_name, parent_category) VALUES
    ('Electronics', NULL),
    ('Accessories', NULL),
    ('Fashion Styling', NULL),
    ('Mobile', 1),
    ('Laptop', 1),
    ('USB', 1),
    ('Redmi', 4),
    ('Xiaomi', 4),
    ('Dell', 5),
    ('Sony', 5),
    ('Kingston', 6),
    ('HP', 6),
    ('Watch', 2),
    ('Fastrack', 13),
    ('Timex', 13),
    ('Shirt', 3),
    ('Trouser', 3),
    ('Suit', 3),
    ('Van Heusen', 16),
    ('Van Heusen', 17),
    ('Peter England', 18);
    
INSERT INTO Products(product_name, product_price, category_id, issue_date) VALUES
    ('Redmi 3s Prime', 9000.00, 7, '2016/07/01'),
    ('Redmi Note 4', 12499.99, 7, '2017/08/01'),
    ('Dell Inspiron 4Ti6xy', 40000.00, 9, '2018/07/01'),
    ('Sony Vostro Glide', 90399.99, 10, '2017/01/01'),
    ('Dell Inspiron 5Ti3fa', 50000.00, 11, '2017/09/23'),
    ('Kingston 16GB', 900.00, 11, '2016/12/12'),
    ('HP 64Gb', 2000.00, 12, '2018/08/01'),
    ('Fastrack Digital Watch', 2000.00, 14, '2016/12/01'),
    ('Timex Analog Watch', 5000.00, 15, '2018/01/01'),
    ('Van Heusen Shirt', 1500.00, 19, '2017/11/11'),
    ('Van Heusen Trouser', 2000.00, 20, '2016/07/01'),
    ('Peter England Suit', 10000.00, 21, '2014/02/12');
    
INSERT INTO Orders(order_status, order_amount, number_of_products, order_date, email_id, product_id) VALUES
    ('Shipped', 200.00, 2, '2019-08-13', 'pqr@gmail.com', 1),
    ('Not Shipped', 300.00, 1, '2019-06-13', 'rs98@gmail.com', 2),
    ('Cancelled', 400.00, 3, '2018-08-15', 'def@gmail.com', 3),
    ('Shipped', 500.00, 9, '2015-12-30', 'pqr@gmail.com', 4), 
    ('Not Shipped', 600.00, 6, '2019-07-13', 'xyz@gmail.com', 5);
    
INSERT INTO images VALUES
    (1, 'Redmi3sPrime.jpg'),
    (1, 'Redmi3sPrime1.jpg'),
    (1, 'Redmi3sPrime2.jpg'),
    (1, 'Redmi3sPrime3.jpg'),
    (1, 'Redmi3sPrime4.jpg'),
    (3, 'DellInspiron5Ti3fa.jpg'),
    (4, 'SonyVostroGlide.jpg'),
    (5, 'DellInspiron5Ti3fa.jpg'),
    (6, 'Kingston16GB.jpg'),
    (7, 'HP64Gb.jpg'),
    (7, 'HP64Gb1.jpg'),
    (8, 'FastrackDigitalWatch4hy7e.jpg'),
    (8, 'FastrackDigitalWatch4hy7e1.jpg'),
    (8, 'FastrackDigitalWatch4hy7e2.jpg'),
    (10, 'VanHeusenShirt.jpg'),
    (10, 'VanHeusenShirt1.jpg'),
    (12, 'PeterEnglandSuit.jpg');
    
INSERT INTO Shipping_Address(area, city, state, country, email_id, pincode) VALUES 
    ('Kumbha Marg', 'Jaipur', 'Rajasthan', 'India', 'abc98@gmail.com', '302033'),
    ('MBM Hostel', 'Jodhpur', 'Rajasthan', 'India', 'rs98@gmail.com','342204'),
    ('Vaishali Nagar', 'Jaipur', 'Rajasthan', 'India', 'def@gmail.com','302033'),
    ('Haldi Ghati Marg', 'Jaipur', 'Rajasthan', 'India', 'def@gmail.com','302033'),
    ('Shakti Nagar', 'Udaipur', 'Rajasthan', 'India', 'abc98@gmail.com','313001'),
    ('Ram Marg', 'Jaisalmair', 'Rajasthan', 'India', 'pqr@gmail.com','345001'),
    ('Malviya Nagar', 'Jaipur', 'Rajasthan', 'India', 'xyz@gmail.com','302033'),
    ('Bapu Nagar', 'Jaipur', 'Rajasthan', 'India', 'abc98@gmail.com','302033');

INSERT INTO Shipment (address_id) Values
    (1),
    (2),
    (3),
    (4),
    (5),
    (6),
    (7),
    (8),
    (9);

INSERT INTO Stock (product_id, amount_of_product_in_stock) VALUES 
    (1,10),
    (2,10),
    (3,5),
    (4,6),
    (5,7),
    (6,100),
    (7,100),
    (8,50),
    (9,20),
    (10,50),
    (11,50),
    (12,20);
    