
SELECT p.product_id AS 'ID', p.product_Name AS 'Name', c.category_name AS 'Category Title', p.product_price AS 'Price', p.issue_date AS 'Date'
FROM products p, category c
WHERE p.category_id = c.category_id
ORDER BY p.issue_date DESC;


SELECT p.product_id AS 'ID', p.product_Name AS 'Name', p.product_price AS 'Price'
FROM products p
WHERE NOT EXISTS (SELECT i.product_id FROM images i WHERE p.product_id = i.product_id);


SELECT DISTINCT child.category_id AS 'ID', child.category_name AS 'Titlte', 
IFNULL(parent.category_name, 'Top Category') AS parent_name
FROM category child LEFT JOIN category parent 
ON child.parent_category = parent.category_id
ORDER BY parent_name, child.category_name;


SELECT leaf.category_id, leaf.category_name, parent.category_name AS parent_category_name
FROM category leaf, category parent
WHERE parent.category_id = leaf.parent_category AND 
	NOT EXISTS(SELECT * 
                FROM category child 
                WHERE leaf.category_id = child.parent_category);
                

SELECT c.category_name, p.product_name, p.product_price
FROM products p, category c
WHERE p.category_id = c.category_id
GROUP BY c.category_name;
    

SELECT p.product_name, s.amount_of_product_in_stock, p.product_price
FROM products p, stock s
WHERE p.product_id = s.product_id AND s.amount_of_product_in_stock < 50;


UPDATE stock 
SET amount_of_product_in_stock = amount_of_product_in_stock + 100;

SELECT * FROM stock;

    
    