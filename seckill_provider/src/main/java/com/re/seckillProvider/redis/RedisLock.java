package com.re.seckillProvider.redis;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLock {
    String value() default "1000";
}
