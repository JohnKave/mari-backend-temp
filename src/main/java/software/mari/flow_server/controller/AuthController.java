package software.mari.flow_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.mari.flow_server.model.user.AuthRequest;
import software.mari.flow_server.model.user.AuthResponse;
import software.mari.flow_server.model.user.RegisterRequest;
import software.mari.flow_server.service.AuthService;
import software.mari.flow_server.service.UserManagementService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserManagementService userManagementService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request
            ) {
        return ResponseEntity.ok(userManagementService.registerUser(request));
    }

}
