package iuh.fit.se.models.services;

import java.math.BigDecimal;

import iuh.fit.se.models.entities.Product;

public interface DiscountService {
	BigDecimal calculateDiscountedPrice(Product product);
}
