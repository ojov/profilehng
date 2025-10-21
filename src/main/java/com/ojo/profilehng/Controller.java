package com.ojo.profilehng;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;
@RestController
@RequestMapping("/me")
public class Controller {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<?> getProfile() {
        String catFactUrl = "https://catfact.ninja/fact";
        String fact = "Could not fetch cat fact at the moment.";

        try {
            Map response = restTemplate.getForObject(catFactUrl, Map.class);
            if (response != null && response.get("fact") != null) {
                fact = response.get("fact").toString();
            }
        } catch (Exception e) {
            System.err.println("Error fetching cat fact: " + e.getMessage());
        }

        Map<String, Object> user = Map.of(
                "email", "osamudiameojo@gmail.com",
                "name", "Osamudiamen Ojo",
                "stack", "Java/Spring Boot"
        );

        Map<String, Object> response = Map.of(
                "status", "success",
                "user", user,
                "timestamp", Instant.now().toString(),
                "fact", fact
        );

        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(response);
    }

}
