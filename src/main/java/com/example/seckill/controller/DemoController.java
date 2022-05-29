package com.example.seckill.controller;

import com.example.seckill.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @RequestMapping("/hello")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("name","Nihao");
        return  modelAndView;
    }

    @GetMapping("/test")
    @ResponseBody
    public Object test1(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("你好","hello");

        return  new R().message("测试信息").code(10000).data(map);
        //return  "Hello";
    }
}
