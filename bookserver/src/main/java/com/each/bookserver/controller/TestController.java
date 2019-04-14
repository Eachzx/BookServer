package com.each.bookserver.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/testApi")
public class TestController {


    @PreAuthorize("hasAuthority('ADMIN')")

    @RequestMapping(value = "/addData")
    public String addData(){
     return "/addData方法"   ;
    }

    @RequestMapping(value = "/getData")
    public String getData(){
        return "/getData方法"   ;
    }

    @RequestMapping(value = "/deleteData")
    public String deleteData(){
        return "/deleteData方法"   ;
    }

    /////////////////////////基于内存的用户认证///////////////////////////////////
    @RolesAllowed({"USER"})
    @RequestMapping(value = "/authorize1",produces = MediaType.APPLICATION_JSON_VALUE)
    public String authorize1(){
        return "authorized success";
    }

    @DenyAll
    @RequestMapping(value = "/authorize2",produces = MediaType.APPLICATION_JSON_VALUE)
    public String authorize2(){
        return "authorized success";
    }

    @RolesAllowed({"ADMIN"})
    @RequestMapping(value = "/authorize3",produces = MediaType.APPLICATION_JSON_VALUE)
    public String authorize3(){
        return "authorized success";
    }

    /////////////////////需要定义自己的userDetailService////////////////
    @PreAuthorize("hasAuthority('p_1')")
    @RequestMapping(value = "/authorize4",produces = MediaType.APPLICATION_JSON_VALUE)
    public String authorize4(){
        return "authorized success";
    }

}
