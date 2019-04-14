package com.each.bookserver.service.impl;

import com.each.bookserver.entity.User;
import com.each.bookserver.mapper.UserMapper;
import com.each.bookserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *Explain: 根据用户名称查询用户信息
     * @author zhangxu
     * @date: 2019/4/11
     * @param: String username
     * @return:
     */
    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }
}
