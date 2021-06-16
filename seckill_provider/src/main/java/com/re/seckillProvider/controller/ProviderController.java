package com.re.seckillProvider.controller;

import com.re.seckillProvider.entity.Seckill;
import com.re.seckillProvider.service.SeckillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
@Api(tags = "Seckill 服务提供者")
public class ProviderController {
    @Autowired
    private SeckillService seckillService;

    @GetMapping
    @ApiOperation("Seckill 秒杀接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value ="秒杀id",defaultValue = "1000",required = true)
    })
    public List<Seckill> Seckill(String id){
        System.out.println("i im 9093 seckill provider"+id);
        return seckillService.getProduct(Integer.parseInt(id));
    }
}
