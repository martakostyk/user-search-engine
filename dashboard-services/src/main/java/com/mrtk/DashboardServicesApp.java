package com.mrtk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = {
        com.mrtk.client.UserServicesClient.class,
        com.mrtk.client.ArticleServicesClient.class})
public class DashboardServicesApp {
    public static void main(String[] args) {
        SpringApplication.run(DashboardServicesApp.class);
    }
}
