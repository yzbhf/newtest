package com.controller;

import com.bean.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping(value = "/userlogin")
    private String userlogin(HttpServletRequest req, User user) {

        System.out.println(user.getUsername());
        User rs = userService.selectUser(user);
          if (rs != null) {
            System.out.println(rs.getUsername() + rs.getId());

            return "index";
        } else {
            req.getSession().setAttribute("messagetitle", "用户名或密码错误，请重新登录");
            return "redirect:login.jsp";
        }

    }

}