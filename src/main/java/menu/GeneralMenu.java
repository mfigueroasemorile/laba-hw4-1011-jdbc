package menu;

import java.util.Scanner;

public class GeneralMenu {

    public void displayGeneralMenu (){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1 - Database");
        System.out.println("2 - XML");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                displayDatabaseMenu();
                break;
            case 2:
                displayXMLMenu();
                break;
            default:
                System.out.println("Invalid option, try again");
                displayGeneralMenu();
                break;
        }
    }


    private void displayDatabaseMenu() {
        DataBaseMenu dbMenu = new DataBaseMenu();
        dbMenu.displayDbMenu();
    }

    private void displayXMLMenu() {

        XMLMenu xmlMenu = new XMLMenu();
        xmlMenu.displayXmlMenu();
    }
}
