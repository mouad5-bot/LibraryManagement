import database.Connection;
import model.Author;
import model.Book;

import java.sql.SQLException;

import static console.Menu.menu;

public class Main {
    public static void main(String[] args) throws SQLException {

        Author author = new Author();
        author.setId(1);
        author.setName("unconnu");


        Book book = new Book("1878", "Joha", author, Book.State.available, 9, 10, 0, 0);

        book.updateDataOfBook();

        //menu();


    }
}