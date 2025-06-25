package com.travelq.userservice.domain.service;

import com.travelq.userservice.dto.TravelOptionDto;

import java.util.List;

public interface TravelOptionService {

    TravelOptionDto addTravelOption(TravelOptionDto traveloptionDto);

    List<TravelOptionDto> getAllTravelOptions();

    TravelOptionDto getTravelOptionById(Long travelOptionId);

    TravelOptionDto updateTravelOption(Long travelOptionId, TravelOptionDto traveloptionDto);

    void deleteTravelOption(Long travelOptionId);
}
