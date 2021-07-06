package com.re;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.re.iimzhuo.mapper")
public class _SeckillProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(_SeckillProviderApplication.class, args);
    }

}
