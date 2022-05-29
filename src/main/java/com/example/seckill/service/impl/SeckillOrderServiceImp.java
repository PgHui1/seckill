package com.example.seckill.service.impl;

import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.mapper.SeckillOrderMapper;
import com.example.seckill.service.SeckillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀订单表 服务实现类
 * </p>
 *
 * @author jiahui
 * @since 2022-05-24
 */
@Service
public class SeckillOrderServiceImp extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements SeckillOrderService {

}
