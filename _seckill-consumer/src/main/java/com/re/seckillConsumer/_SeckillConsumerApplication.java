package com.re.seckillConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class _SeckillConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(_SeckillConsumerApplication.class, args);
    }

}
