package com.re.seckillProvider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.re.seckillProvider.mapper")
public class SeckillProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProviderApplication.class, args);
    }
}
