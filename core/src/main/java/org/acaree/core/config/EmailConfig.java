package org.acaree.core.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class EmailConfig {
    @Value("${EMAIL_HOST}")
    private String host;

    @Value("${EMAIL_PORT}")
    private int port;

    @Value("${EMAIL_PROTOCOL}")
    private String protocol;

    @Value("${EMAIL_FROM}")
    private String fromEmail;

    @Value("${EMAIL_PASSWORD}")
    private String password;
}
