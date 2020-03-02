package com.mrtk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServicesApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServicesApp.class, args);
    }
}
