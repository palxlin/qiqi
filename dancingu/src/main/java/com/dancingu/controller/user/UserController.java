package com.dancingu.controller.user;

import com.dancingu.model.user.UserVo;
import com.dancingu.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fanlin on 2017/10/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String login() {
        UserVo userVo = new UserVo();
        userVo.setUserId("1");
        userVo.setUserName("test");
        userVo.setPassword("111");

        try{
            userService.addUser(userVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "user/login";
    }
}
