import java.util.Date;
import java.lang.String;

public class Reservation {
    private Borrower borrower;
    private Book book;
    private String isbn;
    private Date dateReservation;
    private Date dateReturn;


    public Reservation(Borrower borrower, Book book, String isbn, Date dateReservation, Date dateReturn) {
        this.borrower = borrower;
        this.book = book;
        this.isbn = isbn;
        this.dateReservation = dateReservation;
        this.dateReturn = dateReturn;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public void reserve(){}
}
