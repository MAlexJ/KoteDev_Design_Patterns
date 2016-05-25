package com.malexj.service;


import com.malexj.model.AccountEntity;

public interface AccountService {

    AccountEntity findByAccountName(String name);
}
