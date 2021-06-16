package com.re.seckillProvider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Success_Killed {
    @TableId
    private Long seckill_id;
    @TableId
    private Long user_id;

    private Integer state;

    private Date create_time;
}
