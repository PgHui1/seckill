package com.example.seckill.interceptores;

import com.example.seckill.pojo.User;
import com.example.seckill.service.UserService;
import com.example.seckill.utils.CookieUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        if (null == cookies){
            System.out.println("准备转发");
            request.getRequestDispatcher("/login/toLogin").forward(request,response);
            return false;
        }

        for (Cookie cookieItem:cookies) {
            System.out.println(cookieItem.getName());
            if ("userTicket".equals(cookieItem.getName())){
                cookie = cookieItem;
            }
        }
        if (null == cookie){
            System.out.println("准备转发");
            request.getRequestDispatcher("/login/toLogin").forward(request,response);
            return false;
        }
        System.out.println(cookie.getValue());


        User user = userService.getByUserTicket(cookie.getValue(), request, response);
        if (null == user){
            request.getRequestDispatcher("/login/toLogin").forward(request,response);
            return false;
        }
        request.setAttribute("user",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
