package com.malexj.controller;

import com.malexj.exception.FailedCreateAccountException;
import com.malexj.exception.NoFoundUserException;
import com.malexj.model.dto.AccountAllDTO;
import com.malexj.model.dto.AccountEmailDTO;
import com.malexj.model.enums.Roles;
import com.malexj.model.enums.UserStatus;
import com.malexj.service.AccountService;
import com.malexj.util.SendEmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private SendEmailUtil emailUtil;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register_POST(@RequestBody AccountAllDTO account) {
        try {
            account.setRole(Roles.ROLE_USER);
            account.setStatus(UserStatus.ACTIVE);
            accountService.saveDTO(account);
        } catch (FailedCreateAccountException e) {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/restore", method = RequestMethod.POST)
    public ResponseEntity<?> restore_POST(@RequestBody AccountEmailDTO account) {
        try {
            AccountAllDTO accountDTO = accountService.findByEmail(account.getEmail());
            emailUtil.send(accountDTO);
        } catch (NoFoundUserException e) {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
