package com.array.coursedataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseDataServiceApplication.class, args);
    }

}
