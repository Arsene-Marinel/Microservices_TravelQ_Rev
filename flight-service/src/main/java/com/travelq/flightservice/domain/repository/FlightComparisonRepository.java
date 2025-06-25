package com.travelq.flightservice.domain.repository;

import com.travelq.flightservice.domain.model.FlightComparisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightComparisonRepository extends JpaRepository<FlightComparisonEntity, Long> {
}
