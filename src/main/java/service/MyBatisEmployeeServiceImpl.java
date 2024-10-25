package service;

import dao.IDao;
import model.Employee;
import model.Project;
import mybatis.EmployeeMapper;
import mybatis.ProjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisEmployeeServiceImpl implements IDao <Employee> {

    private SqlSessionFactory sqlSessionFactory;

    public MyBatisEmployeeServiceImpl() {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getElement (int idProject) {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            Employee project = mapper.selectEmployeeById(idProject);
            System.out.println(project.toString());

            return project;
        }
    }

    @Override
    public List<Employee> getAllElements() {
        List<Employee> employeeList = new ArrayList<>();

        return employeeList;
    }

    @Override
    public void insertElement(Employee employee){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            mapper.insertEmployee(employee);
            session.commit();
        }
    }

    @Override
    public void updateElement(Employee employee){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            mapper.updateEmployee(employee);
            session.commit();
        }

    }
    @Override
    public void deleteElement(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            mapper.deleteEmployeeById(id);
            session.commit();
        }
    }
}
