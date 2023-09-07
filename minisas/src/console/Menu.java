package console;
import model.Book;
import model.Author;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            System.out.print("\u001B[32m"); //for green color
            clearScreen();
            printHeader();
            System.out.println("\tBonjour !!");
            System.out.println("\tChoose a number of your choice: \n");
            System.out.println("\t01 : Book Management");
            System.out.println("\t02 : Search For a Book.");
            System.out.println("\t03 : Management of loans and returns.");
            System.out.println("\t04 : Change Password .");
            System.out.println("\t05 : Statistics.");
            System.out.println("\t06 : Exit The Application.");
            System.out.print("\nYour choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("\tChoose a number of your choice: \n");
                        System.out.println("\t01 : Add a Book");
                        System.out.println("\t02 : Display a list of Books");
                        System.out.println("\t03 : edit a Book");
                        System.out.println("\t04 : Delete a Book");
                        System.out.println("\t05 : Exit The Application");
                        System.out.print("\nYour choice : ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Please enter the coming parameters :");
                                System.out.println("isbn of Book : ");
                                String isbn = scanner.next();
                                System.out.println("Title of Book : ");
                                String title = scanner.next();
                                System.out.println("Author of Book : ");
                                String authorName = scanner.next();
                                System.out.println("Quantity of Book : ");
                                int quantity = scanner.nextInt();
                                int quantityBorrowed = 0;
                                int quantityAvailable = quantity;
                                int quantityLost = 0;

                                Author author = new Author(authorName);
//                                author.setId(null);
                                author.setName(authorName);

                                Book book = new Book(isbn, title, author, Book.State.available, quantity, quantityBorrowed, quantityAvailable, quantityLost);

                                book.addBook();

                                break;
                            case 2:
                                System.out.println("Display Books");
                                break;
                            case 3:
                                System.out.println("Edit a Book");
                                break;
                            case 4:
                                System.out.println("Pleas enter the isbn of the book that you wanna delete :");
                                String isbn_ = scanner.next();
                                Book book_ = new Book();
                                book_.setIsbn(isbn_);
                                book_.deleteBook();
                                break;
                            case 5:
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.exit(0);
                                break;
                            default:
                                System.out.println("\n Invalid choice. Try Again.");
                                System.out.print("\u001B[0m");
                        }
                    } while (choice >= 5);


                    clearScreen();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Invalid choice. Try Again.");
                    System.out.print("\u001B[0m");
            }

        } while( choice >= 6);

    }

    // Clear the screen (works for most consoles)
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // Print header
    public static void printHeader() {
        clearScreen();
        System.out.println("\t \t======================================");
        System.out.println("\t \t # --- Library Management --- #  ");
        System.out.println("\t \t======================================");
        System.out.println("\n");
    }

}