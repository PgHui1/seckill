package com.example.seckill.controller;

import com.example.seckill.mapper.UserMapper;
import com.example.seckill.pojo.User;
import com.example.seckill.service.UserService;
import com.example.seckill.service.impl.GoodsServiceImpl;
import com.example.seckill.service.impl.UserServiceImpl;
import com.example.seckill.utils.R;
import com.example.seckill.vo.LoginVO;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;


@RequestMapping("/login")
@Slf4j
@Api(value = "用户登录模块")
@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @ApiOperation("用户名密码登录")
    @RequestMapping("/doLogin")
    @ResponseBody
    public R doLogin(@Valid LoginVO loginVO, HttpServletRequest request, HttpServletResponse response){

        return userService.login(loginVO,request,response);
    }
}
