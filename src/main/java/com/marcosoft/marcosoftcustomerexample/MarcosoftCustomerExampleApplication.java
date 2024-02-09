package com.marcosoft.marcosoftcustomerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarcosoftCustomerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarcosoftCustomerExampleApplication.class, args);
    }

}
