package com.re.seckillProvider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="success_killed")
public class Success_Killed {
    @TableId
    private Long seckill_id;

    private Long user_id;

    private Integer state;

    private Date create_time;
}
