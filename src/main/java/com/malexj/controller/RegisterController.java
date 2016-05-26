package com.malexj.controller;

import com.malexj.model.dto.AccountAllDTO;
import com.malexj.model.dto.AccountEmailDTO;
import com.malexj.model.enums.Roles;
import com.malexj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register_POST(@RequestBody AccountAllDTO account) {
        if (account.getName() != null
                && account.getPassword() != null
                && account.getEmail() != null) {
            account.setRole(Roles.ROLE_USER);
            accountService.saveDTO(account);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/restore", method = RequestMethod.POST)
    public void restore_POST(@RequestBody AccountEmailDTO account) {
        if (account.getEmail() != null) {
            System.err.println(account);
        }
    }

}
