package com.crdt.creditapi.entities;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "limit_offers")
public class LimitOfferEntity {
    @Id
    @Column(name = "limit_offer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long limit_offer_id;
    @Column(name = "account_id")
    private Long account_id;
    @Column(name = "limit_type")
    private String limit_type;
    @Column(name = "new_limit")
    private int new_limit;
    @Column(name = "offer_activation_time")
    private LocalDateTime offer_activation_time;
    @Column(name = "offer_expiry_time")
    private LocalDateTime offer_expiry_time;
    @Column(name = "status")
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
