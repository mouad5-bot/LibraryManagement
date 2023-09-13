package console;
import model.*;

import java.util.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Menu {
    public static void menu() throws SQLException {

        Reservation rev ;
        ReturnToMenu backToMenu = new ReturnToMenu();

        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            System.out.print("\u001B[32m"); //for green color
            clearScreen();
            printHeader();
            System.out.println("\tBonjour !!");
            System.out.println("\tChoose a number of your choice: \n");
            System.out.println("\t01 : Book Management");
            System.out.println("\t02 : Search For a Book");
            System.out.println("\t03 : Management of loans and returns");
            System.out.println("\t04 : Statistics");
            System.out.println("\t05 : Exit The Application");
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
                                System.out.println("Please Enter The Name Of Author :");
                                String AuthorName = scanner.next();

                                System.out.println("Please enter the coming parameters :");
                                System.out.println("isbn of Book : ");
                                String isbn = scanner.next();
                                System.out.println("Title of Book : ");
                                String title = scanner.next();

                                System.out.println("Please choose the ID of the author of this Book : ");

                                String authorId = scanner.next();
                                System.out.println("Quantity of Book : ");
                                int quantity = scanner.nextInt();
                                int quantityBorrowed = 0;
                                int quantityAvailable = quantity;
                                int quantityLost = 0;

                                Author author = new Author(AuthorName);
                                author.addAuthor();
                                Book book = new Book(isbn, title, author, Book.State.available, quantity, quantityBorrowed, quantityAvailable, quantityLost);
                                book.addBook();

                                backToMenu.getMenu();
                                break;
                            case 2:
                                System.out.println("Display Books");
                                Book book_1 = new Book();
                                book_1.getAllBooks();

                                backToMenu.getMenu();
                                break;
                            case 3:
                                System.out.println("######### Edit a Book ######### ");
                                System.out.println("Please enter the isbn of book that you wanna edit :");

                                String isbn_ = scanner.next();
                                Book bookData = new Book();
                                bookData = bookData.getBook(isbn_);

                                System.out.println("Enter new or old isbn :");
                                bookData.setIsbn(scanner.next());

                                System.out.println("Enter new or old Title :");
                                bookData.setTitle(scanner.next());

                                Author authorEdit = new Author();
                                System.out.println("Enter new or old Author name :");
                                String name = scanner.next();
                                authorEdit.searchAuthor(name);
                                System.out.println("now enter the id of the author that you wanna edit ");
                                int idPerson = scanner.nextInt();
                                authorEdit.setId(authorEdit.findAuthorId(idPerson));

                                Book bookEdit = new Book();
                                bookEdit.updateDataOfBook(isbn_);

                                backToMenu.getMenu();
                                break;
                            case 4:
                                System.out.println("Pleas enter the isbn of the book that you wanna delete :");
                                Book book__ = new Book();
                                String isbn__ = scanner.next();
                                book__.setIsbn(isbn__);
                                System.out.print("\u001B[40m");
                                System.out.println("Are you sure you wanna delete this book: \n1. Yes\n2. No");
                                System.out.print("\u001B[0m");
                                int x = scanner.nextInt();
                                if(x == 1){
                                    book__.deleteBook();
                                }else{
                                    menu();
                                }

                                backToMenu.getMenu();
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
                    Book book = new Book();
                    System.out.println("------- SEARCH FOR A BOOK --------");
                    System.out.println("Do you want to search book by an author or a title ?");
                    System.out.println("1. by author");
                    System.out.println("2. by title");
                    int x = scanner.nextInt();
                    String title="";
                    String authorName="";
                    if (x==1){
                        System.out.println("Enter the author name : ");
                        authorName = scanner.next();
                        book.searchBookByTitle(title, authorName);
                    }else if(x==2){
                        System.out.println("Enter the title of book : ");
                        title = scanner.next();
                        book.searchBookByTitle(title, authorName);
                    }

                    backToMenu.getMenu();
                    break;
                case 3:
                    System.out.println("########## Management of loans and returns. ########## \n");
                    System.out.println("Choose a numbre of your choice :");
                    System.out.println("01 : Borrow a book");
                    System.out.println("02 : return a book");
                    choice = scanner.nextInt();
                    do{
                        switch (choice){
                            case 1 :
                                System.out.println("----- Borrow a book -----");

                                Book book_1 = new Book();
                                Borrower bookBorrower_ = new Borrower();

                                System.out.println("Please enter the borrower name : ");
                                String borrowerName = scanner.next();
                                bookBorrower_.searchBorrower(borrowerName);

                                System.out.println("Now enter the id of borrower you choose from the list : ");
                                int personId = scanner.nextInt();
                                int BorrowerId = bookBorrower_.findBorrowerById(personId) ;
                                if(BorrowerId != 0){
                                    bookBorrower_.setId(BorrowerId);
                                }

                                System.out.println("Please enter the isbn of the book : ");
                                String isbn = scanner.next();
                                Book bookData = book_1.getBook(isbn);

                                Date dateReservation = new Date();

                                System.out.println("Please enter the date that the book will be returned (yyyy-MM-dd):  ");
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String dateString = scanner.next();
                                Date dateReturn = null;
                                try {
                                    dateReturn = dateFormat.parse(dateString);
                                    if (dateReservation.before(dateReturn)) {
                                        System.out.print("\u001B[34m");
                                        System.out.println("You entered: " + dateReturn);
                                        System.out.print("\u001B[0m");
                                        System.out.print("\u001B[32m");
                                    } else {
                                        while (dateReservation.after(dateReturn)) {
                                            System.out.println("Invalid return date. The return date should be after the reservation date.");
                                            System.out.println("Please insert a valid date of return (yyyy-MM-dd): ");
                                            dateString = scanner.next();
                                            dateReturn = dateFormat.parse(dateString);
                                        }
                                        System.out.print("\u001B[34m");
                                        System.out.println("You entered: " + dateReturn);
                                        System.out.print("\u001B[0m");
                                        System.out.print("\u001B[32m");
                                    }
                                } catch (ParseException e) {
                                    System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
                                }

                                System.out.println("Please enter the quantity that will be borrowed :");
                                int qnt = scanner.nextInt();

                                int qntAvailable = bookData.getQuantity() - qnt;

                                bookData.setQuantityAvailable(qntAvailable);
                                bookBorrower_.setId(BorrowerId);

                                rev = new Reservation(bookBorrower_, bookData, dateReservation, dateReturn, qnt, "borrowed") ;
                                rev.reserve();

                                backToMenu.getMenu();
                                break;
                            case 2 :
                                System.out.println("----- Return a book -----");

                                Borrower borrower = new Borrower();
                                Reservation reservation = new Reservation();

                                System.out.println("Please enter the name of borrower who borrowed the book :");
                                String nameBorrower = scanner.next();
                                borrower.searchBorrower(nameBorrower);

                                System.out.println("Now enter the id of borrower you choose from the list : ");
                                int personId_ = scanner.nextInt();
                                int BorrowerId_ = borrower.findBorrowerById(personId_);
                                if(BorrowerId_ != 0){
                                    borrower.setId(BorrowerId_);
                                }

                                reservation.getReservationByBorrowerId(BorrowerId_);

                                System.out.println("Now enter please the id of the reservation from the list: ");
                                int idReservation = scanner.nextInt();
                                reservation.updateReservation(idReservation);
                                System.out.println("THE BOOK HAS BEEN RETURNED SUCCESSFULLY");

                                backToMenu.getMenu();
                                break;
                            case 3:
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
                    } while (choice >= 3);
                    break;
                case 4:
                    System.out.println("------------ Statistics -------------");
                    Book bookStatistic = new Book();
                    bookStatistic.printStatistics();

                    backToMenu.getMenu();
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

        } while( choice >= 5);

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void printHeader() {
        clearScreen();
        System.out.println("\t \t======================================");
        System.out.println("\t \t # --- Library Management --- #  ");
        System.out.println("\t \t======================================");
        System.out.println("\n");
    }

}