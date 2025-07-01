package software.mari.flow_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.mari.flow_server.model.user.AuthRequest;
import software.mari.flow_server.model.user.AuthResponse;
import software.mari.flow_server.model.user.RegisterRequest;
import software.mari.flow_server.service.AuthService;
import software.mari.flow_server.service.CustomUserDetailsService;
import software.mari.flow_server.service.JwtService;
import software.mari.flow_server.service.UserManagementService;

@RestController
@RequestMapping("/api/auth")
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
        userManagementService.registerUser(request);
        return ResponseEntity.ok("Registration successful.");
    }



}
