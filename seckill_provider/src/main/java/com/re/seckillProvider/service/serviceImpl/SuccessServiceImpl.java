package com.re.seckillProvider.service.serviceImpl;

import com.re.seckillProvider.entity.Success_Killed;
import com.re.seckillProvider.mapper.SuccessKillMapper;
import com.re.seckillProvider.service.SuccessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SuccessServiceImpl implements SuccessService {

    @Resource
    private SuccessKillMapper mapper;

    @Override
    public List<Success_Killed> getKilled() {
        return mapper.selectList(null);
    }
}
