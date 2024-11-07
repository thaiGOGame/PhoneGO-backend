/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `phonego`;
CREATE DATABASE IF NOT EXISTS `phonego` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `phonego`;

CREATE TABLE IF NOT EXISTS `brand_discount` (
  `brand` enum('APPLE','GOOGLE','HUAWEI','NOKIA','ONEPLUS','OPPO','SAMSUNG','SONY','VIVO','XIAOMI') DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK6dmo4rxfuwknvtdsh0lpbd78n` FOREIGN KEY (`id`) REFERENCES `discount` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `brand_discount` (`brand`, `id`) VALUES
	('SAMSUNG', 2),
	('SONY', 3);

CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` datetime(6) DEFAULT NULL,
  `state` enum('CANCELED','COMPLETED','PENDING') DEFAULT NULL,
  `total_due` decimal(19,0) DEFAULT NULL,
  `used_coin` decimal(19,0) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg5uhi8vpsuy0lgloxk2h4w5o6` (`user_id`),
  CONSTRAINT `FKg5uhi8vpsuy0lgloxk2h4w5o6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `cart_detail` (
  `pat` decimal(19,0) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`,`product_id`),
  KEY `FK37hai783jhfcqo6h0pkiqmc9s` (`product_id`),
  CONSTRAINT `FK37hai783jhfcqo6h0pkiqmc9s` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKrg4yopd2252nwj8bfcgq5f4jp` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `category_discount` (
  `category` enum('CHARGING_CABLE','EARPHONE','PHONE','POWER_BANK') DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKq6h6juemsy27btkbfobgbxgua` FOREIGN KEY (`id`) REFERENCES `discount` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `category_discount` (`category`, `id`) VALUES
	('PHONE', 1),
	('POWER_BANK', 2),
	('CHARGING_CABLE', 3);

CREATE TABLE IF NOT EXISTS `charging_cable` (
  `cable_type` enum('LIGHTNING','MICRO_USB','TYPE_C','USB_A','USB_B') DEFAULT NULL,
  `length` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK21v3r7y7b749yos0aumuaw62y` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `charging_cable` (`cable_type`, `length`, `id`) VALUES
	('LIGHTNING', 200, 9);

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `rate` tinyint(4) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm1rmnfcvq5mk26li4lit88pc5` (`product_id`),
  KEY `FKqm52p1v3o13hy268he0wcngr5` (`user_id`),
  CONSTRAINT `FKm1rmnfcvq5mk26li4lit88pc5` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKqm52p1v3o13hy268he0wcngr5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_value` decimal(19,0) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `discount` (`id`, `discount_value`, `end_date`, `start_date`) VALUES
	(1, 10000, '2024-11-30 23:59:59.000000', '2024-11-01 00:00:00.000000'),
	(2, 15000, '2024-12-15 23:59:59.000000', '2024-11-15 00:00:00.000000'),
	(3, 30000, '2024-12-31 23:59:59.000000', '2024-12-01 00:00:00.000000'),
	(4, 1000, '2024-11-30 23:59:59.000000', '2024-11-01 00:00:00.000000'),
	(5, 15000, '2024-12-15 23:59:59.000000', '2024-11-15 00:00:00.000000'),
	(6, 150000, '2024-12-31 23:59:59.000000', '2024-12-01 00:00:00.000000');

CREATE TABLE IF NOT EXISTS `earphone` (
  `battery_life` int(11) NOT NULL,
  `connection_type` enum('BLUETOOTH','USB','WIRELESS') DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK8k4jp9gqatoyo9jwc38yq32jw` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `earphone` (`battery_life`, `connection_type`, `id`) VALUES
	(12, 'BLUETOOTH', 7),
	(16, 'BLUETOOTH', 10);

CREATE TABLE IF NOT EXISTS `phone` (
  `chip` varchar(255) DEFAULT NULL,
  `os` enum('ANDROID','IOS') DEFAULT NULL,
  `ram` enum('GB_12','GB_16','GB_32','GB_4','GB_64','GB_8') DEFAULT NULL,
  `rom` enum('GB_128','GB_16','GB_256','GB_32','GB_512','GB_64','TB_1','TB_2','TB_4') DEFAULT NULL,
  `screen_size` decimal(3,2) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKh3yu6rasx7kl290g57xdf06ac` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `phone` (`chip`, `os`, `ram`, `rom`, `screen_size`, `id`) VALUES
	('A15 Bionic', 'IOS', 'GB_4', 'GB_128', 6.10, 1),
	('Exynos 2100', 'ANDROID', 'GB_8', 'GB_256', 6.20, 2),
	('Snapdragon 678', 'ANDROID', 'GB_4', 'GB_64', 6.43, 3),
	('Snapdragon 888', 'ANDROID', 'GB_12', 'GB_256', 6.55, 4),
	('Snapdragon 888', 'ANDROID', 'GB_12', 'GB_256', 6.70, 5),
	('Exynos 1080', 'ANDROID', 'GB_12', 'GB_256', 6.44, 6);

CREATE TABLE IF NOT EXISTS `power_bank` (
  `capacity` int(11) DEFAULT NULL,
  `connection_type` enum('BLUETOOTH','USB','WIRELESS') DEFAULT NULL,
  `fast_charging` int(11) DEFAULT NULL,
  `input` varchar(50) DEFAULT NULL,
  `output` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKlc59v2u8hs7lquf0hnf4x1nfy` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `power_bank` (`capacity`, `connection_type`, `fast_charging`, `input`, `output`, `id`) VALUES
	(18000, 'WIRELESS', 1, '9V/2A', '9V/2A', 8);

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` enum('APPLE','GOOGLE','HUAWEI','NOKIA','ONEPLUS','OPPO','SAMSUNG','SONY','VIVO','XIAOMI') DEFAULT NULL,
  `category` enum('CHARGING_CABLE','EARPHONE','PHONE','POWER_BANK') DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  `purchase_price` decimal(19,0) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `sale_price` decimal(19,0) DEFAULT NULL,
  `url` longtext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `product` (`id`, `brand`, `category`, `name`, `purchase_price`, `quantity`, `sale_price`, `url`) VALUES
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

CREATE TABLE IF NOT EXISTS `product_discount` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr5ttw8wovl5nkcc9ysfc16fkk` (`product_id`),
  CONSTRAINT `FK20tn1p3253uiimwgiq61w9dqr` FOREIGN KEY (`id`) REFERENCES `discount` (`id`),
  CONSTRAINT `FKr5ttw8wovl5nkcc9ysfc16fkk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `product_discount` (`id`, `product_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3);

CREATE TABLE IF NOT EXISTS `provider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  `origin` tinyint(4) DEFAULT NULL CHECK (`origin` between 0 and 9),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `purchase_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` datetime(6) DEFAULT NULL,
  `purchase_price` decimal(19,0) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `sale_price` decimal(19,0) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `provider_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK79a6tsn4e9qfillme2u9kr3i2` (`product_id`),
  KEY `FK22w0s64y9ofn7qok6yn3x02kl` (`provider_id`),
  CONSTRAINT `FK22w0s64y9ofn7qok6yn3x02kl` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`),
  CONSTRAINT `FK79a6tsn4e9qfillme2u9kr3i2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  `coin` decimal(19,0) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  `gender` enum('FEMALE','MALE','OTHER') DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  `phone_number` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  `role` enum('ADMIN','CUSTOMER','SELLER') DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_uca1400_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `users` (`id`, `address`, `coin`, `email`, `full_name`, `gender`, `password`, `phone_number`, `role`, `url`) VALUES
	(1, '123 Main St, New York, NY', 10000, 'alice@example.com', 'Alice Johnson', 'FEMALE', 'password123', '1234567890', 'CUSTOMER', 'http://example.com/alice.jpg'),
	(2, '456 Elm St, Los Angeles, CA', 25000, 'bob@example.com', 'Bob Smith', 'MALE', 'password456', '0987654321', 'SELLER', 'http://example.com/bob.jpg'),
	(3, '789 Maple Ave, Chicago, IL', 5000, 'charlie@example.com', 'Charlie Brown', 'OTHER', 'password789', '1231231234', 'CUSTOMER', 'http://example.com/charlie.jpg'),
	(4, '101 Oak St, Houston, TX', 15000, 'dana@example.com', 'Dana White', 'FEMALE', 'password101', '3213214321', 'ADMIN', 'http://example.com/dana.jpg'),
	(5, '202 Pine Rd, Miami, FL', 20000, 'edward@example.com', 'Edward Green', 'MALE', 'password202', '9876543210', 'SELLER', 'http://example.com/edward.jpg'),
	(6, '303 Cedar Ln, Seattle, WA', 35000, 'fiona@example.com', 'Fiona Black', 'FEMALE', 'password303', '6543210987', 'CUSTOMER', 'http://example.com/fiona.jpg'),
	(7, '404 Birch Blvd, San Francisco, CA', 18000, 'george@example.com', 'George White', 'MALE', 'password404', '4567890123', 'CUSTOMER', 'http://example.com/george.jpg'),
	(8, '505 Spruce Dr, Denver, CO', 12000, 'helen@example.com', 'Helen Brown', 'FEMALE', 'password505', '7890123456', 'SELLER', 'http://example.com/helen.jpg'),
	(9, '606 Willow Ct, Dallas, TX', 30000, 'ian@example.com', 'Ian Gray', 'MALE', 'password606', '1230984567', 'ADMIN', 'http://example.com/ian.jpg'),
	(10, '707 Poplar St, Boston, MA', 22000, 'julia@example.com', 'Julia Green', 'FEMALE', 'password707', '9871236540', 'CUSTOMER', 'http://example.com/julia.jpg');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
