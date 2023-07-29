package com.crdt.creditapi.entities;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "accounts")
public class AccountsEntity {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(name = "customer_id")
    private String customer_id;
    @Column(name = "account_limit")
    private int account_limit;
    @Column(name = "per_transaction_limit")
    private int per_transaction_limit;
    @Column(name = "last_account_limit")
    private int last_account_limit;
    @Column(name = "last_per_transaction_limit")
    private int last_per_transaction_limit;
    @Column(name = "account_limit_update_time")
    private LocalDateTime account_limit_update_time;
    @Column(name = "per_transaction_limit_update_time")
    private LocalDateTime per_transaction_limit_update_time;

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setAccount_limit(int account_limit) {
        this.account_limit = account_limit;
    }

    public void setPer_transaction_limit(int per_transaction_limit) {
        this.per_transaction_limit = per_transaction_limit;
    }

    public void setLast_account_limit(int last_account_limit) {
        this.last_account_limit = last_account_limit;
    }

    public void setLast_per_transaction_limit(int last_per_transaction_limit) {
        this.last_per_transaction_limit = last_per_transaction_limit;
    }

    public void setAccount_limit_update_time(LocalDateTime account_limit_update_time) {
        this.account_limit_update_time = account_limit_update_time;
    }

    public void setPer_transaction_limit_update_time(LocalDateTime per_transaction_limit_update_time) {
        this.per_transaction_limit_update_time = per_transaction_limit_update_time;
    }
}
