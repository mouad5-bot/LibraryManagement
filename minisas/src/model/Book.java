package model;
import database.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Date dateAddingBook;
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
        String sql = "INSERT INTO Book (isbn, title, idAuthor, quantity, stateOfBook, quantityBorrowed, quantityAvailable, quantityLost)" + "" +
                "VALUES (?, ?, ?, ?, 'available', ?, ?, ?)";
        PreparedStatement preparedStatement =  Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1, this.isbn);
        preparedStatement.setString(2, this.title);
        preparedStatement.setInt(3, this.author.getId());
        preparedStatement.setInt(4, this.quantity);
        preparedStatement.setInt(5, this.quantityBorrowed);
        preparedStatement.setInt(6, this.quantityAvailable);
        preparedStatement.setInt(7, this.quantityLost);

        ResultSet resultSet = preparedStatement.executeQuery();

        return this; //return the current obj
    }
//    public void editDataOfBook(String newIsbn, String newTitle, int newQuantity, int newQuantityBorrowed, int newQuantityAvailable, int newQuantityLost) throws SQLException {
//        String sql = "UPDATE Book SET isbn=?, title=?, quantity=?, quantityBorrowed=?, quantityAvailable=?, quantityLost=? WHERE isbn=?";
//        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
//        preparedStatement.setString(1, newIsbn);
//        preparedStatement.setString(2, newTitle);
//        preparedStatement.setInt(3, newQuantity);
//        preparedStatement.setInt(4, newQuantityBorrowed);
//        preparedStatement.setInt(5, newQuantityAvailable);
//        preparedStatement.setInt(6, newQuantityLost);
//        preparedStatement.setString(7, this.isbn);
//
//        preparedStatement.executeUpdate();
//    }

    public void updateDataOfBook(){}
    public boolean deleteBook(){
        return true;
    }
//    public Book searchForBook(){
//    }
    public ArrayList<Book> readBooksDisponible() {
        ArrayList<Book> disponibleBooks = new ArrayList<>();

        return disponibleBooks;
    }
    //public ArrayList<Book> readBorrowedBooks(){}
}
