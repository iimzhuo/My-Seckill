package com.re.seckillProvider.myRedis;

public class MyException extends Exception {
    public MyException(){
        super("没有获取到redis分布式锁");
    }
}
