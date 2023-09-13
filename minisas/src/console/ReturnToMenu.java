package console;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import static console.Menu.menu;

public class ReturnToMenu {
    public void getMenu() throws SQLException {
        System.out.print("\u001B[34m");
        System.out.println("Do you want to return to the menu :");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[32m");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1){
            menu();
        }
    }
}
