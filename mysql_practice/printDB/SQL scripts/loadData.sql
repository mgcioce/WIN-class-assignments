SET foreign_key_checks = 0;

LOAD DATA INFILE '/var/lib/mysql-files/csv/Customer.csv'
	INTO TABLE Customer
    FIELDS TERMINATED BY ','
    IGNORE 1 LINES;

LOAD DATA INFILE '/var/lib/mysql-files/csv/Item.csv'
	INTO TABLE Item
    FIELDS TERMINATED BY ','
    IGNORE 1 LINES;

LOAD DATA INFILE '/var/lib/mysql-files/csv/Order.csv'
	INTO TABLE Customer_Order
    FIELDS TERMINATED BY ','
    IGNORE 1 LINES;

LOAD DATA INFILE '/var/lib/mysql-files/csv/Order_Item_Map.csv'
	INTO TABLE Order_Item_Map
    FIELDS TERMINATED BY ','
    IGNORE 1 LINES;

SET foreign_key_checks = 1;