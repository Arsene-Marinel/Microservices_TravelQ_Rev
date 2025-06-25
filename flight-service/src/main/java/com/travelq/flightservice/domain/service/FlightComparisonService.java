package com.travelq.flightservice.domain.service;

import com.travelq.flightservice.dto.FlightComparisonDto;

import java.util.List;

public interface FlightComparisonService {

    FlightComparisonDto addFlightComparison(FlightComparisonDto flightcomparisonDto);

    List<FlightComparisonDto> getAllFlightComparisons();

    FlightComparisonDto getFlightComparisonById(Long flightComparisonId);

    FlightComparisonDto updateFlightComparison(Long flightComparisonId, FlightComparisonDto flightcomparisonDto);

    void deleteFlightComparison(Long flightComparisonId);
}
