DELIMITER //
CREATE TRIGGER decrement_book_quantity
    AFTER INSERT ON Reservation
    FOR EACH ROW
BEGIN
    UPDATE book
    SET quantityAvailable = quantityAvailable - NEW.quantityReserved , quantityBorrowed = quantityBorrowed + NEW.quantityReerved
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
    SET quantityAvailable = quantity + NEW.quantityreserved
    WHERE isbn = NEW.isbn;
END IF;
END;
//
DELIMITER ;


