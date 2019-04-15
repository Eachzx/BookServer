package com.each.bookserver;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.each.bookserver.entity.*;
import com.each.bookserver.service.impl.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookserverApplicationTests {

    @Autowired
    private ChildMenuServiceImpl childMenuService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private PermissionServiceImpl permissionService;
     @Autowired
     private ParentMenuServiceImpl parentMenuService;

    @Test
    public void contextLoads() {
//        User u =userService.findUserByUserName("user1");
////       List<Role> roles=roleService.findRoleById(1);
//       System.out.println(u);
//
//        List<Permission> permission=permissionService.findPermissionById(2);
//        System.out.println(permission);
//
//        List<ParentMenu> parentMens=parentMenuService.findParentMenuById(1);
//        log.info("cheshi:{}",parentMens);

//        ChildMenu childMenu=childMenuService.getOne(new LambdaQueryWrapper<ChildMenu>().eq(ChildMenu::getChildMenuName,"child_menu_1_1" ));
//
//        Permission permission = permissionService.getOne(new LambdaQueryWrapper<Permission>().eq(Permission::getPermissionName,"p_1" ));
//
//
//        log.info("cheshi:{}",permission);
//        List<ChildMenu> childMenus=childMenuService.findListChildMenuById(1);
//
//        log.info("子菜单:{}",childMenus);



        User user = new User();
        user.setId(1);
        user.setUserName("user1");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode("123456"));
        user.setUserNo("NO1");

        boolean ss=userService.updateById(user);



    }

}
