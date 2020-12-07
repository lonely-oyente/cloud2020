package com.study.springcloud.controller;

import com.study.springcloud.entity.CommonResult;
import com.study.springcloud.entity.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Zh
 * @date 2020/10/21 15:45
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult<Integer> add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("====>插入结果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功,serverPort：" + serverPort, result);
        }
        return new CommonResult<>(999, "插入数据库失败");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("====>查询结果：" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort：" + serverPort, payment);
        }
        return new CommonResult<>(999, "没有对应记录");
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("===service===" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()
                    + "\t" + instance.getHost()
                    + "\t" + instance.getPort()
                    + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "paymentZipkin server";
    }
}
