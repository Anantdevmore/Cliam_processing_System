package com.user.serviceImpl;

import com.claim.Entity.Claim;
import com.user.Exception.customException.ExternalServiceException;
import com.user.Exception.customException.ResourceNotFoundException;
import com.user.JWT.JwtUtil;
import com.user.Entity.User;
import com.user.dto.ClaimsByUserResponse;
import com.user.dto.LoginRequest;
import com.user.dto.RegisterRequest;
import com.user.dto.UserDto;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManager authManager, CustomUserDetailsService customUserDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.customUserDetailsService = customUserDetailsService;
    }
    @Override
    public UserDto createUser(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setStatus("ACTIVE");
        user.setRole("USER");

        User savedUser = userRepository.save(user);

        return new UserDto(savedUser.getUserId(), savedUser.getUsername(), savedUser.getEmail(),savedUser.getPassword());
    }
    @Override
    public String register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setStatus("active");

        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUsername());
        return jwtUtil.generateToken(userDetails);
    }

    @Override
    public User getUser(Long userId) {
         User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return user;

    }
    public List<Claim> getClaimsByUserId(Long userId) {
        String url = "http://claim-service/api/claims/user/" + userId;

        try {
            ResponseEntity<List<Claim>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Claim>>() {}
            );

            List<Claim> claims = response.getBody();

            if (claims == null || claims.isEmpty()) {
                throw new ResourceNotFoundException("No claims found for user with ID: " + userId);
            }

            return claims;

        } catch (HttpClientErrorException.NotFound ex) {
            throw new ResourceNotFoundException("No claims found for user with ID: " + userId);
        } catch (HttpClientErrorException ex) {
            throw new ExternalServiceException("Error calling Claim Service: " + ex.getMessage());
        }
    }
}
