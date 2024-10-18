package menu;

import model.*;
import utils.JAXBParser;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ParseMenu {

    public void displayParseMenu(){

        int option;
        Scanner scanner = new Scanner(System.in);
        JAXBParser parser = new JAXBParser();

            System.out.println("Choose object to parse: ");
            System.out.println("1 - Project");
            System.out.println("2 - Employee");
            System.out.println("3 - Supplier");
            System.out.println("4 - Product");
            System.out.println("5 - Ticket");
            System.out.println("0 - Exit");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    scanner.nextLine();
                    System.out.println("Insert project manager name: ");
                    String name = scanner.nextLine();
                    System.out.println("Insert project type id: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Insert address: ");
                    String address = scanner.nextLine();
                    System.out.println("Insert project client id: ");
                    int client = scanner.nextInt();
                    scanner.nextLine();

                    Project project = new Project();
                    project.setManagerName(name);
                    project.setAddress(address);
                    project.setProjectTypeId(type);
                    project.setClientId(client);

                    parser.parse(project);
                    break;
                case 2:
                    scanner.nextLine();
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

                    parser.parse(employee);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Insert supplier name: ");
                    String supplierName = scanner.nextLine();
                    System.out.println("Insert description: ");
                    String supplierDescription = scanner.nextLine();
                    Supplier supplier = new Supplier();

                    supplier.setName(supplierName);
                    supplier.setDescription(supplierDescription);
                    parser.parse(supplier);
                    break;
                case 4:
                    scanner.nextLine();
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
                    parser.parse(product);
                    break;
                case 5:
                    scanner.nextLine();
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
                    parser.parse(ticket);
                    break;
            }
    }
}
