package com.re.seckillProvider.redis;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RedisAutoConfiguration {
    /**
     * 返回redis分布式锁工具类，用于获取和释放分布式锁
     * @return
     */
    @Bean
    public RedissonUtils lock(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://150.158.156.214:6379")
                .setPassword("test123")
                .setConnectionMinimumIdleSize(10);
        RedissonUtils utils=new RedissonUtils();
        utils.setRedisson(Redisson.create(config));
        return utils;
    }
}
