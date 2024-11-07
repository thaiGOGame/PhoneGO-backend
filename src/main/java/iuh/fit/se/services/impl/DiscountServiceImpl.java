package iuh.fit.se.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.models.entities.Product;
import iuh.fit.se.models.repositiory.DiscountRepository;
import iuh.fit.se.models.services.DiscountService;
@Service
public class DiscountServiceImpl implements DiscountService {
	@Autowired
	private DiscountRepository discountRepository;
	@Override
	public BigDecimal calculateDiscountedPrice(Product product) {
        // Initialize total discount value
		BigDecimal salePrice = product.getSalePrice();
        BigDecimal purchasePrice = product.getPurchasePrice();
        BigDecimal totalDiscount = BigDecimal.ZERO;
        
        // Fetch applicable discount values
        List<BigDecimal> discountsByProduct = discountRepository.findActiveDiscountValuesByProductId(product.getId());
        List<BigDecimal> discountByBrand = discountRepository.findActiveDiscountValuesByBrand(product.getBrand());
        List<BigDecimal> discountByCategory = discountRepository.findActiveDiscountValuesByCategory(product.getCategory());

        // Aggregate discounts for the product
        if (discountsByProduct != null) {
            for (BigDecimal discount : discountsByProduct) {
                if (discount != null) {
                    totalDiscount = totalDiscount.add(discount);
                }
            }
        }

        // Add valid brand discounts
        if (discountByBrand != null) {
            for (BigDecimal discount : discountByBrand) {
                if (discount != null) {
                    totalDiscount = totalDiscount.add(discount);
                }
            }
        }

        // Add valid category discounts
        if (discountByCategory != null) {
            for (BigDecimal discount : discountByCategory) {
                if (discount != null) {
                    totalDiscount = totalDiscount.add(discount);
                }
            }
        }

        // Calculate the discounted price
        BigDecimal discountedPrice = salePrice.subtract(totalDiscount);
        
        // Ensure the discounted price is not less than the purchase price
        if (discountedPrice.compareTo(purchasePrice) < 0) {
            discountedPrice = purchasePrice;
        }
        
        return discountedPrice;
    }
}
