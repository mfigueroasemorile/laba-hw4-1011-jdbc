package menu;

import java.util.Scanner;

public class GeneralMenu {

    public void displayGeneralMenu (){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1 - Database");
        System.out.println("2 - XML");
        System.out.println("3 - Json");
        System.out.println("4 - MyBatis");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                displayDatabaseMenu();
                break;
            case 2:
                displayXMLMenu();
                break;
            case 3:
                displayJsonMenu();
                break;
            case 4:
                displayMyBatisMenu();
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

    private void  displayJsonMenu(){
        JsonMenu jsonMenu = new JsonMenu();
        jsonMenu.displayJsonMenu();
    }

    private void displayMyBatisMenu(){
        MyBatisMenu myBatisMenu = new MyBatisMenu();
        myBatisMenu.displayMenu();
    }
}
