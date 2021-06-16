package com.re.seckillProvider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

@Data
public class Seckill {
    @TableId(value="seckill_id",type= IdType.AUTO)
    private Long seckill_id;

    private String name;

    private Integer number;

    private Date start_time;

    private Date end_time;

    private Date create_time;

    private Integer version;
}
