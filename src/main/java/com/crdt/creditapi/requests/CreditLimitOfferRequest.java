package com.crdt.creditapi.requests;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@ToString
public class CreditLimitOfferRequest {
    @NotEmpty(message = "Account Id cannot be null or empty")
    private String accountId;

    @NotNull(message = "limitType cannot be null")
    private LimitType limitType;

    @NotNull(message = "newLimit cannot be null")
    private Integer newLimit;

    @NotNull(message = "offerActivationTime cannot be null")
    private LocalDateTime offerActivationTime;

    @NotNull(message = "offerExpiryTime cannot be null")
    private LocalDateTime offerExpiryTime;

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }

    public void setNewLimit(int newLimit) {
        this.newLimit = newLimit;
    }

    public void setOfferActivationTime(LocalDateTime offerActivationTime) {
        this.offerActivationTime = offerActivationTime;
    }

    public void setOfferExpiryTime(LocalDateTime offerExpiryTime) {
        this.offerExpiryTime = offerExpiryTime;
    }

    public enum LimitType {
        ACCOUNT_LIMIT,
        PER_TRANSACTION_LIMIT
    }
}
