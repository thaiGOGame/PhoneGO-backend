-- Insert data into `users`
INSERT INTO users (address, coin, email, full_name, gender, password, phone_number, role, url) VALUES
('123 Main St, New York, NY', 10000, 'alice@example.com', 'Alice Johnson', 'FEMALE', 'password123', '1234567890', 'CUSTOMER', 'http://example.com/alice.jpg'),
('456 Elm St, Los Angeles, CA', 25000, 'bob@example.com', 'Bob Smith', 'MALE', 'password456', '0987654321', 'SELLER', 'http://example.com/bob.jpg'),
('789 Maple Ave, Chicago, IL', 5000, 'charlie@example.com', 'Charlie Brown', 'OTHER', 'password789', '1231231234', 'CUSTOMER', 'http://example.com/charlie.jpg'),
('101 Oak St, Houston, TX', 15000, 'dana@example.com', 'Dana White', 'FEMALE', 'password101', '3213214321', 'ADMIN', 'http://example.com/dana.jpg'),
('202 Pine Rd, Miami, FL', 20000, 'edward@example.com', 'Edward Green', 'MALE', 'password202', '9876543210', 'SELLER', 'http://example.com/edward.jpg'),
('303 Cedar Ln, Seattle, WA', 35000, 'fiona@example.com', 'Fiona Black', 'FEMALE', 'password303', '6543210987', 'CUSTOMER', 'http://example.com/fiona.jpg'),
('404 Birch Blvd, San Francisco, CA', 18000, 'george@example.com', 'George White', 'MALE', 'password404', '4567890123', 'CUSTOMER', 'http://example.com/george.jpg'),
('505 Spruce Dr, Denver, CO', 12000, 'helen@example.com', 'Helen Brown', 'FEMALE', 'password505', '7890123456', 'SELLER', 'http://example.com/helen.jpg'),
('606 Willow Ct, Dallas, TX', 30000, 'ian@example.com', 'Ian Gray', 'MALE', 'password606', '1230984567', 'ADMIN', 'http://example.com/ian.jpg'),
('707 Poplar St, Boston, MA', 22000, 'julia@example.com', 'Julia Green', 'FEMALE', 'password707', '9871236540', 'CUSTOMER', 'http://example.com/julia.jpg');

-- Insert data into `product`
INSERT INTO product (id, brand, category, name, purchase_price, quantity, sale_price, url) VALUES
(1, 'APPLE', 'PHONE', 'iPhone 13', 700000, 10, 800000, 'url1'),
(2, 'SAMSUNG', 'PHONE', 'Galaxy S21', 600000, 20, 750000, 'url2'),
(3, 'XIAOMI', 'PHONE', 'Redmi Note 10', 200000, 50, 250000, 'url3'),
(4, 'ONEPLUS', 'PHONE', 'OnePlus 9', 500000, 15, 650000, 'url4'),
(5, 'OPPO', 'PHONE', 'Find X3', 400000, 25, 550000, 'url5'),
(6, 'VIVO', 'PHONE', 'Vivo X60', 300000, 30, 450000, 'url6'),
(7, 'SONY', 'EARPHONE', 'Sony WF-1000XM4', 150000, 40, 200000, 'url7'),
(8, 'SAMSUNG', 'POWER_BANK', 'Samsung Powerbank 10000mAh', 100000, 60, 150000, 'url8'),
(9, 'HUAWEI', 'CHARGING_CABLE', 'Huawei Type-C Cable', 50000, 70, 80000, 'url9'),
(10, 'GOOGLE', 'EARPHONE', 'Google Pixel Buds', 120000, 35, 170000, 'url10');

