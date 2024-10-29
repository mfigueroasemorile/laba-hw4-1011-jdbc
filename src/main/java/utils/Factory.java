package utils;

import model.*;

import java.util.Date;

public class Factory extends AbstractFactory{

    @Override
    public Project createProject(String managerName, String address, int projectTypeId, int clientId) {
        return new Project(managerName, address, projectTypeId, clientId);
    }

    @Override
    public Employee createEmployee(String name, String address, int contractId, int roleId, String gender) {
        return new Employee(name, address, contractId, roleId, gender);
    }

    @Override
    public Product createProduct(String description, float price, int supplierId) {
        return new Product(description, price, supplierId);
    }

    @Override
    public Ticket createTicket(float total, Date date) {
        return new Ticket(total, date);
    }

    @Override
    public Supplier createSupplier(String name, String description) {
        return new Supplier(name, description);
    }
}
