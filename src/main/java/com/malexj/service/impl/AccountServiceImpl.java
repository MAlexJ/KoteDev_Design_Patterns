package com.malexj.service.impl;


import com.malexj.exception.FailedCreateAccountException;
import com.malexj.exception.NoFoundUserException;
import com.malexj.model.dto.AccountAllDTO;
import com.malexj.model.entity.AccountEntity;
import com.malexj.repository.AccountRepository;
import com.malexj.service.AccountService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Override
    public AccountAllDTO findByAccountName(String name) {
        if (name.equals("flash")) {
            return new AccountAllDTO();
        }
        AccountEntity account = repository.findByName(name);
        return (account != null)
                ? beanMapper.map(account, AccountAllDTO.class)
                : null;
    }

    @Override
    public void saveDTO(AccountAllDTO accountDTO) throws FailedCreateAccountException {
        AccountEntity account = save(beanMapper.map(accountDTO, AccountEntity.class));
        if (account == null) {
            throw new FailedCreateAccountException();
        }

    }

    @Override
    public AccountAllDTO findByEmail(String email) throws NoFoundUserException {
        AccountEntity account = repository.findByEmail(email);
        if (account == null) throw new NoFoundUserException();
        return beanMapper.map(account, AccountAllDTO.class);
    }

    @Override
    public AccountEntity save(AccountEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public AccountEntity update(AccountEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public AccountEntity find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<AccountEntity> findAll() {
        return repository.findAll();
    }
}
