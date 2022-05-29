package com.example.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiahui
 * @since 2022-05-14
 */
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id,手机号码")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String nickname;

    @ApiModelProperty("密码，两次md5加密")
    private String password;

    @ApiModelProperty("加盐")
    private String salt;

    @ApiModelProperty("头像地址")
    private String head;

    @ApiModelProperty("注册时间")
    private LocalDateTime registerDate;

    @ApiModelProperty("最后一次登录时间")
    private LocalDateTime lastLoginDate;

    @ApiModelProperty("登录次数")
    private Integer loginCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", nickname=" + nickname +
            ", password=" + password +
            ", salt=" + salt +
            ", head=" + head +
            ", registerDate=" + registerDate +
            ", lastLoginDate=" + lastLoginDate +
            ", loginCount=" + loginCount +
        "}";
    }
}
