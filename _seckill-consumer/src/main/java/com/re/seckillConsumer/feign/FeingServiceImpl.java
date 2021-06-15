package com.re.seckillConsumer.feign;

import org.springframework.stereotype.Component;

@Component
public class FeingServiceImpl implements FeignService {
    @Override
    public String seckill() {
        return "test fallback";
    }
}
