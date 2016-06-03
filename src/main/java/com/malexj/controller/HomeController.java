package com.malexj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index_GET(){
        return "index";
    }

//    // TEST PAGE
//    @RequestMapping(path = "/aut", method = RequestMethod.GET)
//    public String home_aut(){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(principal instanceof UserDetails) {
//            UserDetails details = (UserDetails) principal;
//
//            AccountAllDTO loggedIn = accountService.findByAccountName(details.getUsername());
//            System.err.println(loggedIn.getName());
//            return "index";
//        }
//        return "index";
//    }

}
