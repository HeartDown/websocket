package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cache.redis.cacheStorage.RedisCache;
import com.model.User;
import com.service.ContentService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhangheng on 2017/8/7.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Resource
    private UserService userService;
    @Lazy
    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        //从客户端cookies中获取用户对象
        User user = null;
        try {
            user = JSONObject.parseObject(
                    URLDecoder.decode(
                            Arrays.asList(cookies).stream()
                                    .filter(cookie -> cookie.getName().equals("userinfo"))
                                    .collect(toList())
                                    .get(0).getValue(), "utf-8"), User.class);
        } catch (Exception e) {
            return "login";
        }
        //判断客户端cookie中是否有userinfo若有则使用cookie登陆
        if (user != null) {
            if (userService.login(user)) {
                System.out.println("有cookie");
                request.getSession().setAttribute("currentUser", user);
                request.getSession().setAttribute("allBlog",contentService.findAll());
                //此处增加直接进入博客的入口
                return "blog/seeBlog";
            }
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String formitem, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        User user = JSONObject.parseObject(formitem, User.class);
        Map result = new HashMap<String, Object>();
         if (userService.login(user)) {
            //写入客户端cookie
            Cookie cookie = new Cookie("userinfo",
                    URLEncoder.encode(JSON.toJSONString(user), "utf-8"));
            response.addCookie(cookie);
            result.put("status", "success");
            result.put("msg", "old user,welcome");
        } else {
            result.put("status", "fail");
            result.put("msg", "password is not correct");
        }
        request.getSession().setAttribute("currentUser", user);
        return JSON.toJSONString(result);
    }


    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(HttpServletRequest req, HttpServletResponse res) {
        User client = (User) req.getSession().getAttribute("currentUser");
        return client != null ? client : null;
    }
}
