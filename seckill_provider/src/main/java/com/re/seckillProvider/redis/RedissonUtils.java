package com.re.seckillProvider.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

public class RedissonUtils {

    private RedissonClient redisson;

    public void setRedisson(RedissonClient redisson) {
        this.redisson = redisson;
    }

    /**
     * 获取redis分布式锁
     * @param seckill_id 秒杀id
     */
    public Boolean Lock(String seckill_id){
        RLock _lock = redisson.getLock(seckill_id);
        try {
            return _lock.tryLock(3, 20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    /**
     * 释放redis分布式锁
     * @param seckill_id 秒杀id
     */
    public void unLock(String seckill_id){
        RLock lock = redisson.getLock(seckill_id);
        lock.unlock();
    }
}
