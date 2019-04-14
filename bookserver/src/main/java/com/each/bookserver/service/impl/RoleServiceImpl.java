package com.each.bookserver.service.impl;

import com.each.bookserver.entity.Role;
import com.each.bookserver.mapper.RoleMapper;
import com.each.bookserver.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    /**
     *Explain: 更具用户的ID查询角色
     * @author zhangxu
     * @date: 2019/4/11
     * @param: String id
     * @return: List<Role>
     */
    @Override
    public List<Role> findRoleById(Integer id) {
        List<Role> roles=roleMapper.findRoleById(id);
        return roles;
    }
}
