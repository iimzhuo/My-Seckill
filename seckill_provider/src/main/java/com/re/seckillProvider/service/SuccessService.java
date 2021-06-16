package com.re.seckillProvider.service;

import com.re.seckillProvider.entity.Success_Killed;

import java.util.List;

public interface SuccessService {
    /**
     * 查看所有成功秒杀的商品数
     * @return  返回所有秒杀成功的商品
     */
    List<Success_Killed> getKilled();
}
