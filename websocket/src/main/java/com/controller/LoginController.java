package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.User;
import com.service.UserService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangheng on 2017/8/7.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Resource
    private UserService userService;
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res){
        return new ModelAndView(new RedirectView(req.getContextPath() + "/view/login.html"));
    }
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam String formitem,HttpServletResponse response){

        User user = JSONObject.parseObject(formitem,User.class);
        User dbuser = userService.findOne(new Query(Criteria.where("username").is(user.getUsername())),"user");
        if (dbuser!=null){
            if(dbuser.getPassword().equals(user.getPassword()))
                return "you are old user ,welcome";
            else
                return "user or password not correct";
        }
        user.setId(null);
        userService.insert(user,"user");
        return "new a user,thank you";
    }
}
