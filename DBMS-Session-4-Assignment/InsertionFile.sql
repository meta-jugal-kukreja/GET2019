INSERT INTO Users(email_id, user_name, phone_no, date_of_birth, type_of_user) VALUES
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
    ('USB', 2),
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
    
INSERT INTO Orders(order_status, order_amount, order_date, user_id, product_id) VALUES
    ('Shipped', 200.00, '2019-08-13', 5, 1),
    ('Not Shipped', 300.00,  '2019-06-13', 2, 2),
    ('Cancelled', 400.00,  '2018-08-15', 3, 3),
    ('Shipped', 500.00,  '2015-12-30', 5, 4), 
    ('Not Shipped', 6000.00,  '2019-07-13', 4, 5),
    ('Not Shipped', 60.00,  '2019-07-20', 4, 6),
    ('Not Shipped', 1800.00,  '2019-07-31', 4, 7),
    ('Shipped', 630.00,  '2019-07-20', 4, 6),
    ('Not Shipped', 850.00,  '2019-07-20', 4, 6),
    ('Shipped', 8000.00,  '2019-07-20', 4, 6);
    
INSERT INTO Cart(order_id, product_id, quantity, amount, order_status) VALUES
	(1, 1, 2, (SELECT product_price FROM Products WHERE product_id=1)*2, 'Shipped'),
    (1, 3, 3, (SELECT product_price FROM Products WHERE product_id=3)*3, 'Not Shipped'),
    (2, 5, 4, (SELECT product_price FROM Products WHERE product_id=5)*4, 'Cancelled'),
    (2, 2, 5, (SELECT product_price FROM Products WHERE product_id=2)*5, 'Shipped'),
    (3, 8, 6, (SELECT product_price FROM Products WHERE product_id=8)*6, 'Shipped'),
    (3, 9, 3, (SELECT product_price FROM Products WHERE product_id=9)*3, 'Not Shipped'),
    (4, 10, 2, (SELECT product_price FROM Products WHERE product_id=10)*2, 'Cancelled'),
    (4, 4, 4, (SELECT product_price FROM Products WHERE product_id=4)*4, 'Shipped'),
    (5, 5, 1, (SELECT product_price FROM Products WHERE product_id=5)*1, 'Not Shipped'),
    (5, 12, 2, (SELECT product_price FROM Products WHERE product_id=12)*2, 'Not Shipped'),
    (6, 4, 3, (SELECT product_price FROM Products WHERE product_id=4)*3, 'Shipped'),
    (6, 2, 4, (SELECT product_price FROM Products WHERE product_id=2)*4, 'Not Shipped'),
    (7, 1, 6, (SELECT product_price FROM Products WHERE product_id=1)*6, 'Shipped'),
    (8, 6, 2, (SELECT product_price FROM Products WHERE product_id=6)*2, 'Cancelled'),
    (9, 10, 5, (SELECT product_price FROM Products WHERE product_id=10)*5, 'Shipped'),
    (10, 12, 1, (SELECT product_price FROM Products WHERE product_id=12)*1, 'Not Shipped'),
    (7, 2, 6, (SELECT product_price FROM Products WHERE product_id=2)*6, 'Shipped'),
    (8, 7, 1, (SELECT product_price FROM Products WHERE product_id=7)*1, 'Cancelled'),
    (9, 8, 2, (SELECT product_price FROM Products WHERE product_id=8)*2, 'Not Shipped');
    
    
INSERT INTO Images VALUES
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
    
INSERT INTO ShippingAddress(area, city, state, country, user_id, pincode) VALUES 
    ('Kumbha Marg', 'Jaipur', 'Rajasthan', 'India', 1, '302033'),
    ('MBM Hostel', 'Jodhpur', 'Rajasthan', 'India', 2,'342204'),
    ('Vaishali Nagar', 'Jaipur', 'Rajasthan', 'India', 3,'302033'),
    ('Haldi Ghati Marg', 'Jaipur', 'Rajasthan', 'India', 3,'302033'),
    ('Shakti Nagar', 'Udaipur', 'Rajasthan', 'India', 2,'313001'),
    ('Ram Marg', 'Jaisalmair', 'Rajasthan', 'India', 5,'345001'),
    ('Malviya Nagar', 'Jaipur', 'Rajasthan', 'India', 4,'302033'),
    ('Bapu Nagar', 'Jaipur', 'Rajasthan', 'India', 3,'302033');
    

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
    

    