package com.example.seckill.mapper;

import com.example.seckill.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.vo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jiahui
 * @since 2022-05-14
 */

public interface GoodsMapper extends BaseMapper<Goods> {
    List<GoodsVO> findGoodsVo();

    GoodsVO findGoodsVobyGoodsId(Long goodsId);
}
