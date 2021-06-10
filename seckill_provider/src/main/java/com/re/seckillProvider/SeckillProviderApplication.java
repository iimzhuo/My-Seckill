package com.re.seckillProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class SeckillProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProviderApplication.class, args);
    }

}
