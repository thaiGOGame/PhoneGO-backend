package iuh.fit.se.models.entities;

import java.math.BigDecimal;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "cart_detail")
public class CartDetail {
	@Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", nullable = false, referencedColumnName = "id")
    private Cart cart;

    private int quantity;

    @Column(name = "PAT", columnDefinition = "Decimal(19,0)")
    private BigDecimal priceAtTransaction;
}
