package com.example.seckill.service;

import com.example.seckill.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.utils.R;
import com.example.seckill.vo.LoginVO;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiahui
 * @since 2022-05-14
 */
public interface UserService extends IService<User> {

    public R login(LoginVO loginVo, HttpServletRequest request, HttpServletResponse response);
    User getByUserTicket(String userTicket,HttpServletRequest request,HttpServletResponse response);

}
