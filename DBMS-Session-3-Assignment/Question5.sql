/*
* Query 1: Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
* with latest ordered items should be displayed first for last 60 days.
*/
CREATE VIEW order_information AS
    SELECT o.order_id, p.product_id, p.product_name, o.order_amount, u.user_name, u.email_id, o.order_date, o.order_status
    FROM orders o, products p, user u WHERE
    o.product_id = p.product_id AND
    o.email_id = u.email_id AND 
    DATEDIFF(CURDATE(), o.order_date) >= 60
    ORDER BY o.order_date DESC;

SELECT * FROM order_information;


/*
* Query 2: Use the above view to display the Products(Items) which are in ‘shipped’ state.
*/
SELECT product_id, product_name
FROM order_information WHERE
order_status = 'Shipped';


/*
* Query 3: Use the above view to display the top 5 most selling products.
*/
SELECT product_id, product_name
FROM order_information
GROUP BY product_id
ORDER BY COUNT(product_id) DESC
LIMIT 5;


