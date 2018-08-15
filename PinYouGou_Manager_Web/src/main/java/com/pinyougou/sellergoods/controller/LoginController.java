package com.pinyougou.sellergoods.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PinYouGou_Parent
 * @description: 用户登录控制层
 * @author: LLL
 * @create: 2018-08-15 17:01
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    /** 
     * @Description: 用户登录后显示用户名
     * @Param:
     * @return:
     * @Author: LLL
     * @Date: 2018/8/15 
     */
    @RequestMapping("name")
    public Map name(){
        SecurityContext context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName",name);
        return map;
    }
}
