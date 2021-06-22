package com.re.seckillProvider.myRedis;

import java.lang.annotation.*;

/**
 * 自定义redis分布式锁注解
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRedisLock {
}
