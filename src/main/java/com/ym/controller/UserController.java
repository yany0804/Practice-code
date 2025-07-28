package com.ym.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import com.ym.utils.Result;
import com.ym.entity.User;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangmin
 * @since 2025-06-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public Result login(String uname,String pwd){
        QueryWrapper<User>wrapper =new QueryWrapper<User>();
        //前数据库，后是传进来的值
        wrapper.eq("uname",uname).eq("upwd",pwd);
        List<User>users=userService.list(wrapper);
        Result result;
        if(users!=null && users.size()>0){
            if(users.get(0).getUrole()==1){
                result=new Result(0,uname);
            }else{
                result=new Result(1,"非管理员不允许登录");
            }
        }else{
            result=new Result(1,"用户名或密码错误");
        }
        return result;
    }
}
