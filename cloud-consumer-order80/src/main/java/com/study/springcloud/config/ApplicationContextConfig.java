package com.study.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zh
 * @date 2020/10/21 16:30
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 配置负载均衡@LoadBalance，默认的是轮询方式
     *
     * @return
     */
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
