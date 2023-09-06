import database.Connection;
import model.Author;
import model.Book;

import java.sql.SQLException;

import static console.Menu.menu;

public class Main {
    public static void main(String[] args) throws SQLException {

        Author author = new Author();
        author.setId(2);
        author.setName("unconnu2");


        Book book = new Book("21878", "Joha2", author, Book.State.available, 10, 10, 0, 0);

        book.deleteBook();

        //menu();


    }
}