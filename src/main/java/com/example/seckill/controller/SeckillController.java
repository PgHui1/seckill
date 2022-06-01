package com.example.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.User;
import com.example.seckill.service.GoodsService;
import com.example.seckill.service.OrderService;
import com.example.seckill.service.SeckillOrderService;
import com.example.seckill.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;
    @Autowired
    SeckillOrderService seckillOrderService;

    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, HttpServletRequest request, Long goodsId){
        GoodsVO goods = goodsService.findGoodsVobyGoodsId(goodsId);
        if (goods == null){
            model.addAttribute("errmsg", "错误数据");
            return "seckillFail";
        }
        /*库存判断*/
        if (goods.getStockCount()<1){
            model.addAttribute("errmsg", "商品已经卖完了");
            return "seckillFail";
        }
        User user = (User)request.getAttribute("user");
       /* 重复抢购判断*/
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getId())
                        .eq("goods_id",goodsId);

        Order one = orderService.getOne(queryWrapper);
        if (one != null){
            model.addAttribute("errmsg","很抱歉，不能重复抢购");
            return "seckillFail";
        }
        orderService.seckill(user,goods);
        return "seckillFail";

    }

}
