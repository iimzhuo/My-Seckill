package com.re.seckillProvider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@Api(tags = "Seckill 服务提供者")
public class ProviderController {

    @GetMapping
    @ApiOperation("Seckill 秒杀接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value ="秒杀id",defaultValue = "1000",required = true)
    })
    public String Seckill(String id){
        System.out.println("i im 9090 seckill provider"+id);
        return "9090";
    }
}
