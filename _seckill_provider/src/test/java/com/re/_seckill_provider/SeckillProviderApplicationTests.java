package com.re._seckill_provider;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.re.iimzhuo.entity.SuccessKilled;
import com.re.iimzhuo.mapper.SuccessKilledMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SeckillProviderApplicationTests {

    @Autowired
    private SuccessKilledMapper mapper;
    @Test
    void contextLoads() {
        Page<SuccessKilled> successKilledPage = mapper.selectPage(new Page<>(1, 10), null);
        List<SuccessKilled> records = successKilledPage.getRecords();
        for(SuccessKilled item:records){
            System.out.println(item);
        }
    }

}
