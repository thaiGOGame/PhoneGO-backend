package iuh.fit.se.models.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import iuh.fit.se.models.enums.State;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cart", orphanRemoval = true)
	private Set<CartDetail> cartDetails;

	private LocalDateTime createdTime;
	
	private LocalDateTime modifiedTime;

	@Enumerated(EnumType.STRING)
	private State state;
	
	@Column(name = "used_coin", columnDefinition = "DECIMAL(19,0)")
	private BigDecimal usedCoin;
	
	@Column(name = "total_due", columnDefinition = "DECIMAL(19,0)")
	private BigDecimal totalDue;

	@PrePersist
	protected void onCreate() {
		createdTime = LocalDateTime.now();
		state = State.PENDING;
	}
}