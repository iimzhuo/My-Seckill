package com.re.seckillProvider.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.re.seckillProvider.aop.ServiceLock;
import com.re.seckillProvider.entity.Seckill;
import com.re.seckillProvider.entity.Success_Killed;
import com.re.seckillProvider.mapper.SeckillMapper;
import com.re.seckillProvider.mapper.SuccessKillMapper;
import com.re.seckillProvider.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SeckillServiceImpl implements SeckillService{

    @Resource
    private SeckillMapper seckillMapper;

    @Resource
    private SuccessKillMapper successKillMapper;

    private static Long user_id=1L;

    @Override
    public List<Seckill> getProduct(Integer seckill_id) {
        return seckillMapper.selectList(null);
    }

    /**
     * 通过加入aop切面锁，保证分布式环境下线程安全性,此秒杀为单机秒杀
     * ab -n 200 -c 30 -u D:\a.txt http://localhost:9093/provider/1000  将近9s
     */
    @Override
    @ServiceLock
    @Transactional
    public Boolean startSeckill(Long seckill_id) {
        int total=seckillMapper.getTotal(seckill_id);
        //性能太差，每次都查询一个对象
        /*QueryWrapper<Seckill> wrapper=new QueryWrapper<>();
        wrapper.eq("seckill_id",seckill_id);
        int total=seckillMapper.selectOne(wrapper).getNumber();*/
        if(total>0){
            //库存减一
            seckillMapper.Release(seckill_id);
            log.info("商品库存减一{}",seckill_id);
            //新增成功秒杀商品
            Success_Killed success_killed=new Success_Killed();
            success_killed.setSeckill_id(seckill_id);
            success_killed.setState(1);
            success_killed.setUser_id(user_id++);
            successKillMapper.insert(success_killed);
            log.info("秒杀成功");
        }else{
            return false;
        }
        return true;
    }

    /**
     * 重置秒杀数量
     * @param seckill_id 商品id
     */
    @Override
    public void resetNum(Long seckill_id) {
        Seckill seckill=new Seckill();
        seckill.setSeckill_id(seckill_id);
        seckill.setNumber(100);
        //更新秒杀商品的数量
        seckillMapper.updateById(seckill);
        successKillMapper.delete(new QueryWrapper<Success_Killed>().eq("seckill_id",seckill_id));
    }

    @Override
    public String getResult(Long seckill_id) {
        //int current_num=seckillMapper.getTotal(seckill_id);
        QueryWrapper<Seckill> wrapper=new QueryWrapper<>();
        wrapper.eq("seckill_id",seckill_id);
        int current_num=seckillMapper.selectOne(wrapper).getNumber();
        //int success_num=successKillMapper.getTotal(seckill_id);
        QueryWrapper<Success_Killed> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("seckill_id",seckill_id);
        Integer success_num = successKillMapper.selectCount(queryWrapper);
        return "目前剩余商品数为："+current_num+"，成功秒杀的商品数为："+success_num;
    }
}
