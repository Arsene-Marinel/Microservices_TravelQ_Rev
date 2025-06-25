package com.travelq.userservice.controller.clients;

import com.travelq.userservice.dto.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "flight-service")
public interface FlightClient {

    @GetMapping("/api/flights/{id}")
    FlightDto getFlightById(@PathVariable("id") Long flightId);
}
