package com.re.seckillProvider.service.serviceImpl;

import com.re.seckillProvider.entity.Seckill;
import com.re.seckillProvider.mapper.SeckillMapper;
import com.re.seckillProvider.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SeckillServiceImpl implements SeckillService{

    @Resource
    private SeckillMapper seckillMapper;

    @Override
    public List<Seckill> getProduct(Integer seckill_id) {
        return seckillMapper.selectList(null);
    }
}
