package com.crdt.creditapi.entities;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(name = "limit_offers")
public class LimitOfferEntity {
    @Id
    @Column(name = "limit_offer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long limitOfferId;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "limit_type")
    private String limitType;
    @Column(name = "new_limit")
    private int newLimit;
    @Column(name = "offer_activation_time")
    private LocalDateTime offerActivationTime;
    @Column(name = "offer_expiry_time")
    private LocalDateTime offerExpiryTime;
    @Column(name = "status")
    private String status;

    public void setLimitOfferId(Long limitOfferId) {
        this.limitOfferId = limitOfferId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setLimitType(String limitType) {
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

    public void setStatus(String status) {
        this.status = status;
    }
}
