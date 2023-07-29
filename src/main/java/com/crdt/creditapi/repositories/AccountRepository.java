package com.crdt.creditapi.repositories;

import com.crdt.creditapi.entities.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountsEntity, Long> {
    AccountsEntity findByAccountId(Long account_id);
}
