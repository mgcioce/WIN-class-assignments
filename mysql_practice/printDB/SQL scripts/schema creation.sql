CREATE TABLE Customer (
	id INT NOT NULL AUTO_INCREMENT,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    address_house_number INT NOT NULL,
    address_street TEXT NOT NULL,
    address_housing_unit TEXT DEFAULT NULL,
    address_city TEXT NOT NULL,
    address_state TEXT NOT NULL CHECK (char_length(address_state) = 2),
    address_zip TEXT NOT NULL CHECK (char_length(address_zip) = 5 OR char_length(address_zip) = 10),
    phone_number TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Customer_Order (
	id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    ship_date DATE NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES Customer(id)
		ON DELETE RESTRICT
        ON UPDATE RESTRICT
);

CREATE TABLE Item (
	id INT NOT NULL AUTO_INCREMENT,
    title TEXT NOT NULL,
    artist TEXT NOT NULL,
    unit_price DECIMAL(6,2) NOT NULL DEFAULT 0.00,
    stock INT NOT NULL DEFAULT 0 CHECK (stock >= 0),
    PRIMARY KEY (id)
);

CREATE TABLE Order_Item_Map (
	customer_order_id INT NOT NULL,
    item_id INT NOT NULL,
    item_quantity INT NOT NULL CHECK (item_quantity >= 1),
    CONSTRAINT fk_customer_order FOREIGN KEY (customer_order_id) REFERENCES Customer_Order(id)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES Item(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);


