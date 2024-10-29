package menu;

import dao.IDao;
import model.*;
import mybatis.EmployeeMapper;
import service.*;
import utils.AbstractFactory;
import utils.Factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class MyBatisMenu {

    public void displayMenu() {


        AbstractFactory factory = new Factory();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Select an object to work with:");
            System.out.println("1 - Project");
            System.out.println("2 - Product");
            System.out.println("3 - Supplier");
            System.out.println("4 - Employee");
            System.out.println("5 - Ticket");
            System.out.println("0 - Exit");
            option = scanner.nextInt();
            scanner.nextLine();
            int operation;
            switch (option) {
                case 1:
                    IDao projectService = new MyBatisProjectServiceImpl();
                    System.out.println("Select which operation do you want to execute:");
                    System.out.println("1 - Create project");
                    System.out.println("2 - Update proyect");
                    System.out.println("3 - Delete project");
                    System.out.println("4 - Get project by id");
                    System.out.println("0 - Go back");
                    operation = scanner.nextInt();
                    scanner.nextLine();
                    switch (operation) {
                        case 1:
                            System.out.println("Insert manager name: ");
                            String managerName = scanner.nextLine();
                            System.out.println("Insert address: ");
                            String address = scanner.nextLine();
                            System.out.println("Insert proyect type id: ");
                            int typeId = scanner.nextInt();
                            System.out.println("Insert client id: ");
                            int clientId = scanner.nextInt();

                            Project project = factory.createProject(managerName,address,typeId,clientId);

                            projectService.insertElement(project);
                            break;
                        case 2:
                            System.out.println("Insert project id to update: ");
                            int idProject = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                Project oldProject = (Project) projectService.getElement(idProject);

                                System.out.println("Insert manager name (press Enter to keep current: " + oldProject.getManagerName() + "):");
                                String newManagerName = scanner.nextLine();
                                if (newManagerName.isEmpty()) {
                                    newManagerName = oldProject.getManagerName();
                                }

                                System.out.println("Insert address (press Enter to keep current: " + oldProject.getAddress() + "):");
                                String newAddress = scanner.nextLine();
                                if (newAddress.isEmpty()) {
                                    newAddress = oldProject.getAddress();
                                }

                                System.out.println("Insert project type id (press Enter to keep current: " + oldProject.getProjectTypeId() + "):");
                                String newTypeIdInput = scanner.nextLine();
                                int newTypeId;
                                if (newTypeIdInput.isEmpty()) {
                                    newTypeId = oldProject.getProjectTypeId();
                                } else {
                                    newTypeId = Integer.parseInt(newTypeIdInput);
                                }

                                System.out.println("Insert client id (press Enter to keep current: " + oldProject.getClientId() + "):");
                                String newClientIdInput = scanner.nextLine();
                                int newClientId;
                                if (newClientIdInput.isEmpty()) {
                                    newClientId = oldProject.getClientId();
                                } else {
                                    newClientId = Integer.parseInt(newClientIdInput);
                                }

                                Project updatedProject = factory.createProject(newManagerName,newAddress,newTypeId,newClientId);
                                updatedProject.setIdProject(idProject);
                                projectService.updateElement(updatedProject);

                            } catch (Exception e){
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.out.println("Insert project id to delete: ");
                            int deleteProjectId = scanner.nextInt();
                            scanner.nextLine();
                            projectService.deleteElement(deleteProjectId);
                            break;

                        case 4:
                            System.out.println("Insert project id: ");
                            int projectId = scanner.nextInt();
                            scanner.nextLine();
                            projectService.getElement(projectId);
                            break;
                    }
                    break;
                case 2:
                    IDao productService = new MyBatisProductServiceImpl();
                    System.out.println("Select which operation do you want to execute:");
                    System.out.println("1 - Create product");
                    System.out.println("2 - Update product");
                    System.out.println("3 - Delete product");
                    System.out.println("4 - Get product by id");
                    System.out.println("0 - Go back");
                    operation = scanner.nextInt();
                    scanner.nextLine();
                    switch (operation) {
                        case 1:
                            System.out.println("Insert description: ");
                            String description = scanner.nextLine();
                            System.out.println("Insert price: ");
                            Float price = scanner.nextFloat();
                            System.out.println("Insert supplier id: ");
                            int supplierId = scanner.nextInt();

                            Product product = factory.createProduct(description, price, supplierId);
                            productService.insertElement(product);
                            break;
                        case 2:
                            System.out.println("Insert product id to update: ");
                            int idProduct = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                Product oldProduct = (Product) productService.getElement(idProduct);

                                System.out.println("Insert description (press Enter to keep current: " + oldProduct.getDescription() + "):");
                                String newDescription = scanner.nextLine();
                                if (newDescription.isEmpty()) {
                                    newDescription = oldProduct.getDescription();
                                }

                                System.out.println("Insert price (press Enter to keep current: " + oldProduct.getPrice() + "):");
                                String newPriceInput = scanner.nextLine();
                                float newPrice;
                                if (newPriceInput.isEmpty()) {
                                    newPrice = oldProduct.getPrice();
                                } else {
                                    newPrice = Float.parseFloat(newPriceInput);
                                }

                                System.out.println("Insert supplier id (press Enter to keep current: " + oldProduct.getSupplierId() + "):");
                                String newSupplierIdInput = scanner.nextLine();
                                int newSupplierId;
                                if (newSupplierIdInput.isEmpty()) {
                                    newSupplierId = oldProduct.getSupplierId();
                                } else {
                                    newSupplierId = Integer.parseInt(newSupplierIdInput);
                                }


                                Product updatedProduct = factory.createProduct(newDescription, newPrice, newSupplierId);
                                updatedProduct.setIdProduct(idProduct);

                                productService.updateElement(updatedProduct);

                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.out.println("Insert product id to delete: ");
                            int deleteProductId = scanner.nextInt();
                            scanner.nextLine();
                            productService.deleteElement(deleteProductId);
                            break;
                        case 4:
                            System.out.println("Insert product id: ");
                            int productId = scanner.nextInt();
                            scanner.nextLine();
                            productService.getElement(productId);
                            break;
                    }
                    break;
                case 3:
                    IDao supplierService = new MyBatisSupplierServiceImpl();
                    System.out.println("Select which operation do you want to execute:");
                    System.out.println("1 - Create supplier");
                    System.out.println("2 - Update supplier");
                    System.out.println("3 - Delete supplier");
                    System.out.println("4 - Get supplier by id");
                    System.out.println("0 - Go back");
                    operation = scanner.nextInt();
                    scanner.nextLine();
                    switch (operation) {
                        case 1:
                            System.out.println("Insert name: ");
                            String name = scanner.nextLine();
                            System.out.println("Insert description: ");
                            String description = scanner.nextLine();

                            Supplier supplier = factory.createSupplier(name, description);
                            supplierService.insertElement(supplier);
                            break;
                        case 2:
                            System.out.println("Insert supplier id to update: ");
                            int idSupplier = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                Supplier oldSupplier = (Supplier) supplierService.getElement(idSupplier);

                                System.out.println("Insert name (press Enter to keep current: " + oldSupplier.getName() + "):");
                                String newName = scanner.nextLine();
                                if (newName.isEmpty()) {
                                    newName = oldSupplier.getName();
                                }

                                System.out.println("Insert description (press Enter to keep current: " + oldSupplier.getDescription() + "):");
                                String newDescription = scanner.nextLine();
                                if (newDescription.isEmpty()) {
                                    newDescription = oldSupplier.getName();
                                }


                                Supplier updatedSupplier = factory.createSupplier(newName,newDescription);
                                updatedSupplier.setIdSupplier(idSupplier);

                                supplierService.updateElement(updatedSupplier);

                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.out.println("Insert supplier id to delete: ");
                            int deleteSupplierId = scanner.nextInt();
                            scanner.nextLine();
                            supplierService.deleteElement(deleteSupplierId);
                            break;
                        case 4:
                            System.out.println("Insert supplier id: ");
                            int supplierId = scanner.nextInt();
                            scanner.nextLine();
                            supplierService.getElement(supplierId);
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 4:
                    IDao employeeService = new MyBatisEmployeeServiceImpl();
                    System.out.println("Select which operation do you want to execute:");
                    System.out.println("1 - Create employee");
                    System.out.println("2 - Update employee");
                    System.out.println("3 - Delete employee");
                    System.out.println("4 - Get employee by id");
                    System.out.println("0 - Go back");
                    operation = scanner.nextInt();
                    scanner.nextLine();
                    switch (operation) {
                        case 1:
                            System.out.println("Insert name: ");
                            String name = scanner.nextLine();

                            System.out.println("Insert address: ");
                            String address = scanner.nextLine();

                            System.out.println("Insert role id: ");
                            int roleId = scanner.nextInt();

                            System.out.println("Insert contract id: ");
                            int contractId = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Insert gender: ");
                            String gender = scanner.nextLine();

                            Employee employee = factory.createEmployee(name,address,roleId,contractId,gender);
                            employeeService.insertElement(employee);
                            break;
                        case 2:
                            System.out.println("Insert employee id to update: ");
                            int idEmployee = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                Employee oldEmployee = (Employee) employeeService.getElement(idEmployee);

                                System.out.println("Insert name (press Enter to keep current: " + oldEmployee.getName() + "):");
                                String newName = scanner.nextLine();
                                if (newName.isEmpty()) {
                                    newName = oldEmployee.getName();
                                }

                                System.out.println("Insert address (press Enter to keep current: " + oldEmployee.getAddress() + "):");
                                String newAddress = scanner.nextLine();
                                if (newAddress.isEmpty()) {
                                    newAddress = oldEmployee.getAddress();
                                }

                                System.out.println("Insert role id (press Enter to keep current: " + oldEmployee.getRoleId() + "):");
                                String newRoleIdInput = scanner.nextLine();
                                int newRoleId;
                                if (newRoleIdInput.isEmpty()) {
                                    newRoleId = oldEmployee.getRoleId();
                                } else {
                                    newRoleId = Integer.parseInt(newRoleIdInput);
                                }

                                System.out.println("Insert contract id (press Enter to keep current: " + oldEmployee.getContractId() + "):");
                                String newContractIdInput = scanner.nextLine();
                                int newContractId;
                                if (newContractIdInput.isEmpty()) {
                                    newContractId = oldEmployee.getContractId();
                                } else {
                                    newContractId = Integer.parseInt(newContractIdInput);
                                }

                                System.out.println("Insert gender (press Enter to keep current: " + oldEmployee.getGender() + "):");
                                String newGender = scanner.nextLine();
                                if (newGender.isEmpty()) {
                                    newGender = oldEmployee.getGender();
                                }

                                Employee updatedEmployee = factory.createEmployee(newName, newAddress, newRoleId, newContractId, newGender);
                                updatedEmployee.setIdEmployee(idEmployee);

                                employeeService.updateElement(updatedEmployee);

                            } catch (Exception e){
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.out.println("Insert employee id to delete: ");
                            int deleteEmployeeId = scanner.nextInt();
                            scanner.nextLine();
                            employeeService.deleteElement(deleteEmployeeId);
                            break;
                        case 4:
                            System.out.println("Insert employee id: ");
                            int employeeId = scanner.nextInt();
                            scanner.nextLine();
                            employeeService.getElement(employeeId);
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 5:
                    IDao ticketService = new MyBatisTicketServiceImpl();
                    System.out.println("Select which operation do you want to execute:");
                    System.out.println("1 - Create ticket");
                    System.out.println("2 - Update ticket");
                    System.out.println("3 - Delete ticket");
                    System.out.println("4 - Get ticket by id");
                    System.out.println("0 - Go back");
                    operation = scanner.nextInt();
                    scanner.nextLine();
                    switch (operation) {
                        case 1:
                            System.out.println("Insert total: ");
                            Float total = scanner.nextFloat();
                            System.out.println("Insert date (YYYY-MM-DD): ");
                            String date = scanner.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                            try {
                                LocalDate formattedDate = LocalDate.parse(date, formatter);
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
                            }

                            //Ticket ticket = new Ticket(total, formattedDate);
                            //ticketService.insertElement(ticket);
                            break;
                    }
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }
}