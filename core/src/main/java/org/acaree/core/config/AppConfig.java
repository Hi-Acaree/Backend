package org.acaree.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.Objects;
import java.util.Properties;

/**
 * This class is a configuration class for the core module.
 * {@code @Configuration} annotation to indicate that this class is a configuration class.
 * {@code @ComponentScan} annotation to indicate the packages to be scanned for components.
 */

@Configuration
@EnableScheduling
@Slf4j
@ComponentScan(basePackages = {"org.acaree.core.repository",
        "org.acaree.core.service", "org.acaree.core.model", "org.acaree.core.notification"})
public class AppConfig {
    private final Environment env;

    @Autowired
    public AppConfig(Environment env) {
        this.env = env;
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
        mailSender.setHost(env.getProperty("EMAIL_HOST"));
        mailSender.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("EMAIL_PORT"))));
        mailSender.setUsername(env.getProperty("EMAIL_FROM"));
        mailSender.setPassword(env.getProperty("EMAIL_PASSWORD"));
        mailSender.setProtocol(env.getProperty("EMAIL_PROTOCOL"));
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        return mailSender;
    }



}
