package com.each.bookserver.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.each.bookserver.entity.ChildMenu;
import com.each.bookserver.service.impl.ChildMenuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author each
 * @since 2019-04-11
 */
@Api(value = "菜单接口",tags = {"菜单接口"},description = "菜单查询业务")
@RestController
@RequestMapping("/childMenu")
@Slf4j
public class ChildMenuController {

    @Autowired
    private ChildMenuServiceImpl childMenuService;

    @RequestMapping(value = "/txt", method= RequestMethod.GET)
    @ApiOperation(value="返回用户输入文本",tags={"返回用户输入文本"}, notes="用户输入什么就返回什么")
    @ApiImplicitParam(paramType="query", name = "txt", value = "文本", required = true, dataType = "String")
    public String test(String txt){
        Page page=new Page(1,1);


        QueryWrapper queryWrapper=new QueryWrapper();


        //单表分页查询
        LambdaQueryWrapper<ChildMenu> lambdaQueryWrapper =new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(ChildMenu::getChildMenuName,"sss");
        childMenuService.page(page, lambdaQueryWrapper);

        //单表一个条件查询
//       ChildMenu childMenu = childMenuService.getOne(new QueryWrapper<ChildMenu>().eq("child_Menu_Name",txt));
        ChildMenu childMenu=childMenuService.getOne(new LambdaQueryWrapper<ChildMenu>().eq(ChildMenu::getChildMenuName,txt ));
        log.info("childMenu-------------------------"+childMenu);

        //添加
        List<ChildMenu> childMenus=new ArrayList<>();
        ChildMenu childMenu11=new ChildMenu();
        ChildMenu childMenu12=new ChildMenu();
        childMenus.add(childMenu11);
        childMenus.add(childMenu12);
        childMenuService.saveBatch(childMenus);


        //自定义sql
        return txt;
    }
}

