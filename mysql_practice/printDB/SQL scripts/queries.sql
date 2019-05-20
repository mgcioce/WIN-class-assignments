-- 1.List all customer along with their address, city, state and zip
SELECT first_name, last_name, address_house_number, address_street, address_housing_unit,
		address_city, address_state, address_zip 
FROM Customer;

-- 2.List all customers and their phone numbers that live in GA 
SELECT first_name, last_name, phone_number
FROM Customer
WHERE address_state = 'GA';

-- 3.List all customers along with their zip codes that live in NC or SC
SELECT first_name, last_name, address_zip
FROM Customer
WHERE address_state = 'NC' OR address_state = 'SC';

-- 4. List all titles that have been sold along with the artist, order date and ship date
SELECT DISTINCT title, artist, order_date, ship_date
FROM (Order_Item_Map JOIN Customer_Order 
	ON Order_Item_Map.customer_order_id = Customer_Order.id) JOIN Item 
    ON Order_Item_Map.item_id = Item.id; 

-- 5. List all item id, title, artist, unit price, and on hand in ascending order by price
SELECT *
FROM Item
ORDER BY unit_price ASC;

-- 6. List all item id, title, artist, unit price, and on hand for all items with a unit price
-- that is more than $100.00
SELECT * 
FROM Item
WHERE unit_price > 100.00
ORDER BY unit_price ASC;

-- 7. List all item id, title, artist, unit price, and on hand for all items where there are more 
-- than 300 on hand
SELECT * 
FROM Item
WHERE stock > 300
ORDER BY stock ASC;

-- 8. List all titles along with their unit price and retail price (retail price is unit price 
-- doubled)
SELECT title, unit_price, unit_price * 2 AS 'retail_price'
FROM Item;
        
-- 9. List all customers that have placed an order in 2014 along with their phone numbers
SELECT first_name, last_name, phone_number
FROM (Customer JOIN Customer_Order ON Customer.id = Customer_Order.customer_id)
WHERE order_date > '20131231' AND order_date <= '20141231';

-- 10. List all artists with the number of their prints that have been sold
SELECT artist, SUM(item_quantity) AS 'units_sold'
FROM (Item JOIN Order_Item_Map ON Item.id = Order_Item_Map.item_id)
GROUP BY artist;

-- 11. List all titles that have a unit price between $40.00 and $100.00.
SELECT title
FROM Item 
WHERE unit_price >= 40.00 AND unit_price <= 100.00;

-- 12. List all customers, title, artist, quantity ordered
SELECT Customer.id, first_name, last_name, artist, title, SUM(item_quantity) AS 'units_ordered',
    SUM(item_quantity * unit_price * 2) AS 'revenue'
FROM ((Order_Item_Map JOIN Customer_Order 
	ON Order_Item_Map.customer_order_id = Customer_Order.id) JOIN Customer 
    ON Customer_Order.customer_id = Customer.id) JOIN Item 
    ON Order_Item_Map.item_id = Item.id
GROUP BY Customer.id, artist, title;

-- 13. List all customers along with the total revenue received from that customer 
-- (revenue would be total retail price)
-- First I would need to get what each person ordered, then i have to accumulate the value of what 
-- they ordered

SELECT first_name, last_name, SUM(item_quantity * unit_price * 2) AS 'revenue'
FROM ((Order_Item_Map JOIN Customer_Order 
	ON Order_Item_Map.customer_order_id = Customer_Order.id) JOIN Customer 
    ON Customer_Order.customer_id = Customer.id) JOIN Item 
    ON Order_Item_Map.item_id = Item.id
GROUP BY first_name, last_name;

-- 14. List each state and the number of customers from that state
SELECT address_state, COUNT(address_state)
FROM Customer
GROUP BY address_state;

