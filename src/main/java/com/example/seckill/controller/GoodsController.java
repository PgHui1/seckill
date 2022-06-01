package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.service.GoodsService;
import com.example.seckill.vo.DetailVO;
import com.example.seckill.vo.GoodsVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiahui
 * @since 2022-05-14
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @RequestMapping("/toGoodList")
    public String toLogin(Model model,HttpServletRequest request) {
        Object user = request.getAttribute("user");
        System.out.println(user);
        List<GoodsVO> goods = goodsService.findGoodsVo();
        System.out.println(goods);
        model.addAttribute("goodsList", goods);
        return "goodsList";
    }

    @RequestMapping("/detail/{id}")
    @ResponseBody
    public Object detail(Model model,
                         @PathVariable("id")Long id,
                         HttpServletRequest request
    ) {
        GoodsVO goods = goodsService.findGoodsVobyGoodsId(id);
        Date startDate = goods.getStartDate();
        Date endDate = goods.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int secKillStatus = 0;
        //倒计时
        int remainSeconds = 0;
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime()-nowDate.getTime())/1000);
            // 秒杀已结束
        } else if (nowDate.after(endDate)) {
            secKillStatus = 2;
            remainSeconds = -1;
            // 秒杀中
        } else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        DetailVO detailVo = new DetailVO();
        detailVo.setGoodsVO(goods);
        detailVo.setUser((User)request.getAttribute("user"));
        detailVo.setRemainSeconds(remainSeconds);
        detailVo.setSecKillStatus(secKillStatus);
        return detailVo;
    }

    @RequestMapping("/toDetail/{id}")
    public String toDetail(Model model, @PathVariable("id")Long id) {
        GoodsVO goods = goodsService.findGoodsVobyGoodsId(id);
        Date startDate = goods.getStartDate();
        Date endDate = goods.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int secKillStatus = 0;
        //倒计时
        int remainSeconds = 0;
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime()-nowDate.getTime())/1000);
            // 秒杀已结束
        } else if (nowDate.after(endDate)) {
            secKillStatus = 2;
            remainSeconds = -1;
            // 秒杀中
        } else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("goods",goods);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goodsDetail";
    }


}
