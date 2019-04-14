package com.each.bookserver.service;

import com.each.bookserver.entity.MyUserDetails;
import com.each.bookserver.entity.Permission;
import com.each.bookserver.entity.Role;
import com.each.bookserver.entity.User;
import com.each.bookserver.exception.WrongUsernameException;
import com.each.bookserver.service.impl.UserServiceImpl;
import com.each.bookserver.webEnum.AuthErrorEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.service
 * @Description: security处理用户登陆
 * @Author: zhangxu
 * @CreateDate: 2019/4/11 16:43
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/11 16:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetailsService implements UserDetailsService{


    @Autowired
    private UserServiceImpl userService;

    /**
     * 根据用户名登录
     * @param s 用户名
     * @return  UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{

        Optional<User> userOptional = Optional.ofNullable(userService.findUserByUserName(s));
        if (userOptional.isPresent()){
            User user = userOptional.get();
            //级联查询(即时加载)
            List<Role> roles = user.getRoles();
            List<Permission> permissions = new ArrayList<>();
            for (Role role:roles){
                //级联查询
                List<Permission> permissionList = role.getPermissions();
//                role.setPermissions(permissionList);
            }
//            user.setRoles(roles);
            UserDetails userDetails = new MyUserDetails(user);
//            List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();
            return userDetails;
        }else {
            log.error("用户不存在");
            throw new WrongUsernameException(AuthErrorEnum.LOGIN_NAME_ERROR.getMessage());
        }
    }
}
