package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Zh
 * @date 2020/12/07 10:51
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountMainApp2003 {
    public static void main(String[] args) {
          SpringApplication.run(SeataAccountMainApp2003.class, args);
    }
}
