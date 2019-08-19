USE StoreFront;

/*
* Function 1 : Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
*/
DELIMITER $$
CREATE FUNCTION calculate_number_of_orders(month INT, year INT)
    RETURNS INT
    DETERMINISTIC
        BEGIN
            DECLARE number_of_orders int;
            SELECT COUNT(order_id) INTO number_of_orders
            FROM orders 
            WHERE
                MONTH(order_date) = month AND
                YEAR(order_date) = year;
            RETURN (number_of_orders);
        END$$


/*
* Function 2 : Create a function to return month in a year having maximum orders. Year will be input parameter.
*/
DELIMITER $$
CREATE FUNCTION calculate_month_of_max_orders(year INT)
    RETURNS INT
    DETERMINISTIC
        BEGIN
            DECLARE month_of_max_orders int;
            SELECT MONTH(order_date) INTO month_of_max_orders
            FROM orders 
            WHERE YEAR(order_date) = year
            ORDER BY MONTH(order_date) DESC
            LIMIT 1;
            RETURN (month_of_max_orders);
        END$$