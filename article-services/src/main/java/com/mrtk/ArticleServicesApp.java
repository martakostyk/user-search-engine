package com.mrtk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArticleServicesApp {
    public static void main(String[] args) {
        SpringApplication.run(ArticleServicesApp.class, args);
    }
}
