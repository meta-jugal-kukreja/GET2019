/*
* Identify the columns require indexing in order, product, category tables and create indexes.
*/
ALTER TABLE category ADD INDEX index_parent_id(parent_category);
ALTER TABLE orders ADD INDEX index_order_date(order_date);
ALTER TABLE orders ADD INDEX index_email(email_id);
ALTER TABLE products ADD INDEX index_issue_date(issue_date);
ALTER TABLE products ADD INDEX index_category_id(category_id);
