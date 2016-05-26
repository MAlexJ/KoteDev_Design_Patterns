package com.malexj.repository;


import com.malexj.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByName(String name);

    AccountEntity findByEmail(String email);
}
