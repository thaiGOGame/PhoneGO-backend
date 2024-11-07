package iuh.fit.se.models.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import iuh.fit.se.models.enums.Gender;
import iuh.fit.se.models.enums.Role;
import iuh.fit.se.models.enums.State;
import iuh.fit.se.models.enums.UserState;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "users")@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(columnDefinition = "nvarchar(100)")
    private String fullName;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(columnDefinition = "nvarchar(15)")
    private String phoneNumber;
    @Column(columnDefinition = "nvarchar(200)")
    private String address;
    @Column(columnDefinition = "nvarchar(100)")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Lob
    private String url;
	@Column(columnDefinition = "Decimal(19,0)")
    private BigDecimal coin;

	private LocalDateTime createdTime;
	
	@Enumerated(EnumType.STRING)
	private UserState userState;
	
	@PrePersist
	protected void onCreate() {
		coin = BigDecimal.ZERO;
		createdTime = LocalDateTime.now();
	}
}