package com.controller;

import com.alibaba.fastjson.JSON;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangheng on 2017/8/7.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam String formitem, HttpServletRequest request, HttpServletResponse response){
        User user = JSONObject.parseObject(formitem,User.class);
        Map result = new HashMap<String,Object>();
        User dbuser = userService.findOne(new Query(Criteria.where("username").is(user.getUsername())),"user");
        result.put("user",user.getUsername());
        if (dbuser!=null){
            if(dbuser.getPassword().equals(user.getPassword())){
                request.getSession().setAttribute("currentUser",dbuser);
                result.put("status","success");
                result.put("msg","you are old user ,welcome");
            }
            else {
                result.put("status", "fail");
                result.put("msg", "user or password not correct");
            }
            System.out.println(JSON.toJSONString(result));
            return JSON.toJSONString(result);
        }
        user.setId(null);
        result.put("status","success");
        result.put("msg","new a user,thank you");
        userService.insert(user,"user");
        request.getSession().setAttribute("currentUser",user);
        System.out.println(JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(HttpServletRequest req, HttpServletResponse res) {
        User client = (User) req.getSession().getAttribute("currentUser");
        return client != null ? client : null;
    }
}
