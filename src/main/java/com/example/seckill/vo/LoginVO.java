package com.example.seckill.vo;



import com.example.seckill.validator.IsMobile;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotNull;


public class LoginVO {


    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;

    public LoginVO() {

    }

    public LoginVO(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
