package com.re.seckillProvider;

import com.re.seckillProvider.config.SwaggerConfig;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeckillProviderApplicationTests {

    @Autowired
    private SwaggerConfig swaggerConfig;

    @Test
    void contextLoads() {
        System.out.println(swaggerConfig.getClass().getName());
    }

}
