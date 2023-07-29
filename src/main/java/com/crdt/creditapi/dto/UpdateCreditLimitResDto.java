package com.crdt.creditapi.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UpdateCreditLimitResDto {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
