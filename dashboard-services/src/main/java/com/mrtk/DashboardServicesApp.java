package com.mrtk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients(basePackageClasses = {
        com.mrtk.client.UserServicesClient.class,
        com.mrtk.client.ArticleServicesClient.class})
public class DashboardServicesApp {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("dashboard").select()
                .apis(RequestHandlerSelectors.basePackage("com.mrtk"))
                .paths(any()).build().apiInfo(new ApiInfo("Dashboard Services",
                        "A set of services to provide data access to dashboard with articles", "1.0.0", null,
                        new Contact("Marta Kostyk", "https://github.com/martakostyk", null),null, null));
    }

    public static void main(String[] args) {
        SpringApplication.run(DashboardServicesApp.class);
    }
}
