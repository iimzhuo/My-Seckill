package com.re.seckillConsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "seckill-provider")
public interface FeignService {
    @GetMapping("/provider")
    String seckill();
}