package com.re.seckillProvider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.re.seckillProvider.mapper")
@EnableAspectJAutoProxy
public class SeckillProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProviderApplication.class, args);
    }
}
