package com.practice.recipes.authentication;

import com.practice.recipes.authentication.utility.JwtTokenUtil;
import com.practice.recipes.models.Role;
import com.practice.recipes.models.User;
import com.practice.recipes.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAge(request.getAge());
        user.setDateCreated(new Date());
        user.setRole(Role.USER);
        userService.save(user);
        String jwtToken = jwtTokenUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        User user = userService.findByUsername(request.getUsername()).orElseThrow();
        String jwtToken = jwtTokenUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }

}
