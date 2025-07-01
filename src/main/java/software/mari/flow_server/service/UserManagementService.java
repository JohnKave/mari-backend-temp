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

    public void registerUser(RegisterRequest request) {
        // check if email exists
//        if (userRepository.existsByMail(request.getMail())) {
//            throw new EmailAlreadyExistsException("Email already Registered!");
//        }

        var user = User.builder()
                .name(request.getName()) //This had some errors, name was null even after this
                .mail(request.getMail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isDeveloper(request.isDeveloper())
                .build();

        user.setName(request.getName()); //This was added and solved the above problem

        userRepository.save(user);

    }

}
