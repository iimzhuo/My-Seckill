package com.re.seckillProvider.service;

import com.re.seckillProvider.entity.Seckill;

import java.util.List;

public interface SeckillService {
    /**
     * 查看所有的秒杀商品
     * @param seckill_id  商品的id
     * @return  所有待秒杀的商品
     */
    List<Seckill> getProduct(Integer seckill_id);
}