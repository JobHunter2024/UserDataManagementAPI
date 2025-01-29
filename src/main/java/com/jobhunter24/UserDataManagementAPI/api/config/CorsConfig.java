package com.jobhunter24.UserDataManagementAPI.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**")
                        .allowedOrigins("*") // Allow all origins or specify your frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Include OPTIONS
                        .allowedHeaders("Authorization", "Content-Type") // Allow Authorization header
                        .exposedHeaders("Authorization"); // Expose Authorization header in responses if needed
                        //.allowCredentials(true); // If cookies/authentication are involved
            }
        };
    }
}
