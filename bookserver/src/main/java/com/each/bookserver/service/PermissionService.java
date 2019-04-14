package com.each.bookserver.service;

import com.each.bookserver.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
public interface PermissionService extends IService<Permission> {

    /**
     *Explain: 关联查询根据角色的Id查询出角色对应的权限
     * @author zhangxu
     * @date: 2019/4/12
     * @param:  Integer id
     * @return: Permission
     */
    List<Permission> findPermissionById(Integer id);

}
