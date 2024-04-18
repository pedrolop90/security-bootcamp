package com.app.SpringSecurity.infraestructure.input;

import com.app.SpringSecurity.domain.model.AuthenticationRequest;
import com.app.SpringSecurity.domain.model.RegisterRequest;
import com.app.SpringSecurity.domain.model.AuthenticationResponse;
import com.app.SpringSecurity.infraestructure.Adapters.SecurityConfig.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticateController {

    private final AuthenticationService service;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return  ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(service.register(registerRequest));
    }
}
