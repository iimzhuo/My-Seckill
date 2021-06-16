package com.re.seckillProvider.controller;

import com.re.seckillProvider.entity.Seckill;
import com.re.seckillProvider.service.SeckillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
@Api(tags = "Seckill 服务提供者")
public class ProviderController {
    @Autowired
    private SeckillService seckillService;

    @GetMapping("/{id}")
    @ApiOperation("Seckill,查看所有待秒杀商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value ="秒杀id",defaultValue = "1000",required = true)
    })
    public List<Seckill> Seckill(@PathVariable String id){
        System.out.println("port:9093,id为"+id+"商品查询成功");
        return seckillService.getProduct(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Seckill,开始秒杀 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商品id",defaultValue = "1000",required = true)
    })
    public Boolean startSeckil(@PathVariable String id){
        return seckillService.startSeckill(Long.parseLong(id));
    }

    @PutMapping("/reset/{id}")
    @ApiOperation(value = "Seckill,重置秒杀数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id",value = "商品id",defaultValue = "1000",required = true)
    })
    public String resetNum(@PathVariable String id){
        seckillService.resetNum(Long.parseLong(id));
        return "reset success";
    }
}
