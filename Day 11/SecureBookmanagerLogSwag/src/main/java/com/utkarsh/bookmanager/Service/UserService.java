package com.utkarsh.bookmanager.Service;

import com.utkarsh.bookmanager.Entity.Users;
import com.utkarsh.bookmanager.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        log.debug("Request : Register User");
        user.setPassword(encoder.encode(user.getPassword()));
        Users saved = userRepository.save(user);

        log.info("User '{}' registered with id {}", saved.getUsername(), saved.getId());
        return saved;
    }

    public String verify(Users user) {
        log.debug("Request : Verify User");
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()) {
            String token = jwtService.generateToken(user.getUsername());
            log.info("User '{}' authenticated, JWT issued", user.getUsername());
            return token;
        }

        log.warn("Authentication failed for user '{}'", user.getUsername());
        return "Fail";
    }
}
