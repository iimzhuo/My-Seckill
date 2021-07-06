package com.re.iimzhuo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 秒杀成功明细表
 * </p>
 *
 * @author iimzhuo
 * @since 2021-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SuccessKilled implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀商品id
     */
    private Long seckillId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 状态标示：-1指无效，0指成功，1指已付款
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
