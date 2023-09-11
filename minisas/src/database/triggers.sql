DELIMITER //
CREATE TRIGGER decrement_book_quantity
    AFTER INSERT ON Reservation
    FOR EACH ROW
BEGIN
    UPDATE book AS b INNER JOIN reservation AS r
    ON b.isbn = r.idBook
        SET b.quantityAvailable = b.quantityAvailable - NEW.quantityReserved ,
            b.quantityBorrowed = b.quantityBorrowed + NEW.quantityReserved
    WHERE isbn = NEW.idBook;
END;
//
DELIMITER ;



DELIMITER //
CREATE TRIGGER increment_book_quantity
    AFTER UPDATE ON Reservation
    FOR EACH ROW
BEGIN
    IF NEW.status = 'returned' AND OLD.status = 'borrowed' THEN
    UPDATE book
    SET quantityAvailable = quantityAvailable + NEW.quantityreserved
    WHERE isbn = NEW.idBook;
END IF;
END;
//
DELIMITER ;

