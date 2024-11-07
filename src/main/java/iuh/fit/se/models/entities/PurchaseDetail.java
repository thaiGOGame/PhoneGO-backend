package iuh.fit.se.models.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Purchase_Detail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	private LocalDateTime createdTime;
	private int quantity;
	@Column(name = "purchase_price", columnDefinition = "Decimal(19,0)")
	private BigDecimal purchasePrice;
	@Column(name = "sale_price", columnDefinition = "Decimal(19,0)")
	private BigDecimal salePrice;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id", referencedColumnName = "id")
	private Provider provider;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	@PrePersist
	protected void onCreate() {
		this.createdTime = LocalDateTime.now();
	}
}
