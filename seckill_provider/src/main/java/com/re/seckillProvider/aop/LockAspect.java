package com.re.seckillProvider.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@Aspect
@Scope
@Order(1)//数字越小，越先执行，并且最后结束，用于事务开始前上锁，事务结束后释放锁
public class LockAspect {

    private static  Lock lock=new ReentrantLock(true);

    /**
     * 定义好切入点
     */
    @Pointcut("@annotation(com.re.seckillProvider.aop.ServiceLock)")
    public void LockAop(){}

    /**
     * 环绕方法
     * @param joinPoint 切入点
     */
    @Around("LockAop()")
    public void Around(ProceedingJoinPoint joinPoint){
        lock.lock();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
