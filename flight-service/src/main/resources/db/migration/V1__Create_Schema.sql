-- Creating schema for TravelQ application

-- Flights table
CREATE TABLE IF NOT EXISTS flights (
    flight_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stopovers INT NOT NULL DEFAULT 0
);

-- Flight Comparisons table
CREATE TABLE IF NOT EXISTS flight_comparisons (
    comparison_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Flight Comparison Items junction table
CREATE TABLE IF NOT EXISTS flight_comparison_items (
    comparison_id BIGINT NOT NULL,
    flight_id BIGINT NOT NULL,
    PRIMARY KEY (comparison_id, flight_id),
    FOREIGN KEY (comparison_id) REFERENCES flight_comparisons(comparison_id) ON DELETE CASCADE,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id) ON DELETE CASCADE
);
 