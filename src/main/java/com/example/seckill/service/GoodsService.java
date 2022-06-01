package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiahui
 * @since 2022-05-14
 */
public interface GoodsService extends IService<Goods> {


    List<GoodsVO> findGoodsVo();

    GoodsVO findGoodsVobyGoodsId(Long goodsId);
}
