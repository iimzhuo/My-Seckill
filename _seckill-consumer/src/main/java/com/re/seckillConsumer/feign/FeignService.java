package com.re.seckillConsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "seckill-provider",fallback = FeingServiceImpl.class)
public interface FeignService {
    @GetMapping("/provider/{id}")
    String seckill(@PathVariable("id") String id);
}
