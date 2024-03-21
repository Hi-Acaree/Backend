package org.acaree.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Apply CORS to all paths under /api
                        .allowedOrigins(
                                "http://theacaree.com.s3-website-us-east-1.amazonaws.com",
                                "https://theacaree.com",
                                "http://localhost:3000" // Allow requests from these origins
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                        .allowedHeaders("*") // Allows all headers
                        .allowCredentials(true); // Allow cookies
            }
        };
    }
}
