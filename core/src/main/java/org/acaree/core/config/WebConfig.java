package org.acaree.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS to all paths
                .allowedOrigins("http://theacaree.com",
                        "http://theacaree.com.s3-website-us-east-1.amazonaws.com",
                        "http://localhost:3000") // Allow  frontend domain
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*")
                .maxAge(3600); // Maximum age of CORS preflight (in seconds)
    }
}
