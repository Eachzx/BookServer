package com.each.bookserver.mapper;

import com.each.bookserver.entity.Role;
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
public interface RoleMapper extends BaseMapper<Role> {

    /**
     *Explain: 更具用户的ID查询角色
     * @author zhangxu
     * @date: 2019/4/11
     * @param: String id
     * @return: List<Role>
     */
   List<Role> findRoleById(@Param("id") Integer id);
}
