package com.example.seckill.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.seckill.pojo.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("商品返回对象")
public class GoodsVo {

    @ApiModelProperty("商品id")
    private Long id;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品标题")
    private String goodsTitle;

    @ApiModelProperty("商品图片")
    private String goodsImg;

    @ApiModelProperty("商品描述")
    private String goodsDetail;

    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty("秒杀价格")
    private BigDecimal seckillPrice;

    @ApiModelProperty("剩余数量")
    private Integer stockCount;


    @ApiModelProperty("开始时间")
    private Date startDate;


    @ApiModelProperty("结束时间")
    private Date endDate;

    public GoodsVo() {
    }

    public GoodsVo(Long id, String goodsName, String goodsTitle, String goodsImg, String goodsDetail, BigDecimal goodsPrice, BigDecimal seckillPrice, Integer stockCount, Date startDate, Date endDate) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsTitle = goodsTitle;
        this.goodsImg = goodsImg;
        this.goodsDetail = goodsDetail;
        this.goodsPrice = goodsPrice;
        this.seckillPrice = seckillPrice;
        this.stockCount = stockCount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(BigDecimal seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", seckillPrice=" + seckillPrice +
                ", stockCount=" + stockCount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}