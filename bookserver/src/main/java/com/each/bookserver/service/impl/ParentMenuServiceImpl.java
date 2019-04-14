package com.each.bookserver.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.each.bookserver.entity.ParentMenu;
import com.each.bookserver.mapper.ParentMenuMapper;
import com.each.bookserver.service.ParentMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
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
public class ParentMenuServiceImpl extends ServiceImpl<ParentMenuMapper, ParentMenu> implements ParentMenuService {

    @Autowired
    private ParentMenuMapper parentMenuMapper;
    @Override
    public List<ParentMenu> findParentMenuById(Integer id) {
        return parentMenuMapper.findParentMenuById(id);
    }


}
