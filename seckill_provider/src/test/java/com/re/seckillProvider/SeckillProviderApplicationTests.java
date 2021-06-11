package com.re.seckillProvider;

import com.re.seckillProvider.config.SwaggerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SeckillProviderApplicationTests {

    @Autowired
    private SwaggerConfig swaggerConfig;

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        System.out.println(swaggerConfig.getClass().getName());
    }

}
