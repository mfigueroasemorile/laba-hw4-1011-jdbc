package menu;

import java.util.Scanner;

public class XMLMenu {

    public void displayXmlMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1 - Create project");
        System.out.println("2 - Create employee");
        System.out.println("2 - Assign employee to project");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                //Create project
                break;
            case 2:
                //Create employee
                break;
            case 3:
                //Assign employee to project
            default:
                System.out.println("Invalid option, try again");
                displayXmlMenu();
                break;
        }
    }
}
