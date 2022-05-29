package com.example.seckill.service;

import com.example.seckill.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.GoodsVo;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author jiahui
 * @since 2022-05-24
 */
public interface OrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);
}
