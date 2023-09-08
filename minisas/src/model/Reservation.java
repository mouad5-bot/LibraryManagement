package model;
import database.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.Date;
import java.sql.Date;
import java.lang.String;

public class Reservation {
    private Borrower borrower;
    private Book book;
    private Date dateReservation;
    private Date dateReturn;
    private int quantityReserved;


    public Reservation(Borrower borrower, Book book, Date dateReturn, int quantityReserved) {
        this.borrower = borrower;
        this.book = book;
        this.dateReservation = null; //null untel reserved
        this.dateReturn = dateReturn;
        this.quantityReserved = quantityReserved;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
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

    public int getQuantityReserved() {
        return quantityReserved;
    }

    public void setQuantityReserved(int quantityReserved) {
        this.quantityReserved = quantityReserved;
    }

    public void reserve() throws SQLException {
        if ( book.getQuantityAvailable() > 0) {
            String sql = "INSERT INTO reservation (idBorrower, idBook, dateReservation, dateReturn, quantityReserved) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement =  Connection.connect().prepareStatement(sql);
            preparedStatement.setInt(1, this.borrower.id);
            preparedStatement.setString(2, this.book.getIsbn());
            preparedStatement.setDate(3,  this.dateReservation);
            preparedStatement.setDate(4, this.dateReturn);
            preparedStatement.setInt(5, this.quantityReserved);

            int rowsUpdate = preparedStatement.executeUpdate();
        } else if (book.getQuantityAvailable() == 0) {
            System.out.println("No available book !!");
        } else {
            System.out.println("Books are already reserved !!");
        }
    }
    //public void returnBook(){}
}
