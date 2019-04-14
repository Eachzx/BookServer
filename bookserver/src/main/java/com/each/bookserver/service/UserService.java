package com.each.bookserver.service;

import com.each.bookserver.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
public interface UserService extends IService<User> {

    /**
     *Explain: 根据用户名称查询用户信息
     * @author zhangxu
     * @date: 2019/4/11
     * @param: String username
     * @return:
     */
    User findUserByUserName(String username);

}
