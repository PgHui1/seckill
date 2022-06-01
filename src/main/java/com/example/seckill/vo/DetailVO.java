package com.example.seckill.vo;

import com.example.seckill.pojo.User;

public class DetailVO {
    private User user;
    private GoodsVO goodsVO;
    private int secKillStatus;
    private int remainSeconds;

    public DetailVO() {
    }

    public DetailVO(User user, GoodsVO goodsVO, int secKillStatus, int remainSeconds) {
        this.user = user;
        this.goodsVO = goodsVO;
        this.secKillStatus = secKillStatus;
        this.remainSeconds = remainSeconds;
    }

    @Override
    public String toString() {
        return "DetailVO{" +
                "user=" + user +
                ", goodsVO=" + goodsVO +
                ", secKillStatus=" + secKillStatus +
                ", remainSeconds=" + remainSeconds +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GoodsVO getGoodsVO() {
        return goodsVO;
    }

    public void setGoodsVO(GoodsVO goodsVO) {
        this.goodsVO = goodsVO;
    }

    public int getSecKillStatus() {
        return secKillStatus;
    }

    public void setSecKillStatus(int secKillStatus) {
        this.secKillStatus = secKillStatus;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }
}
