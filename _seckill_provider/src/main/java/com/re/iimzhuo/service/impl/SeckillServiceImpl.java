package com.re.iimzhuo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.re.iimzhuo.entity.Seckill;
import com.re.iimzhuo.mapper.SeckillMapper;
import com.re.iimzhuo.service.ISeckillService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀库存表 服务实现类
 * </p>
 *
 * @author iimzhuo
 * @since 2021-07-06
 */
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill> implements ISeckillService {

}
