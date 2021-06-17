package com.re.seckillProvider.aop;

import java.lang.annotation.*;

/**
 * 切面注解
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceLock {
    String des() default "";
}
