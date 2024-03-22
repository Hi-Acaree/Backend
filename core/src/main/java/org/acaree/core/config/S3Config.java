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
public class S3Config {
    @Value("${S3_BUCKET_NAME}")
    private String bucketName;

    @Value(("${ACCESS_KEY_ID}"))
    private String accessKeyId;

    @Value(("${SECRET_ACCESS_KEY}"))
    private String secretAccessKey;

    @Value(("${aws.region}"))
    private String region;

    @Bean
    public S3Client s3Client(){
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .build();
    }





}
