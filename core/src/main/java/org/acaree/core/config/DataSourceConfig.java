package org.acaree.core.config;

import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

/**
 * configuration class for data source
 * uses aws rds
 * extracts the database url, username and password from aws secrets manager
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        SecretsManagerClient secretsManagerClient = SecretsManagerClient.builder().build();
        String secretName = "DATABASE_PASS";

        // Retrieve the secret from AWS Secrets Manager
        String secretString = secretsManagerClient.getSecretValue(GetSecretValueRequest.builder()
                .secretId(secretName)
                .build()).secretString();

        try {
            // Parse the secret string into JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode secretJson = objectMapper.readTree(secretString);

            // Extract the database URL, username, and password from the secret
            String databaseUrl = secretJson.get("host").textValue();
            String databaseUsername = secretJson.get("username").textValue();
            String databasePassword = secretJson.get("password").textValue();

            // Configure the DataSource
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl(databaseUrl);
            dataSource.setUsername(databaseUsername);
            dataSource.setPassword(databasePassword);

            return dataSource;
        } catch (Exception e) {
            // Handle exceptions appropriately
            throw new RuntimeException("Error parsing secret from AWS Secrets Manager", e);
        }
    }
}
