import java.util.ArrayList;

public class Book{
    private String isbn;
    private String title;
    private Author author;
    private State stateOfBook;
    private int quantity;
    private int numberLost;

    public enum State{
        available,
        borrowed,
        lost
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

    public Author getIdAuthor() {
        return author;
    }

    public void setIdAuthor(Author author) {
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

    public int getNumberLost() {
        return numberLost;
    }

    public void setNumberLost(int numberLost) {
        this.numberLost = numberLost;
    }

    public Book addBook(){
        return new Book();
    }
    public void editDataOfBook(){}
    public void updateDataOfBook(){}
    public boolean deleteBook(){}
    public Book searchForBook(){}
    public ArrayList<Book> readBooksDisponible() {
        ArrayList<Book> disponibleBooks = new ArrayList<>();

        return disponibleBooks;
    }
    public ArrayList<Book> readBorrowedBooks(){}
}
