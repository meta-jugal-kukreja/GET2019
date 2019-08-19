/*
* Query 1 : Display Shopper’s information along with number of orders he/she placed during last 30 days.
*/
SELECT u.user_name, u.email_id, u.phone_no, COUNT(o.email_id) as number_of_orders
FROM user u, orders o
WHERE u.email_id = o.email_id AND
u.type_of_user = 'S' AND DATEDIFF(CURDATE(), o.order_date) <= 30; 


/*
* Query 2 : Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
*/
SELECT u.user_name, u.email_id, u.phone_no, SUM(o.order_amount) AS total_revenue
FROM user u, orders o
WHERE u.email_id = o.email_id AND 
u.type_of_user = 'S' AND DATEDIFF(CURDATE(), o.order_date) <= 30
GROUP BY u.user_name
ORDER BY total_revenue
LIMIT 10; 


/*
* Query 3 : Display top 20 Products which are ordered most in last 60 days along with numbers.
*/
SELECT p.product_name, SUM(o.number_of_products) AS number_of_products
FROM products p, orders o
WHERE p.product_id = o.product_id AND
DATEDIFF(CURDATE(), o.order_date) <= 60
GROUP BY p.product_name
ORDER BY number_of_products DESC
LIMIT 20;


/*
* Query 4 : Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
*/
SELECT MONTH(order_date) AS Month, SUM(order_amount) as Monthly_Sale
FROM orders
WHERE TIMESTAMPDIFF(MONTH, order_date, CURDATE()) <= 6
GROUP BY Month;


/*
* Query 5 : Mark the products as Inactive which are not ordered in last 90 days.
*/
UPDATE stock 
SET amount_of_product_in_stock = 0 
WHERE product_id IN (SELECT o.product_id 
                        FROM orders o
                        WHERE o.product_id = stock.product_id AND
                        DATEDIFF(CURDATE(), o.order_date) >= 90);

SELECT * FROM stock;


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
SELECT p.product_name AS Product, COUNT(o.order_id) AS Cancelled_time
FROM products p, orders o
WHERE p.product_id = o.product_id AND
o.order_status = 'Cancelled'
GROUP BY p.product_id
ORDER BY o.order_id DESC;
