package io.vladprotchenko.recipientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RecipientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipientServiceApplication.class, args);
    }

}
