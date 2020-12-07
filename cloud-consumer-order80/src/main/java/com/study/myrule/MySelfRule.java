package com.study.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zh
 * @date 2020/10/22 13:19
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
