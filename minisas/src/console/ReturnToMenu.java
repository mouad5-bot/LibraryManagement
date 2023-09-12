package console;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import static console.Menu.menu;

public class ReturnToMenu {
    public void getMenu() throws SQLException {
        System.out.println("Do you want to return to the menu :");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1){
            menu();
        }
    }
}
