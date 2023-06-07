package peakosft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import peakosft.enums.Role;
@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String email;
    private Role role;
}
