package com.each.bookserver.service.impl;

import com.each.bookserver.entity.ChildMenu;
import com.each.bookserver.mapper.ChildMenuMapper;
import com.each.bookserver.service.ChildMenuService;
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
public class ChildMenuServiceImpl extends ServiceImpl<ChildMenuMapper, ChildMenu> implements ChildMenuService {

    @Autowired
    private ChildMenuMapper childMenuMapper;

    /**
     *Explain: 根据父级菜单查询子菜单列表
     * @author zhangxu
     * @date: 2019/4/13
     * @param:    Integer id
     * @return:  List<ChildMenu>
     */
    @Override
    public List<ChildMenu> findListChildMenuById(Integer parent_menu_id) {
        return childMenuMapper.findListChildMenuById(parent_menu_id);
    }
}
