package iuh.fit.se.models.dtos;

import java.math.BigDecimal;

import iuh.fit.se.models.enums.Gender;
import iuh.fit.se.models.enums.Role;
import lombok.*;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private String address;
    private Role role;
    private String url;
    private BigDecimal coin;
}