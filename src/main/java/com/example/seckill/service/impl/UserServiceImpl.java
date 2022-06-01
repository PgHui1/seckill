package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.exception.GlobalException;
import com.example.seckill.mapper.UserMapper;
import com.example.seckill.pojo.User;
import com.example.seckill.service.UserService;
import com.example.seckill.utils.*;
import com.example.seckill.vo.LoginVO;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiahui
 * @since 2022-05-14
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    /*用户登录逻辑*/
    @Override
    public R login(LoginVO loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        //通过jsr303的注解，免去了下面的做校验步骤
         /*if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
             return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
         }
         if (!ValidatorUtil.isMobile(mobile)){
             return RespBean.error(RespBeanEnum.MOBILE_ERROR);
         }*/
        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null==user){
            System.out.println("用户不存在");
            throw new GlobalException("用户名不存在",100201);
        }
        //校验密码
        if (!MD5Util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            throw new GlobalException("密码错误",100202);
        }
        /*校验通过后，生成一个凭证*/
        String ticket = UUIDUtil.uuid();
        /*将登录了的用户信息放在redis里，解决分布式session问题*/
        redisTemplate.opsForValue().set("user:" + ticket, JsonUtil.object2JsonStr(user));
        /*在cookie中记录凭证，以后再想访问的话可以先查看cookie对应的用户是否存在*/
        CookieUtil.setCookie(request, response, "userTicket", ticket);

        return R.ok().message("校验通过").code(100200);
    }

    /*根据cookie获取用户*/
    @Override
    public User getByUserTicket(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        log.info("userTicket="+userTicket);
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        String userJson = (String) redisTemplate.opsForValue().get("user:" + userTicket);
        /*浏览器里的cookie值有问题*/
        if (userJson == null){
            Cookie cookie = new Cookie("userTicket", "");
            cookie.setMaxAge(0);
            throw new GlobalException("系统出错，请重试",100203);
        }
        User user = JsonUtil.jsonStr2Object(userJson, User.class);
        if (null != user) {
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return user;
    }

}
