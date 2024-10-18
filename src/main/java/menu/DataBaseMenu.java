package menu;

import service.DataBaseMenuService;

import java.util.Scanner;

public class DataBaseMenu {

    public void displayDbMenu(){
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Select an option:");
            System.out.println("1 - Create project");
            System.out.println("2 - Create employee");
            System.out.println("3 - Assign employee to project");
            System.out.println("4 - Create supplier");
            System.out.println("5 - Create product");
            System.out.println("6 - Print existing projects");

            option = scanner.nextInt();
            DataBaseMenuService dbService = new DataBaseMenuService();

            switch (option) {
                case 1:
                    dbService.createProject();
                    break;
                case 2:
                    dbService.createEmployee();
                    break;
                case 3:
                    //Assign employee to project
                    dbService.assignEmployee();
                    break;
                case 4:
                    //Create supplier
                    dbService.createSupplier();
                    break;
                case 5:
                    //Create product
                    dbService.createProduct();
                    break;
                case 6:
                    //Assign product to supplier
                    dbService.getAllProjects();
                case 0:
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    displayDbMenu();
                    break;
            }
        } while (option !=0);
    }
}
