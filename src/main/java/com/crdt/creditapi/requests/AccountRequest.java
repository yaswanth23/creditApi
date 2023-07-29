package com.crdt.creditapi.requests;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
public class AccountRequest {
    @NotNull(message = "customer id cannot be null")
    private String customer_id;
    @NotNull(message = "account limit cannot be null")
    private Integer account_limit;
    @NotNull(message = "per transaction limit cannot be null")
    private Integer per_transaction_limit;

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setAccount_limit(Integer account_limit) {
        this.account_limit = account_limit;
    }

    public void setPer_transaction_limit(Integer per_transaction_limit) {
        this.per_transaction_limit = per_transaction_limit;
    }
}
