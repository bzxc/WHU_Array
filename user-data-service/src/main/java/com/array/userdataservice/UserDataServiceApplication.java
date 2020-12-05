package com.array.userdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yee
 */
@SpringBootApplication
@EnableEurekaClient
public class UserDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserDataServiceApplication.class, args);
    }

}
