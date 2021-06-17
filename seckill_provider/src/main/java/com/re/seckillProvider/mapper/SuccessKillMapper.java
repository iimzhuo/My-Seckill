package com.re.seckillProvider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.re.seckillProvider.entity.Success_Killed;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SuccessKillMapper extends BaseMapper<Success_Killed> {
    /*@Select("select count(0) from success_killed where seckill_id = #{seckill_id}")
    int getTotal(@Param("seckill_id") Long seckill_id);*/
}

