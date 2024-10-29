package utils;

import model.*;

import java.util.Date;

public abstract class AbstractFactory {

        public abstract Project createProject(String managerName, String address, int projectTypeId, int clientId);
        public abstract Employee createEmployee(String name, String address, int contractId, int roleId, String gender);
        public abstract Product createProduct(String description, float price, int supplierId);
        public abstract Ticket createTicket(float total, Date date);
        public abstract Supplier createSupplier(String name, String description);
}
