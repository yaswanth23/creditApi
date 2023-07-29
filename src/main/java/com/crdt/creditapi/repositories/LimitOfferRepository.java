package com.crdt.creditapi.repositories;

import com.crdt.creditapi.entities.LimitOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitOfferRepository extends JpaRepository<LimitOfferEntity, Long> {
}
