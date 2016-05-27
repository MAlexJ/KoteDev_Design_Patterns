package com.malexj.service;


import com.malexj.exception.FailedCreateAccountException;
import com.malexj.exception.NoFoundUserException;
import com.malexj.model.dto.AccountAllDTO;
import com.malexj.model.entity.AccountEntity;

import java.util.List;

public interface AccountService {

    //DTO
    AccountAllDTO findByAccountName(String name);

    void saveDTO(AccountAllDTO accountDTO) throws FailedCreateAccountException;

    AccountAllDTO findByEmail(String email) throws NoFoundUserException;

    //Entity
    com.malexj.model.entity.AccountEntity save(AccountEntity entity);

    AccountEntity update(AccountEntity entity);

    void delete(Long id);

    AccountEntity find(Long id);

    List<AccountEntity> findAll();

}

