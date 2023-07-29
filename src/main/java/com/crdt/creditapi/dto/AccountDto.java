package com.crdt.creditapi.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class AccountDto {
    private String statusCode;
    private String statusMessage;
    private Long account_id;
    private String customer_id;
    private int account_limit;
    private int per_transaction_limit;
    private int last_account_limit;
    private int last_per_transaction_limit;
    private LocalDateTime account_limit_update_time;
    private LocalDateTime per_transaction_limit_update_time;

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
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
