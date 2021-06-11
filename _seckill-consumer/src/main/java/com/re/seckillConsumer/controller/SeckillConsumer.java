package com.re.seckillConsumer.controller;

import com.re.seckillConsumer.feign.FeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Seckill")
@Api(tags = "Seckill Consumer  Feign服务消费者")
public class SeckillConsumer {
    @Autowired
    private FeignService feignService;

    @GetMapping
    @ApiOperation("Seckill 秒杀服务消费者接口")
    public String Seckill(){
        return feignService.seckill();
    }
}
