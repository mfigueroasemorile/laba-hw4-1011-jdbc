package service;

import dao.*;
import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DataBaseMenuService {

    ProjectDAO projectDAO = new ProjectDAO();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    AsignationDAO asignationDAO = new AsignationDAO();
    SupplierDAO supplierDAO = new SupplierDAO();
    ProductDAO productDAO = new ProductDAO();


    public void createProject(){
        Scanner scanner = new Scanner(System.in);
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


        Project newProject = new Project();
        newProject.setManagerName(name);
        newProject.setAddress(address);
        newProject.setProjectTypeId(type);
        newProject.setClientId(client);

        projectDAO.insertElement(newProject);
    }

    public void createEmployee(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert employee name: ");
        String name = scanner.nextLine();
        System.out.println("Insert address: ");
        String address = scanner.nextLine();
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
        employee.setName(name);
        employee.setAddress(address);
        employee.setRoleId(role);
        employee.setContractId(contractId);

        employeeDAO.insertElement(employee);
    }

    public void assignEmployee(){
        Asignation asignation = new Asignation();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert project id: ");
        int project = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert employee id: ");
        int employee = scanner.nextInt();
        scanner.nextLine();
        Date date = new Date();

        asignation.setAsignationDate(date);
        asignation.setEmployeeId(employee);
        asignation.setProjectId(project);

        asignationDAO.insertElement(asignation);
    }


    public void createSupplier(){

        Supplier supplier = new Supplier();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert supplier name: ");
        String name = scanner.nextLine();
        System.out.println("Insert supplier description: ");
        String description = scanner.nextLine();

        supplier.setName(name);
        supplier.setDescription(description);

        supplierDAO.insertElement(supplier);
    }

    public void createProduct(){
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert product description: ");
        String description = scanner.nextLine();
        System.out.println("Insert product price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Insert supplier id: ");
        int supplierId = scanner.nextInt();
        scanner.nextLine();

        product.setSupplierId(supplierId);
        product.setPrice(price);
        product.setDescription(description);

        productDAO.insertElement(product);
    }

    public void getAllProjects(){

        List<Project> projectList = new ArrayList<>();

        projectList = projectDAO.getAllElements();
        for (Project project : projectList) {
            System.out.println(project);
        }
    }
}
