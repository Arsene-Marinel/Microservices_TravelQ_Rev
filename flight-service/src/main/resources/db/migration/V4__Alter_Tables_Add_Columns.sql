-- Add new columns to existing tables

-- Add flight number to flights table
ALTER TABLE flights 
ADD COLUMN flight_number VARCHAR(10);

-- Update existing flights with flight numbers
UPDATE flights SET flight_number = 
    CONCAT(
        CASE 
            WHEN origin = 'New York' THEN 'NY'
            WHEN origin = 'London' THEN 'LN'
            WHEN origin = 'Paris' THEN 'PR'
            WHEN origin = 'Rome' THEN 'RM'
            WHEN origin = 'Barcelona' THEN 'BC'
            WHEN origin = 'Madrid' THEN 'MD'
            WHEN origin = 'Lisbon' THEN 'LB'
            WHEN origin = 'Amsterdam' THEN 'AM'
            WHEN origin = 'Berlin' THEN 'BL'
            WHEN origin = 'Prague' THEN 'PG'
            ELSE 'XX'
        END,
        FLOOR(100 + RAND() * 900)
    ); 