package com.numpyninja.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.numpyninja.lms.repository")

@ComponentScan(basePackages = {"com.numpyninja.lms","com.numpyninja.lms.controller","com.numpyninja.lms.services"})
public class LmsServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsServicesApplication.class, args);
    }

    @Bean
    public Docket lmsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                 .paths(PathSelectors.any())
                .build();


    }
}