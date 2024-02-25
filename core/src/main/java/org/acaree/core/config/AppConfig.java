package org.acaree.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * This class is a configuration class for the core module.
 * {@code @Configuration} annotation to indicate that this class is a configuration class.
 * {@code @ComponentScan} annotation to indicate the packages to be scanned for components.
 */

@Configuration
@EnableScheduling
@Slf4j
@ComponentScan(basePackages = {"org.acaree.core.repository, " +
        "org.acaree.core.service, org.acaree.core.model" + "org.acaree.core.notification"})
public class AppConfig {

    //== PostConstruct ==
    @PostConstruct
    public void init() {
        try {
            Path rootLocation = Paths.get("upload-dir");
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            log.error("Could not create the directory where the uploaded files will be stored.", e);
        }
    }



    //== beans ==
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;

    }

    //== JavaMailSender ==

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.optonline.net");
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
