package menu;

import utils.JAXBParser;
import xsd.SAXValidator;

import java.util.Scanner;

public class XMLMenu {

    public void displayXmlMenu() {
        Scanner scanner = new Scanner(System.in);
        SAXValidator validator = new SAXValidator();
        JAXBParser jaxbParser = new JAXBParser();
        ParseMenu parseMenu = new ParseMenu();
        int option;
        do {
            System.out.println("Select an option:");
            System.out.println("1 - Validate xml");
            System.out.println("2 - Parse xml");
            System.out.println("3 - Convert object to XML using JAXB");
            System.out.println("4 -  XML to object using JAXB");
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
                case 2:
                    System.out.println("Insert xml file name: ");
                    String xmlParsePath = scanner.nextLine();
                    System.out.println("Parsing "+ xmlParsePath);
                    validator.parse(xmlParsePath);
                    break;
                case 3:
                    parseMenu.displayParseMenu();
                    //jaxbParser.parse();
                    break;
                case 4:
/*                    System.out.println("Insert");
                    String xmlUnmarshallPath = scanner.nextLine();
                    jaxbParser.convertFromXML();*/
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