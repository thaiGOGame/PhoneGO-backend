package iuh.fit.se.models.entities;

import iuh.fit.se.models.enums.ConnectionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "earphone")
@NoArgsConstructor
@AllArgsConstructor
public class Earphone extends Product {
    @Enumerated(EnumType.STRING)
    private ConnectionType connectionType;
    private int batteryLife;
}
