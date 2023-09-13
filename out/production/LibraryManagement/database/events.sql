
    CREATE EVENT `lostBook`
    ON SCHEDULE EVERY 1 DAY
    STARTS CURRENT_TIMESTAMP + INTERVAL 1 DAY
    DO BEGIN
        UPDATE reservation AS r INNER JOIN book AS b
        SET r.status = 'lost' AND b.quantityLost = b.quantityLost + r.quantityReserved
        WHERE r.`status` = 'borrowed' AND r.dateReservation <= GETDATE();
    END