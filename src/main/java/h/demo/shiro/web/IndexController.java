/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * 
 * @Description：
 * 
 * @author：yuandong.huang@gmail.com
 * 
 * @date：2013-9-12
 */
package h.demo.shiro.web;

import h.demo.shiro.entity.Account;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-12
 */
@Controller
public class IndexController {
    
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        model.addAttribute("account", account);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录
     * 
     * @param account
     * @param password
     * @return String
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(String account, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        token.setRememberMe(true);
        String result = "redirect:/login.do";
        try {
            logger.info("{}登录系统！", account);
            subject.login(token);
            result = "redirect:/index.do";
        } catch (UnknownAccountException uae) {
            logger.info("username wasn't in the system, show them an error message?");
            token.clear();
        } catch (IncorrectCredentialsException ice) {
            logger.info("password didn't match, try again?");
            token.clear();
        } catch (LockedAccountException lae) {
            logger.info("account for that username is locked - can't login. Show them a message?");
            token.clear();
        } catch (AuthenticationException e) {
            token.clear();
        }
        return result;
    }
    
    /**
     * 登出
     * 
     * @return String
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        
        if(account != null) {
            logger.info("{}登出系统！", account.getUsername());
        }
        
        return "login";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "error/unauthorized";
    }


}
