USE StoreFront;

/*
* Query 1 : Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/
SELECT p.product_id, p.product_name, COUNT(c.category_id) AS count_of_categories
FROM products p INNER JOIN category c ON
p.category_id = c.category_id
GROUP BY c.category_id
HAVING count_of_categories > 1;

/*
* Query 2 : Display Count of products as per below price range 0-1000,1001-5000,Above 5000
*/
SELECT price_range, count(*) no_of_products
FROM (SELECT CASE
                WHEN product_price >= 0 AND product_price <= 1000 THEN '0-1000'
                WHEN product_price >= 1001 AND product_price <= 5000 THEN '1001-5000'
                ELSE 'Above 5000'
            END as price_range
      FROM products) as count_of_products
GROUP BY price_range;

/*
* Query 3 : Display the Categories along with number of products under each category.
*/
SELECT c.category_name, COUNT(p.product_id) AS number_of_products
FROM category c INNER JOIN products p ON
c.category_id = p.product_id
GROUP BY c.category_id;

