import database.Connection;
import model.Author;
import model.Book;

import static console.Menu.menu;

public class Main {
    public static void main(String[] args) {

        Author author = new Author();
        author.setId(1);
        author.setName("unconnu");


        Book book = new Book("1878", "Joha", author,"available", 10, 10, 0, 0);
        System.out.println( book.getAuthor());
        //book.addBook();

        //menu();


    }
}