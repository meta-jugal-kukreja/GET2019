/*
* Query 1 : Display Shopper’s information along with number of orders he/she placed during last 30 days.
*/
SELECT u.user_name, u.email_id, u.phone_no, COUNT(o.user_id) as number_of_orders
FROM Users u, Orders o
WHERE u.user_id = o.user_id AND
u.type_of_user = 'S' AND DATEDIFF(CURDATE(), o.order_date) <= 30
GROUP BY u.user_id; 


/*
* Query 2 : Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
*/
SELECT u.user_name, u.email_id, u.phone_no, SUM(o.order_amount) AS total_revenue
FROM Users u, Orders o
WHERE u.user_id = o.user_id AND o.order_Status = 'Shipped' AND 
u.type_of_user = 'S' AND DATEDIFF(CURDATE(), o.order_date) <= 30
GROUP BY o.user_id
ORDER BY total_revenue Desc
LIMIT 10;

/*
* Query 3 : Display top 20 Products which are ordered most in last 60 days along with numbers.
*/
SELECT (c.product_id), p.product_name, COUNT(c.order_id) AS NoOfProducts
FROM Cart c , Products p, Orders o
WHERE c.order_id = o.order_id AND
p.product_id = c.product_id AND DATEDIFF(CURDATE(), o.order_date) <= 60
AND c.order_status = 'Shipped'
GROUP BY c.product_id
ORDER BY NoOfProducts DESC
LIMIT 20;


/*
* Query 4 : Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
*/
SELECT MONTH(order_date) AS Month, SUM(order_amount) as Monthly_Sale
FROM Orders
WHERE TIMESTAMPDIFF(MONTH, order_date, CURDATE()) <= 6 AND order_status = 'Shipped'
GROUP BY Month;


/*
* Query 5 : Mark the products as Inactive which are not ordered in last 90 days.
*/
UPDATE Stock 
SET amount_of_product_in_stock = 0 
WHERE product_id IN (SELECT o.product_id 
                        FROM Orders o
                        WHERE o.product_id = Stock.product_id AND
                        DATEDIFF(CURDATE(), o.order_date) <= 90);

SELECT * FROM Stock;


/*
* Query 6 : Given a category search keyword, display all the Products present in this category/categories. 
*/
SELECT p.product_name AS product
FROM products p, category c
WHERE p.category_id = c.category_id AND 
c.category_name LIKE 'R%';


/*
* Query 7 : Display top 10 Items which were cancelled most.
*/
SELECT p.product_name AS Product, COUNT(c.product_id) AS Cancelled_time
FROM Products p, Cart c
WHERE p.product_id = c.product_id AND
c.order_status = 'Cancelled'
GROUP BY p.product_id
ORDER BY c.order_id DESC;
