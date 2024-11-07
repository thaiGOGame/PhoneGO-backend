package iuh.fit.se.models.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import iuh.fit.se.models.enums.Brand;
import iuh.fit.se.models.enums.Category;
import iuh.fit.se.models.enums.State;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(columnDefinition = "nvarchar(100)")
	protected String name;
	@Lob
	protected String url;

	@Enumerated(EnumType.STRING)
	protected Brand brand;

	@Enumerated(EnumType.STRING)
	protected Category category;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	protected Set<CartDetail> cartDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	protected Set<Comment> comments;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	protected Set<PurchaseDetail> purchaseDetails;
	
	protected int quantity;
	@Column(name = "sale_price", columnDefinition = "Decimal(19,0)")
	protected BigDecimal salePrice;
	@Column(name = "purchase_price", columnDefinition = "Decimal(19,0)")
	protected BigDecimal purchasePrice;
	@Transient
    protected BigDecimal discountedPrice = BigDecimal.ZERO;
	@PrePersist
	protected void onCreate() {
		quantity = 0;
		salePrice = BigDecimal.ZERO;
		purchasePrice = BigDecimal.ZERO;
	}
}
