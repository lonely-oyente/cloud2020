package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Zh
 * @date 2020/11/03 9:57
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8802 {

    public static void main(String[] args) {
          SpringApplication.run(StreamMQMain8802.class, args);
    }
}
