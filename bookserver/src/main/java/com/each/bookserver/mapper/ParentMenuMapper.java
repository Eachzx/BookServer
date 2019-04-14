package com.each.bookserver.mapper;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.each.bookserver.entity.ParentMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.Wrapper;
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
public interface ParentMenuMapper extends BaseMapper<ParentMenu> {

    /**
     *Explain: 根据权限id查询菜单集合
     * @author zhangxu
     * @date: 2019/4/12
     * @param:  Integer id
     * @return: List<ParentMenu>
     */
    List<ParentMenu> findParentMenuById(@Param("id") Integer id);




}
