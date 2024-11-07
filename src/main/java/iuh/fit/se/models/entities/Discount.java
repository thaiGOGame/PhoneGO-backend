package iuh.fit.se.models.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import iuh.fit.se.models.enums.Brand;
import iuh.fit.se.models.enums.Category;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "discount_value", columnDefinition = "Decimal(19,0)")
    private BigDecimal discountValue;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
