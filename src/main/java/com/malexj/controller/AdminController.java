package com.malexj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String admin(){
        return "admin";
    }

    // Home
    @RequestMapping(path = "/adminHome", method = RequestMethod.GET)
    public String admin_home(){
        return "admin/adminHome";
    }

    // Home
    @RequestMapping(path = "/viewUsers", method = RequestMethod.GET)
    public String admin_users(){
        return "admin/viewUsers";
    }

    // Page
    @RequestMapping(path = "/createPage", method = RequestMethod.GET)
    public String admin_page_create(){
        return "admin/createPage";
    }

    @RequestMapping(path = "/updatePage", method = RequestMethod.GET)
    public String admin_page_update(){
        return "admin/updatePage";
    }

    @RequestMapping(path = "/deletePage", method = RequestMethod.GET)
    public String admin_page_delete(){
        return "admin/deletePage";
    }

    // Pattern
    @RequestMapping(path = "/image", method = RequestMethod.GET)
    public String admin_image(){
        return "admin/image";
    }

    // Pattern
    @RequestMapping(path = "/createPattern", method = RequestMethod.GET)
    public String admin_pattern_create(){
        return "admin/createPattern";
    }

    @RequestMapping(path = "/updatePattern", method = RequestMethod.GET)
    public String admin_pattern_update(){
        return "admin/updatePattern";
    }

    @RequestMapping(path = "/deletePattern", method = RequestMethod.GET)
    public String admin_pattern_delete(){
        return "admin/deletePattern";
    }

}
