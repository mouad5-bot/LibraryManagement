package model;
import database.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;


public class Book{
    private String isbn;
    private String title;
    private Author author;
    private State stateOfBook;
    private int quantity;
    private int quantityAvailable;
    private int quantityBorrowed;
    private int quantityLost;


    public Book () {}
    public Book(String isbn, String title, Author author, State stateOfBook, int quantity, int quantityAvailable,int quantityBorrowed, int quantityLost) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.stateOfBook = stateOfBook;
        this.quantity = quantity;
        this.quantityAvailable = quantityAvailable;
        this.quantityBorrowed = quantityBorrowed;
        this.quantityLost = quantityLost;
    }
    public enum State{
        available,
        unavailable
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public State getStateOfBook() {
        return stateOfBook;
    }

    public void setStateOfBook(State stateOfBook) {
        this.stateOfBook = stateOfBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityBorrowed() {
        return quantityBorrowed;
    }

    public void setQuantityBorrowed(int quantityBorrowed) {
        this.quantityBorrowed = quantityBorrowed;
    }

    public int getQuantityLost() {
        return quantityLost;
    }

    public void setQuantityLost(int quantityLost) {
        this.quantityLost = quantityLost;
    }


    public Book addBook() throws SQLException {
        String sql = "INSERT INTO Book (isbn, title, idAuthor, quantity, stateOfBook, quantityBorrowed, quantityAvailable, quantityLost) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement =  Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1, this.isbn);
        preparedStatement.setString(2, this.title);
        preparedStatement.setInt(3, this.author.getId());
        preparedStatement.setInt(4, this.quantity);
        preparedStatement.setString(5, this.stateOfBook.toString());
        preparedStatement.setInt(6, this.quantityBorrowed);
        preparedStatement.setInt(7, this.quantityAvailable);
        preparedStatement.setInt(8, this.quantityLost);

        int rowsUpdate = preparedStatement.executeUpdate();

        return this; //return the current obj
    }
    public void updateDataOfBook() throws SQLException {
        String sql = "UPDATE Book SET isbn=?, title=?, idAuthor=?,  quantity=?, stateOfBook=?,  quantityBorrowed=?, quantityAvailable=?, quantityLost=? WHERE isbn=?";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1, this.isbn);
        preparedStatement.setString(2, this.title);
        preparedStatement.setInt(3, this.author.getId());
        preparedStatement.setInt(4, this.quantity);
        preparedStatement.setString(5, this.stateOfBook.toString());
        preparedStatement.setInt(6, this.quantityBorrowed);
        preparedStatement.setInt(7, this.quantityAvailable);
        preparedStatement.setInt(8, this.quantityLost);
        preparedStatement.setString(9, this.isbn);


        preparedStatement.executeUpdate();
    }
    public void deleteBook() throws SQLException {
        String sql = "DELETE FROM Book WHERE isbn=?";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1, this.isbn);

        preparedStatement.executeUpdate();
    }
    public void searchBookByTitle(String title){

        try {
            //String sql="SELECT * FROM book b inner join person p  WHERE b.title like ? OR a.name like ?";
            String sql="SELECT *  book  WHERE title like ?";
            PreparedStatement statement = Connection.connect().prepareStatement(sql);
            statement.setString(1, "%" + title + "%" );
            //statement.setString(2, "%" + author.getName() + "%");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title_ =  resultSet.getString("title");
                int author_id = resultSet.getInt("idAuthor");
                String state_ =  resultSet.getString("stateOfBook");
                int qtn = resultSet.getInt("quantity");
                int qtnBrr = resultSet.getInt("quantityBorrowed");
                int qtnAv = resultSet.getInt("quantityAvailable");
                int qtnLost = resultSet.getInt("quantityLost");

                System.out.println("isbn: " + isbn + ", Title: " + title_ + ", Author: " + author_id + ", State of book: " + state_ + ", Total Quantity: " + qtn + ", Quantity Borrowed: " + qtnBrr + ", Quantity Available: " + qtnAv + ", Quantity Lost: " + qtnLost);


            } else {
                System.out.println("No book with this title");
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());

        }
    }

    public void getAllBooks() throws SQLException {

            String sql="SELECT * FROM book";
        PreparedStatement statement = Connection.connect().prepareStatement(sql);

        ResultSet res = statement.executeQuery(sql);

            while (res.next()) {
                System.out.println("isbn: " + res.getString("isbn") + "Title: " + res.getString("title") + "Quantity: " + res.getInt("quantity")   );
            }

    }

    //public ArrayList<Book> readBorrowedBooks(){}
}
