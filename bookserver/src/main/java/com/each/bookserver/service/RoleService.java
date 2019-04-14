package com.each.bookserver.service;

import com.each.bookserver.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
public interface RoleService extends IService<Role> {

    /**
     *Explain: 更具用户的ID查询角色
     * @author zhangxu
     * @date: 2019/4/11
     * @param: String id
     * @return: List<Role>
     */
    List<Role> findRoleById(@Param("id") Integer id);
}
