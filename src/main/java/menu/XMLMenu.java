package menu;

import xsd.SAXValidator;

import java.util.Scanner;

public class XMLMenu {

    public void displayXmlMenu() {
        Scanner scanner = new Scanner(System.in);
        SAXValidator validator = new SAXValidator();
        int option;
        do {
            System.out.println("Select an option:");
            System.out.println("1 - Validate xml");
            System.out.println("0 - Exit");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    //Validate xml
                    System.out.println("Insert xml file name: ");
                    String xmlPath = scanner.nextLine();
                    System.out.println("Insert xsd file name: ");
                    String xsdPath = scanner.nextLine();
                    validator.validate(xsdPath, xmlPath);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    displayXmlMenu();
                    break;
            }



        } while (option != 0) ;
    }
}