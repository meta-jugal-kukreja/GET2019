/*
* Procedure 1 : Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
*/
DELIMITER $$
CREATE PROCEDURE calculateAverageSale(month INT, year INT)
    BEGIN
        SELECT p.product_name, AVG(o.order_amount)
        FROM products p, orders o
        WHERE
            p.product_id = o.product_id;
    END $$


/*
* Procedure 2 : Create a stored procedure to retrieve table having order detail with status for a given period. 
* Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
* If start date is greater than end date take first date of month as start date.
*/
DELIMITER $$
CREATE PROCEDURE ordersOfTheGivenPeriod(start_date DATE, end_date DATE)
    BEGIN
        IF start_date > end_date
            THEN SET start_date = DATE_ADD(DATE_ADD(LAST_DAY(end_date),INTERVAL 1 DAY),INTERVAL - 1 MONTH);
        END IF;
        SELECT p.product_name, p.product_price, o.order_amount, o.order_status, o.order_date
        FROM products p, orders o
        WHERE
            p.product_id = o.product_id AND
            o.order_date BETWEEN start_date AND end_date
        ORDER BY o.order_date DESC;
    END $$