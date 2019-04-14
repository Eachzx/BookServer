package com.each.bookserver.service;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.each.bookserver.entity.ParentMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
public interface ParentMenuService extends IService<ParentMenu> {

    /**
     *Explain: 根据权限id查询菜单集合
     * @author zhangxu
     * @date: 2019/4/12
     * @param:  Integer id
     * @return: List<ParentMenu>
     */
    List<ParentMenu> findParentMenuById(@Param("id") Integer id);





}
