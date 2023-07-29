package com.crdt.creditapi.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountDto {
    private String statusCode;
    private String statusMessage;
    private Long account_id;

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
}
