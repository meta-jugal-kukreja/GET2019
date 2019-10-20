
SELECT * 
FROM orders
ORDER BY order_date DESC
LIMIT 50;


SELECT * 
FROM orders
ORDER BY order_amount DESC
LIMIT 10;


SELECT *
FROM orders
WHERE DATEDIFF(CURDATE(), order_date) >= 10 
AND order_status = 'Not Shipped';


SELECT user_name, email_id
FROM user
WHERE email_id NOT IN (SELECT email_id
                        FROM orders
                        WHERE MONTH(order_date) >= MONTH(CURDATE()) AND
                                YEAR(order_date) >= YEAR(CURDATE()));
                                
                                
SELECT DISTINCT u.user_name, u.email_id, o.order_date
FROM user u, orders o
WHERE u.email_id = o.email_id AND DATEDIFF(CURDATE(), o.order_date) <= 15;


SELECT p.product_name, p.product_price
FROM Products p, Orders o
Where p.product_id = o.product_id AND
o.order_status = 'Shipped' AND
o.order_id = 1;


SELECT p.product_name, p.product_price, o.order_date
FROM Products p, Orders o
Where p.product_id = o.product_id AND
p.product_price BETWEEN 2000 AND 5000;