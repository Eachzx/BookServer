package com.each.bookserver.mapper;

import com.each.bookserver.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

    /**
     *Explain: 根据用户名称查询用户信息
     * @author zhangxu
     * @date: 2019/4/11
     * @param: String username
     * @return:
     */
    User findUserByUserName(String username);
}
