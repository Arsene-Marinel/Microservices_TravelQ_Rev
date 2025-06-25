-- Create views for reporting

-- Create a view for flight details with tickets sold
CREATE OR REPLACE VIEW flight_ticket_summary AS
SELECT 
    f.flight_id,
    f.flight_number,
    f.origin,
    f.destination,
    f.departure_time,
    f.arrival_time,
    f.price,
    f.stopovers,
    COUNT(t.ticket_id) AS tickets_sold,
    SUM(CASE WHEN topt.seat_selection = 'BUSINESS' THEN 1 ELSE 0 END) AS business_class_count,
    SUM(CASE WHEN topt.seat_selection = 'ECONOMY' THEN 1 ELSE 0 END) AS economy_class_count
FROM 
    flights f
LEFT JOIN 
    tickets t ON f.flight_id = t.flight_id
LEFT JOIN 
    travel_options topt ON t.ticket_id = topt.ticket_id
GROUP BY 
    f.flight_id, f.flight_number, f.origin, f.destination, f.departure_time, f.arrival_time, f.price, f.stopovers;