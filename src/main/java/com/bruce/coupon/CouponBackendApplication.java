package com.bruce.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bruce"})
public class CouponBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponBackendApplication.class, args);
    }

}
