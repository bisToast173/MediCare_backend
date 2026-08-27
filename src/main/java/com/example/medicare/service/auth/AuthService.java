package com.example.medicare.service.auth;


import com.example.medicare.dto.request.LoginRequest;
import com.example.medicare.dto.response.AuthResponse;
import com.example.medicare.repository.users.UserRepository;
import com.example.medicare.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        var token = UsernamePasswordAuthenticationToken.unauthenticated(request.email(), request.password());
        authenticationManager.authenticate(token);

        var user = userRepository.findByEmail(request.email()).orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }
}
