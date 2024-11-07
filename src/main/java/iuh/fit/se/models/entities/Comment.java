package iuh.fit.se.models.entities;

import java.time.LocalDateTime;

import iuh.fit.se.models.enums.State;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "comment")@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime createdTime;

    @Lob
    private String content;
    @Column(columnDefinition = "tinyint")
    private int rate;
    
    @PrePersist
	protected void onCreate() {
		createdTime = LocalDateTime.now();
	}
}