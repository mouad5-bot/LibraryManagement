package console;

import java.util.Scanner;

public class Menu {
    public static void menu(){

        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            System.out.print("\u001B[32m");
            clearScreen();
            printHeader();
            System.out.println("\tBonjour !!");
            System.out.println("\tS'il vous plaît, choisissez ce que vous voulez : \n");
            System.out.println("\t01 : Gestion des Livres.");
            System.out.println("\t02 : Gestion des Bénéficaires.");
            System.out.println("\t03 : Donne Le livre.");
            System.out.println("\t04 : Récupérer le livre .");
            System.out.println("\t05 : Changé le mode Passe .");
            System.out.println("\t06 : Les statistiques.");
            System.out.println("\t07 : Quitter l'application.");
            System.out.print("\nVotre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    clearScreen();
                    break;
                case 2:
                    System.out.print("\u000C");
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    try {
                        //function GOODBY
                        Thread.sleep(2000); // Sleep for 2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Choix invalide. Veuillez réessayer.");
                    System.out.print("\u001B[0m");
            }

        } while( choice != 7);

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
        System.out.println("\t \t   &&&#  Library Management  #&&& ");
        System.out.println("\t \t======================================");
        System.out.println("\n");
    }

}