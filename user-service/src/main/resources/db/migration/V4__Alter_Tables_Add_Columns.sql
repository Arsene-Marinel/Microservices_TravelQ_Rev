-- Add new columns to existing tables

-- Add created_at timestamp to users table
ALTER TABLE users 
ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- Add updated_at timestamp to users table
ALTER TABLE users
ADD COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- Add seat number to travel_options table
ALTER TABLE travel_options 
ADD COLUMN seat_number VARCHAR(10);

-- Update existing travel options with random seat numbers
UPDATE travel_options SET seat_number = 
    CASE 
        WHEN seat_selection = 'BUSINESS' THEN CONCAT('B', FLOOR(1 + RAND() * 20))
        ELSE CONCAT(CHAR(65 + FLOOR(RAND() * 6)), FLOOR(1 + RAND() * 30))
    END;