-- Insert data into `discount`
INSERT INTO discount (id, discount_value, start_date, end_date) VALUES
(1, 5000, '2023-01-01 00:00:00', '2023-12-31 23:59:59'),
(2, 10000, '2023-02-01 00:00:00', '2023-12-31 23:59:59'),
(3, 15000, '2023-03-01 00:00:00', '2023-12-31 23:59:59'),
(4, 20000, '2023-04-01 00:00:00', '2023-12-31 23:59:59'),
(5, 25000, '2023-05-01 00:00:00', '2023-12-31 23:59:59'),
(6, 30000, '2023-06-01 00:00:00', '2023-12-31 23:59:59'),
(7, 35000, '2023-07-01 00:00:00', '2023-12-31 23:59:59'),
(8, 40000, '2023-08-01 00:00:00', '2023-12-31 23:59:59'),
(9, 45000, '2023-09-01 00:00:00', '2023-12-31 23:59:59'),
(10, 50000, '2023-10-01 00:00:00', '2023-12-31 23:59:59');

-- Insert data into `brand_discount`
INSERT INTO brand_discount (brand, id) VALUES
('APPLE', 1),
('GOOGLE', 2),
('HUAWEI', 3),
('NOKIA', 4),
('ONEPLUS', 5),
('OPPO', 6),
('SAMSUNG', 7),
('SONY', 8),
('VIVO', 9),
('XIAOMI', 10);

-- Insert data into `category_discount`
INSERT INTO category_discount (category, id) VALUES
('PHONE', 1),

-- Insert data into `charging_cable`
INSERT INTO charging_cable (cable_type, length, id) VALUES
('TYPE_C', 100, 1),
('USB_A', 150, 2),
('USB_B', 200, 3),
('LIGHTNING', 100, 4),
('MICRO_USB', 150, 5),
('TYPE_C', 200, 6),
('USB_A', 100, 7),
('USB_B', 150, 8),
('LIGHTNING', 200, 9),
('MICRO_USB', 100, 10);

-- Insert data into `comment`
INSERT INTO comment (id, content, created_date, rate, product_id, user_id) VALUES
(1, 'Great product!', '2023-06-15 10:00:00', 5, 1, 1),
(2, 'Not bad', '2023-06-16 11:00:00', 4, 2, 2),
(3, 'Satisfactory', '2023-06-17 12:00:00', 3, 3, 3),
(4, 'Could be better', '2023-06-18 13:00:00', 2, 4, 4),
(5, 'Excellent!', '2023-06-19 14:00:00', 5, 5, 5),
(6, 'Worth the price', '2023-06-20 15:00:00', 4, 6, 6),
(7, 'Too expensive', '2023-06-21 16:00:00', 2, 7, 7),
(8, 'Highly recommended', '2023-06-22 17:00:00', 5, 8, 8),
(9, 'Good value', '2023-06-23 18:00:00', 4, 9, 9),
(10, 'I liked it', '2023-06-24 19:00:00', 5, 10, 10);

-- Insert data into `earphone`
INSERT INTO earphone (battery_life, connection_type, id) VALUES
(10, 'BLUETOOTH', 1),
(12, 'USB', 2),
(8, 'WIRELESS', 3),
(15, 'BLUETOOTH', 4),
(10, 'USB', 5),
(18, 'WIRELESS', 6),
(12, 'BLUETOOTH', 7),
(10, 'USB', 8),
(14, 'WIRELESS', 9),
(16, 'BLUETOOTH', 10);

-- Insert data into `power_bank`
INSERT INTO power_bank (capacity, connection_type, fast_charging, input, output, id) VALUES
(10000, 'USB', 1, '5V/2A', '5V/2A', 1),
(15000, 'WIRELESS', 1, '5V/3A', '5V/3A', 2),
(20000, 'BLUETOOTH', 0, '9V/2A', '9V/2A', 3),
(25000, 'USB', 1, '5V/2A', '5V/2A', 4),
(30000, 'WIRELESS', 0, '9V/3A', '9V/3A', 5),
(5000, 'BLUETOOTH', 1, '12V/1.5A', '12V/1.5A', 6),
(12000, 'USB', 0, '5V/2A', '5V/2A', 7),
(18000, 'WIRELESS', 1, '9V/2A', '9V/2A', 8),
(22000, 'BLUETOOTH', 0, '5V/2A', '5V/2A', 9),
(14000, 'USB', 1, '5V/3A', '5V/3A', 10);