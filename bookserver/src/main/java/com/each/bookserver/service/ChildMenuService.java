package com.each.bookserver.service;

import com.each.bookserver.entity.ChildMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
public interface ChildMenuService extends IService<ChildMenu> {

    /**
     *Explain: 根据父级菜单查询子菜单列表
     * @author zhangxu
     * @date: 2019/4/13
     * @param:    Integer id
     * @return:  List<ChildMenu>
     */
    List<ChildMenu> findListChildMenuById(@Param("id") Integer parentMenuId);

}
