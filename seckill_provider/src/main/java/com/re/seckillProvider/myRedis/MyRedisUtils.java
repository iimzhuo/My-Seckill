package com.re.seckillProvider.myRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class MyRedisUtils {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取redis分布式锁
     * @param key   key
     * @param value  value
     * @return   是否获取到锁
     */
    public Boolean lock(String key,String value){
        //if(key.equals("1000")) return false;
        //当key没有对应的value时，说明获取锁成功
        if(redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        //超时处理
        String cur_value = redisTemplate.opsForValue().get(key);
        if(!getStr(cur_value).equals("")&&Long.parseLong(cur_value)>System.currentTimeMillis()){
            //为了防止多个线程同时获取到锁，即多个线程lock方法返回的结果都是true
            String old_value = redisTemplate.opsForValue().getAndSet(key, value);
            if(!getStr(old_value).equals("")&&old_value.equals(cur_value)){
                return true;
            }
        }
        return false;
    }

    /**
     * 释放redis分布式锁
     * @param key key
     * @param value value
     * Ctrl+Alt+T  try catch 快捷键
     */
    public void  unlock(String key,String value){
        try {
            if(getStr(redisTemplate.opsForValue().get(key)).equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getStr(String str){
        if(str==null) return "";
        else return str;
    }
}
