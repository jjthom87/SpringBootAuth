package com.jao.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jao.web.service.SecurityService;

@Controller
public class HtmlController {
	
	@Autowired
	SecurityService securityService;
	
	private static Logger log = Logger.getLogger("InfoLogging");
	
    @RequestMapping("/")
    public String homePage(Model model) {
        //model.addAttribute("appName", "bob");
        return "home";
    }
    
    @RequestMapping("/register")
    public String registerPage() {
    		return "register";
    }
    
    @RequestMapping("/login")
    public String loginPage() {
    		return "login";
    }
    
    @RequestMapping("/userhome")
    public String userHomePage(Model model) {
    		model.addAttribute("username", securityService.getUser());
    		return "userhome";
    }
    
}
