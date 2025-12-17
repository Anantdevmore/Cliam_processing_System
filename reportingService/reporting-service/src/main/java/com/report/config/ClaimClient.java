package com.report.config;

import com.report.Entity.Claim;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "claim-service", url = "http://localhost:8081/api/claims")

public interface ClaimClient {
    @GetMapping("/all")
    public List<Claim> getAllClaims();

    @GetMapping("/user/{userId}")
    List<Claim> getClaimsByUser(@PathVariable Long userId);
}
