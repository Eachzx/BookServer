package com.each.bookserver.service.impl;

import com.each.bookserver.entity.Permission;
import com.each.bookserver.mapper.PermissionMapper;
import com.each.bookserver.service.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissionById(Integer id) {
        return permissionMapper.findPermissionById(id);
    }
}
