/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * @Description： 
 * @author：yuandong.huang@gmail.com
 * @date：2013-9-17
 */
package h.demo.shiro.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-17 
 */
@Controller
public class AuthcController {
    
    @RequestMapping("/authc/edit")
    public String edit(Model model) {
        model.addAttribute("msg", "这是编辑页面!");
        return "result";
    }
    
    @RequestMapping("/authc/view")
    public String view(Model model) {
        model.addAttribute("msg", "这是查看页面!");
        return "result";
    }
    
    @RequestMapping("/authc/self")
    public String self(Model model) {
        model.addAttribute("msg", "这是self页面!");
        return "result";
    }
    
    @RequestMapping(value = "/authc/doc/{id}", method = RequestMethod.GET, headers = {"Accept=image/webp,*/*;q=0.8"})
    public String restful() {
        
        return "result";
    }

}
