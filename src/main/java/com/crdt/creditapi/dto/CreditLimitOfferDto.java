package com.crdt.creditapi.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreditLimitOfferDto {
    private String statusCode;
    private String statusMessage;
    private String accountId;

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
