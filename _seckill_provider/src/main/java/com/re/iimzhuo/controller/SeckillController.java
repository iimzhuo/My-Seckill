package com.re.iimzhuo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.re.iimzhuo.entity.SuccessKilled;
import com.re.iimzhuo.mapper.SuccessKilledMapper;
import com.re.iimzhuo.service.ISeckillService;
import com.re.iimzhuo.service.ISuccessKilledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 秒杀库存表 前端控制器
 * </p>
 *
 * @author iimzhuo
 * @since 2021-07-06
 */
@RestController
@RequestMapping("/iimzhuo/seckill")
public class SeckillController {

    @Autowired
    private SuccessKilledMapper mapper;

    @Autowired
    private ISuccessKilledService service;

    @GetMapping
    public List<SuccessKilled> selectPage(){
        Page<SuccessKilled> page=new Page<>(1,10);
        Page<SuccessKilled> successKilledPage = mapper.selectPage(page, null);
        List<SuccessKilled> records = successKilledPage.getRecords();
        Page<SuccessKilled> page1 = service.page(new Page<>(2,10), null);
        List<SuccessKilled> records1 = page1.getRecords();
        return records1;
    }
}
