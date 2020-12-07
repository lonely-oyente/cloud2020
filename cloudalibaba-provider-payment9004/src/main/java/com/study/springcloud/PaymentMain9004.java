package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zh
 * @date 2020/12/05 15:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9004 {
    
    public static void main(String[] args) {
          SpringApplication.run(PaymentMain9004.class, args);
    }
}
