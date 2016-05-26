package com.malexj.util;

import com.malexj.model.dto.AccountAllDTO;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUtil {

    public void send( AccountAllDTO accountDTO){
        System.err.println("Send password: " + accountDTO);
    }

}
