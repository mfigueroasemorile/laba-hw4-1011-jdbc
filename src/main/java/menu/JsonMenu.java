package menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import service.JsonService;
import utils.JAXBParser;
import xsd.SAXValidator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class JsonMenu {

    JsonService service = new JsonService();

    public void displayJsonMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Select an option:");
            System.out.println("1 - Parse json to object");
            System.out.println("2 - Parse object to json");
            System.out.println("0 - Exit");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:

                    System.out.println("Insert json file name: ");
                    String jsonPath = scanner.nextLine();
                    System.out.println("Choose object type:");
                    System.out.println("1. Project");
                    System.out.println("2. Ticket");
                    System.out.println("3. Employee");
                    System.out.println("4. Supplier");
                    System.out.println("5. Product");

                    int objectType = scanner.nextInt();
                    scanner.nextLine();

                    switch (objectType) {
                        case 1:
                            Project project = service.parseJsonToObject(jsonPath, Project.class);
                            System.out.println("Parsed Project: " + project.toString());
                            break;
                        case 2:
                            Ticket ticket = service.parseJsonToObject(jsonPath, Ticket.class);
                            System.out.println("Parsed Ticket: " + ticket.toString());
                            break;
                        case 3:
                            Employee employee = service.parseJsonToObject(jsonPath, Employee.class);
                            System.out.println("Parsed Employee: " + employee.toString());
                            break;
                        case 4:
                            Supplier supplier = service.parseJsonToObject(jsonPath, Supplier.class);
                            System.out.println("Parsed supplier: "+ supplier.toString());
                            break;
                        case 5:
                            Product product = service.parseJsonToObject(jsonPath, Product.class);
                            System.out.println("Parsed supplier: "+ product.toString());
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;
                case 2:
                    service.convertObjectToJson(displayParserMenu());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    displayJsonMenu();
                    break;
            }
        } while (option != 0);

    }

    private <T> T displayParserMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose object to parse:");
        System.out.println("1. Project");
        System.out.println("2. Employee");
        System.out.println("3. Supplier");
        System.out.println("4. Product");
        System.out.println("5. Ticket");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Insert project manager name: ");
                String name = scanner.nextLine();
                System.out.println("Insert project type id: ");
                int type = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Insert address: ");
                String address = scanner.nextLine();
                System.out.println("Insert project client id: ");
                int client = scanner.nextInt();
                Project project = new Project();
                project.setManagerName(name);
                project.setAddress(address);
                project.setProjectTypeId(type);
                project.setClientId(client);
                scanner.nextLine();
                List<Task> taskList = new ArrayList<>();
                System.out.println("Do you want to create a new task? y/n");
                String tasks = scanner.nextLine();
                int idTask = 1001;

                while (tasks.equals("y")) {
                    Task newTask = new Task();
                    System.out.println("Insert task description: ");
                    String description = scanner.nextLine();
                    newTask.setDescription(description);
                    newTask.setIdTask(idTask);

                    taskList.add(newTask);
                    System.out.println("Do you want to create a new task? y/n");
                    tasks = scanner.nextLine();
                    idTask ++;
                }

                if (tasks.equals("n")) {
                    project.setTasks(taskList);

                } else {
                    System.out.println("Invalid option");
                    break;
                }
                return (T) project;
            case 2:
                //scanner.nextLine();
                System.out.println("Insert employee name: ");
                String employeeName = scanner.nextLine();
                System.out.println("Insert address: ");
                String employeeAddress = scanner.nextLine();
                System.out.println("Insert contract id: ");
                int contractId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Insert role id: ");
                int role = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Insert gender: ");
                String gender = scanner.nextLine();

                Employee employee = new Employee();
                employee.setGender(gender);
                employee.setName(employeeName);
                employee.setAddress(employeeAddress);
                employee.setRoleId(role);
                employee.setContractId(contractId);
                return (T) employee;
            case 3:
                scanner.nextLine();
                System.out.println("Insert supplier name: ");
                String supplierName = scanner.nextLine();
                System.out.println("Insert description: ");
                String supplierDescription = scanner.nextLine();
                Supplier supplier = new Supplier();

                supplier.setName(supplierName);
                supplier.setDescription(supplierDescription);
                return (T) supplier;
            case 4:
                System.out.println("Insert description: ");
                String productDesc = scanner.nextLine();
                System.out.println("Insert price: ");
                Float price = scanner.nextFloat();
                System.out.println("Insert supplpier id: ");
                int supId = scanner.nextInt();
                scanner.nextLine();

                Product product = new Product();
                product.setPrice(price);
                product.setDescription(productDesc);
                product.setSupplierId(supId);
                return (T) product;
            case 5:
                System.out.println("Insert total amount: ");
                Float total = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Date: ");
                String date = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                // Parsear el String a LocalDate
                LocalDate localDate = LocalDate.parse(date, formatter);
                Date parsedDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                System.out.println("Insert contract id: ");

                Ticket ticket = new Ticket();
                ticket.setTotal(total);
                ticket.setDate(parsedDate);
                return (T) ticket;
            default:
                System.out.println("Opción inválida.");

        }
        return null;
    }

}
