package org.acaree.core.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@Getter
@Slf4j
public class S3Config {

    @Value("${S3_BUCKET_NAME}")
    private String bucketName;

    @Value("${AWS_REGION}")
    private String region;

    @Bean
    public S3Client s3Client(){
        return S3Client.builder()
                .region(Region.of(region))
                .build();
    }
}