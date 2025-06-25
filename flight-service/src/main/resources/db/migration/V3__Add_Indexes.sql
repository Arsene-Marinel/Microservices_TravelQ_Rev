-- Add indexes for better performance

-- Index for flight origin and destination, which will be frequently queried
CREATE INDEX idx_flights_origin ON flights(origin);
CREATE INDEX idx_flights_destination ON flights(destination);

-- Index for flight departure and arrival times for date-based searches
CREATE INDEX idx_flights_departure_time ON flights(departure_time);
CREATE INDEX idx_flights_arrival_time ON flights(arrival_time);

-- Index for flight price for sorting and filtering
CREATE INDEX idx_flights_price ON flights(price);