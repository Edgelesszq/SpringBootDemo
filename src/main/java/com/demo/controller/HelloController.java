package com.demo.controller;

import com.demo.domain.User;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users/")
@RestController
public class HelloController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "getUserByName", method = RequestMethod.GET)
    private User getUserByName(@RequestParam(value = "username",required = true) String name) {
        return userService.getUserByName(name);
    }
    @RequestMapping(value = "loginbypass", method = RequestMethod.POST)
    private User loginbyinfo(@RequestParam(value = "username",required = true) String username,@RequestParam(value = "password",required = true)String password){
        // 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟 shiro 的拦截地址内．不然后会报空指针
        Subject sub = SecurityUtils.getSubject();
        // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
        // 认证执行者交由 com.battcn.config.AuthRealm 中 doGetAuthenticationInfo 处理
        // 当以上认证成功后会向下执行,认证失败会抛出异常
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            sub.login(token);
            return userService.getUserByName(username,password);
        } catch (UnknownAccountException e) {
            token.clear();
            return new User();
        } catch (LockedAccountException lae) {
            token.clear();
            return new User();
        } catch (ExcessiveAttemptsException e) {
            token.clear();
            return new User();
        } catch (AuthenticationException e) {
            token.clear();
            return new User();
        }

    }

}
