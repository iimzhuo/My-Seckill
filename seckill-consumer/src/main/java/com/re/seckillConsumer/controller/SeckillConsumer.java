package com.re.seckillConsumer.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Seckill-Consumer")
@Api(tags = "Seckill-Consumer 服务消费者")
public class SeckillConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping
    public String getProduct(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("seckill_provider");
        String url = String.format("http://%s:%s/%s", serviceInstance.getHost(), serviceInstance.getPort(), "provider");
        return restTemplate.getForObject(url, String.class);
    }
}
