package com.re.seckillProvider.myRedis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 自定义redis分布式切面锁
 */
@Aspect
@Component
@Scope
@Order(1)
public class MyRedisAspect {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MyRedisUtils redisUtils;

    @Pointcut("@annotation(com.re.seckillProvider.myRedis.MyRedisLock)")
    public void LockAspect(){}

    @Around("LockAspect()")
    public void Around(ProceedingJoinPoint joinPoint) throws MyException {
        Object[] args = joinPoint.getArgs();
        String seckill_id = args[0].toString();//获取秒杀接口上的参数
        long l = System.currentTimeMillis();
        if(redisUtils.lock(seckill_id,String.valueOf(l))){
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }finally {
                redisUtils.unlock(seckill_id,String.valueOf(l));
            }
        }else{
            throw new MyException();
        }
    }

}
