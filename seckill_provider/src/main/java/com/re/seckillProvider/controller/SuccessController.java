package com.re.seckillProvider.controller;

import com.re.seckillProvider.entity.Success_Killed;
import com.re.seckillProvider.service.SuccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/success")
@Api(tags = "Success_Killed 服务提供者")
public class SuccessController {
    @Autowired
    private SuccessService service;  //field injection is not recommended

    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name="Id",value = "成功秒杀ID",required = true,defaultValue = "1000")
    })
    public List<Success_Killed> getKilled(String Id){
        return service.getKilled();
    }
}
