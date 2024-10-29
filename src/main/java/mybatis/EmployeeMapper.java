package mybatis;

import model.Employee;

public interface EmployeeMapper {
    Employee selectEmployeeById(int id);
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
