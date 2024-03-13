package org.acaree.core.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@Getter
@Slf4j
public class AwsConfig {

    @Value("${S3_ACCESS_KEY}")
    private String accessKey;

    @Value("${S3_SECRET_KEY}")
    private String secretKey;

    @Value("${S3_REGION}")
    private String awsRegion;


    @Value("${S3_BUCKET_NAME}")
    private String bucketName;

    @Value("${S3_ENDPOINT}")
    private String endpoint;


    public AwsConfig() {
        log.info("AWS Config: " + this);
    }

    @Bean
    public S3Client s3Client() {
        S3Client s3Client;

            s3Client = S3Client.builder()
                    .region(Region.of(awsRegion))
                    .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                    .build();
        return s3Client;
    }







}
