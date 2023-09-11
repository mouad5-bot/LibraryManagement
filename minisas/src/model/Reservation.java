package model;
import database.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
//import java.sql.Date;
import java.lang.String;

public class Reservation {
    private Borrower borrower;
    private Book book;
    private Date dateReservation;
    private Date dateReturn;
    private int quantityReserved;
    private String status;


    public Reservation(){}
    public Reservation(Borrower borrower, Book book, Date dateReservation,  Date dateReturn, int quantityReserved, String status) {
        this.borrower = borrower;
        this.book = book;
        this.dateReservation = dateReservation;
        this.dateReturn = dateReturn;
        this.quantityReserved = quantityReserved;
        this.status = status;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void reserve() throws SQLException {
        if ( book.getQuantityAvailable() > 0) {
            String sql = "INSERT INTO reservation (idBorrower, idBook, dateReservation, dateReturn, quantityReserved, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement =  Connection.connect().prepareStatement(sql);
            preparedStatement.setInt(1, this.borrower.getId());
            preparedStatement.setString(2, this.book.getIsbn());
            preparedStatement.setDate(3, new java.sql.Date(this.dateReservation.getTime()));
            preparedStatement.setDate(4, new java.sql.Date(this.dateReturn.getTime()));
            preparedStatement.setInt(5, this.quantityReserved);
            preparedStatement.setString(6, this.status);

            int rowsUpdate = preparedStatement.executeUpdate();

            System.out.println("THE BOOK HAS BEEN BORROWED SUCCESSFULLY");

        } else if (book.getQuantityAvailable() == 0) {
            System.out.println("No available book !!");
        } else {
            System.out.println("~~~~~~~~~~~  Books are already reserved !!  ~~~~~~~~~~");
        }
    }
    //public void returnBook(){}
}
