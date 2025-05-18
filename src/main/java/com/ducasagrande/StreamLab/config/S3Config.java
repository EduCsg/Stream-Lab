package com.ducasagrande.StreamLab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    private final String S3_ACCESS_KEY = System.getenv("S3_ACCESS_KEY");
    private final String S3_SECRET_KEY = System.getenv("S3_SECRET_KEY");

    @Bean
    public S3Client s3Client() {
        StaticCredentialsProvider credentials =
                StaticCredentialsProvider.create(AwsBasicCredentials.create(S3_ACCESS_KEY, S3_SECRET_KEY));

        return S3Client.builder().region(Region.SA_EAST_1).credentialsProvider(credentials).build();
    }

}
