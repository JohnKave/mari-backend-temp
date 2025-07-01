package software.mari.flow_server.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    String name;

    @NotBlank
    @Email
    String mail;

    @NotBlank
    @Size(min = 8)
    String password;

    boolean isDeveloper;

}
