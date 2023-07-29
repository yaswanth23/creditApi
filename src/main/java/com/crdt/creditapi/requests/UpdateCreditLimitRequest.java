package com.crdt.creditapi.requests;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
public class UpdateCreditLimitRequest {
    @NotNull(message = "status cannot be null")
    private StatusType status;

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public enum StatusType {
        ACCEPTED,
        REJECTED
    }
}
