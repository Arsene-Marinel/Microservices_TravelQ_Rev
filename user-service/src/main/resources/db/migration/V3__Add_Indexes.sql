-- Add indexes for better performance

-- Index for username lookup
CREATE INDEX idx_users_username ON users(username);

-- Index for email lookup
CREATE INDEX idx_users_email ON users(email);

-- Index for ticket purchase date
CREATE INDEX idx_tickets_purchase_date ON tickets(purchase_date);

-- Index for notification read status
CREATE INDEX idx_notifications_is_read ON notifications(is_read); 