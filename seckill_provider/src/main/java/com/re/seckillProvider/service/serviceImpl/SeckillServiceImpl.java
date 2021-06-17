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

    /**
     * 通过加入aop切面锁，保证分布式环境下线程安全性
     */
    @Override
    public Boolean startSeckill(Long seckill_id) {


        return true;
    }

    @Override
    public void resetNum(Long seckill_id) {
        Seckill seckill=new Seckill();
        seckill.setSeckill_id(seckill_id);
        seckill.setNumber(100);
        //更新秒杀商品的数量
        seckillMapper.updateById(seckill);
    }
}
