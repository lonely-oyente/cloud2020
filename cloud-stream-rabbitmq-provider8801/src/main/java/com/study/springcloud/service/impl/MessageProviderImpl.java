package com.study.springcloud.service.impl;

import com.study.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 定义消息的推送管道 @EnableBinding(Source.class)
 *
 * @author Zh
 * @date 2020/11/03 9:09
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString().substring(0, 8);
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("----serial: " + serial);
        return serial;
    }
}
