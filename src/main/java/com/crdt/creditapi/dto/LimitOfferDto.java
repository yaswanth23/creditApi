package com.crdt.creditapi.dto;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class LimitOfferDto {
    private Long limit_offer_id;
    private Long account_id;
    private String limit_type;
    private int new_limit;
    private LocalDateTime offer_activation_time;
    private LocalDateTime offer_expiry_time;
    private String status;

    public void setLimit_offer_id(Long limit_offer_id) {
        this.limit_offer_id = limit_offer_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public void setLimit_type(String limit_type) {
        this.limit_type = limit_type;
    }

    public void setNew_limit(int new_limit) {
        this.new_limit = new_limit;
    }

    public void setOffer_activation_time(LocalDateTime offer_activation_time) {
        this.offer_activation_time = offer_activation_time;
    }

    public void setOffer_expiry_time(LocalDateTime offer_expiry_time) {
        this.offer_expiry_time = offer_expiry_time;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
