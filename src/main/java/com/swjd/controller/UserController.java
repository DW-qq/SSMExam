package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swjd.bean.User;
import com.swjd.mapper.UserMapper;
import com.swjd.service.UserService;
import com.swjd.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        User user = new User();
        System.out.println(user);
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(Model model,User user){
        /*System.out.println(user);*/
        String uname=user.getuName();
        String pwd = user.getPassword();
        System.out.println(uname);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",uname).eq("password",pwd);
        List<User> list =userMapper.selectList(queryWrapper);
        System.out.println(list);
        String flag="";
        if(list!=null&&list.size()>0){
            for (User user1:list){
                System.out.println(user1.getFlag());
                flag=user1.getFlag();
            }
            if(flag.equals("1")){
                return "main";
            }else {
                //账户被冻结
                model.addAttribute("erroMsg","账户被冻结，请联系客服");
                model.addAttribute("user",user);
                return "login";
            }
        }else {
            model.addAttribute("erroMsg","账号或密码不正确");
            model.addAttribute("user",user);
            return "login";
        }
    }
}
