package com.app.SpringSecurity.infraestructure.Adapters.SecurityConfig;

import com.app.SpringSecurity.domain.model.AuthenticationRequest;
import com.app.SpringSecurity.domain.model.RegisterRequest;
import com.app.SpringSecurity.domain.model.AuthenticationResponse;
import com.app.SpringSecurity.infraestructure.Adapters.PostgresqlConfig.Model.RoleEnum;
import com.app.SpringSecurity.infraestructure.Adapters.PostgresqlConfig.Model.UserEntity;
import com.app.SpringSecurity.infraestructure.Adapters.PostgresqlConfig.Repository.IUserRepository;
import com.app.SpringSecurity.infraestructure.Adapters.SecurityConfig.JwtConfiguration.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        var user = repository.findByName(request.getName()).orElseThrow();

        var jwtToken = jwtService.generate(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        UserEntity user = UserEntity.builder().name(registerRequest.getName())
                .lastName(registerRequest.getLastName())
                .idDocument(registerRequest.getIdDocument())
                .id(registerRequest.getId())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .roleEnum(RoleEnum.USER).build();

        repository.save(user);

        return AuthenticationResponse.builder().token(jwtService.getToken(user)).build();
    }




}