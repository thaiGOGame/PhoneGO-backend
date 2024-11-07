package iuh.fit.se.models.dtos;

import iuh.fit.se.models.entities.Product;
import lombok.*;
import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPerformanceDTO {
    private Product product;
    private BigDecimal totalRevenue;
    private BigDecimal totalCost;
    private BigDecimal profit;
    private int totalQuantitySold;
}
