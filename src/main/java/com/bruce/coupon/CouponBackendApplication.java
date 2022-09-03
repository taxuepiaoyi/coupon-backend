package com.bruce.coupon;

import com.bruce.coupon.loadbalance.CanaryRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.bruce"})
@EnableDiscoveryClient
@LoadBalancerClient(value = "coupon-template", configuration = CanaryRuleConfiguration.class)
public class CouponBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponBackendApplication.class, args);
    }

}
