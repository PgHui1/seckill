package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *s
 * @author jiahui
 * @since 2022-05-14
 */

public interface UserMapper extends BaseMapper<User> {
    public List<User> testSql();
}

