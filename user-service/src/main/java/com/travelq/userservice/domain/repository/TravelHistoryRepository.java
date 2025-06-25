package com.travelq.userservice.domain.repository;

import com.travelq.userservice.domain.model.TravelHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelHistoryRepository extends JpaRepository<TravelHistoryEntity, Long> {
    Optional<TravelHistoryEntity> findByUserId(Long userId);
}
