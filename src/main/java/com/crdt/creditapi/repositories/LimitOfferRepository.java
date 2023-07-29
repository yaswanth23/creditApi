package com.crdt.creditapi.repositories;

import com.crdt.creditapi.entities.LimitOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LimitOfferRepository extends JpaRepository<LimitOfferEntity, Long> {

    List<LimitOfferEntity> findByAccountIdAndStatusAndOfferActivationTimeBeforeAndOfferExpiryTimeAfter(
            Long account_id, String status, LocalDateTime offerActivationTime, LocalDateTime offerExpiryTime);

    List<LimitOfferEntity> findByAccountIdAndStatus(Long account_id, String status);
}
