package com.example.seckill.config;

import com.example.seckill.pojo.User;
import com.example.seckill.service.UserService;
import com.example.seckill.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;
    /*当该方法为true才会执行下面一段*/
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeRequest(HttpServletResponse.class);
        String userTicket = CookieUtil.getCookieValue(request, "userTicket");
        if (StringUtils.isEmpty(userTicket)){
            return  null;
        }

        return userService.getByUserTicket(userTicket,request,response);
    }
}
