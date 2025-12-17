package com.user.service;

import com.claim.Entity.Claim;
import com.user.Entity.User;
import com.user.dto.LoginRequest;
import com.user.dto.RegisterRequest;
import com.user.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserService {
        String register(RegisterRequest request);

        UserDto createUser(UserDto dto);
        String login(LoginRequest request);
        User getUser(Long userId);
        List<Claim> getClaimsByUserId(Long userId);

}
