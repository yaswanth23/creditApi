package com.crdt.creditapi.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreditCreateResDto {
    private String statusCode;
    private String statusMessage;
    private Long limit_offer_id;

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setLimit_offer_id(Long limit_offer_id) {
        this.limit_offer_id = limit_offer_id;
    }
}
