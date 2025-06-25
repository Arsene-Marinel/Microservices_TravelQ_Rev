package com.travelq.userservice.domain.service;


import com.travelq.userservice.dto.TravelHistoryDto;

import java.util.List;

public interface TravelHistoryService {

    TravelHistoryDto addTravelHistory(TravelHistoryDto travelhistoryDto);

    List<TravelHistoryDto> getAllTravelHistories();

    TravelHistoryDto getTravelHistoryById(Long travelHistoryId);

    TravelHistoryDto updateTravelHistory(Long travelHistoryId, TravelHistoryDto travelhistoryDto);

    void deleteTravelHistory(Long travelHistoryId);
}
