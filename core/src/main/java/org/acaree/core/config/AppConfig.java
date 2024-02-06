package org.acaree.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

/**
 * This class is a configuration class for the core module.
 * {@code @Configuration} annotation to indicate that this class is a configuration class.
 * {@code @ComponentScan} annotation to indicate the packages to be scanned for components.
 */

@Configuration
@EnableScheduling
@ComponentScan(basePackages = {"org.acaree.core.repository, " +
        "org.acaree.core.service, org.acaree.core.model" + "org.acaree.core.notification"})
public class AppConfig {
    //== beans ==
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;

    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.office365.com");
        mailSender.setPort(587);
        mailSender.setUsername(System.getenv("EMAIL_FROM"));
        mailSender.setPassword(System.getenv("EMAIL_PASSWORD"));
        mailSender.setProtocol("smtp");
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        return mailSender;
    }
}
