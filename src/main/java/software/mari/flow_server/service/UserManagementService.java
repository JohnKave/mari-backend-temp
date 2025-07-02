package software.mari.flow_server.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import software.mari.flow_server.model.user.RegisterRequest;
import software.mari.flow_server.model.user.User;
import software.mari.flow_server.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String registerUser(RegisterRequest request) {
        // check if email exists
            if (userRepository.findByMail(request.getMail()).isPresent()) {
                return "Email already Registered!";
            }
        var user = User.builder()
                .name(request.getName())
                .mail(request.getMail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isDeveloper(request.isDeveloper())
                .build();

        userRepository.save(user);
        return "Registration successful.";

    }

}
