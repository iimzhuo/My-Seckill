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

    /**
     * redis分布式秒杀
     * @param seckill_id 商品id
     * @return 是否秒杀成功
     */
    Boolean startSeckill(Long seckill_id);

    /**
     * 数据库乐观锁实现秒杀
     * @param seckill_id 商品id
     * @return 是否秒杀成功
     */
    Boolean startSeckillOp(Long seckill_id);

    /**
     * redis分布式锁秒杀
     * @param seckill_id
     * @return
     */
    Boolean startRedisSeckill(Long seckill_id);

    /**
     * 重置秒杀数量
     * @param seckill_id 商品id
     */
    void resetNum(Long seckill_id);

    /**
     * 获取秒杀结果，现存多少件，秒杀多少件
     * @param seckill_id 商品id
     * @return 秒杀结果
     */
    String getResult(Long seckill_id);
}