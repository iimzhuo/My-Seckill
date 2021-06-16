package com.re.seckillProvider.service;

import com.re.seckillProvider.entity.Seckill;

import java.util.List;

public interface SeckillService {
    List<Seckill> getProduct(Integer seckill_id);
}
