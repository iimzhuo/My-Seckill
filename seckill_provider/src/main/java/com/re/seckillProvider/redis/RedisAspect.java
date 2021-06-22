package com.re.seckillProvider.redis;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Scope
@Order(1)
/**
 * redis切面锁切面
 */
@Slf4j
public class RedisAspect {

    @Autowired
    private RedissonUtils redissonUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.re.seckillProvider.redis.RedisLock)")
    public void LockAspect(){}

    @Around("LockAspect()")
    public void Around(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        String seckill_id=args[0].toString();
        Boolean _lock = redissonUtils.Lock(seckill_id);
        if(_lock){
                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }finally {
                    redissonUtils.unLock(seckill_id);
                }
        }else{
            log.info("没有取得锁");
        }
    }
}
