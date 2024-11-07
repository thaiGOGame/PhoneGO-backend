package iuh.fit.se.models.dtos;

import java.math.BigDecimal;

import iuh.fit.se.models.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private Product product;
    private BigDecimal discountedPrice;
}
