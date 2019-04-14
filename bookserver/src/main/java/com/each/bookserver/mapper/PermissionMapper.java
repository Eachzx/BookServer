package com.each.bookserver.mapper;

import com.each.bookserver.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     *Explain: 关联查询根据角色的Id查询出角色对应的权限
     * @author zhangxu
     * @date: 2019/4/12
     * @param:  Integer id
     * @return: Permission
     */
    List<Permission> findPermissionById(@Param("id") Integer id);

}
