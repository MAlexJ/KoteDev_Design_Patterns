package com.malexj.controller;

import com.malexj.model.dto.AccountAllDTO;
import com.malexj.model.dto.AccountIdAndNameDTO;
import com.malexj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminRestUsersController {

    @Autowired
    private AccountService accountService;

    //GET
    @RequestMapping(path = "/getUsers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AccountIdAndNameDTO> admin_page_type() {
        return accountService.findAllDTO();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/getUser/{id}", method = RequestMethod.GET)
    public AccountAllDTO admin_page_delete(@PathVariable Long id) {
        if (id > 0) {
            return accountService.findById(id);
        }
        return null;
    }
}
