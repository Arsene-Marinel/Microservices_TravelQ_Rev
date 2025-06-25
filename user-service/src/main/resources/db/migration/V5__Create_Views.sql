-- View: Summary of user and their travel history
CREATE OR REPLACE VIEW user_travel_summary AS
SELECT
    u.user_id,
    u.username,
    u.email,
    u.first_name,
    u.last_name,
    th.flights_count,
    th.total_spent,
    (SELECT COUNT(*) FROM tickets t WHERE t.user_id = u.user_id) AS actual_tickets_count
FROM
    users u
        JOIN
    travel_histories th ON u.user_id = th.user_id;


-- View: User notification statistics
CREATE OR REPLACE VIEW user_notification_stats AS
SELECT
    u.user_id,
    u.username,
    COUNT(n.notification_id) AS total_notifications,
    SUM(CASE WHEN n.is_read = TRUE THEN 1 ELSE 0 END) AS read_notifications,
    SUM(CASE WHEN n.is_read = FALSE THEN 1 ELSE 0 END) AS unread_notifications
FROM
    users u
        LEFT JOIN
    notifications n ON u.user_id = n.user_id
GROUP BY
    u.user_id, u.username;