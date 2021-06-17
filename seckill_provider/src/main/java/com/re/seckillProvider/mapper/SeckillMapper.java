package com.re.seckillProvider.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.re.seckillProvider.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface SeckillMapper extends BaseMapper<Seckill> {
    @Update("update seckill set number=number-1 where seckill_id = #{seckill_id}")
    void Release(@Param("seckill_id") Long seckill_id);
}
