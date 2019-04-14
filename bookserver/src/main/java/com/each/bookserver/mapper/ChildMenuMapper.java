package com.each.bookserver.mapper;

import com.each.bookserver.entity.ChildMenu;
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
public interface ChildMenuMapper extends BaseMapper<ChildMenu> {

    /**
     *Explain: 根据父级菜单查询子菜单列表
     * @author zhangxu
     * @date: 2019/4/13
     * @param:    Integer id
     * @return:  List<ChildMenu>
     */
    List<ChildMenu> findListChildMenuById(@Param("id") Integer id);

}
