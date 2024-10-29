package service;

import dao.IDao;
import model.Project;
import model.Supplier;
import mybatis.ProjectMapper;
import mybatis.SupplierMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisSupplierServiceImpl implements IDao<Supplier> {

    private SqlSessionFactory sqlSessionFactory;

    public MyBatisSupplierServiceImpl() {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Supplier getElement (int idSupplier) {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            SupplierMapper mapper = session.getMapper(SupplierMapper.class);

            Supplier supplier = mapper.selectSupplierById(idSupplier);
            System.out.println(supplier.toString());

            return supplier;
        }
    }

    @Override
    public List<Supplier> getAllElements() {
        List<Supplier> supplierList = new ArrayList<>();

        return supplierList;
    }

    @Override
    public void insertElement(Supplier supplier){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SupplierMapper mapper = session.getMapper(SupplierMapper.class);

            mapper.insertSupplier(supplier);
            session.commit();
        }
    }

    @Override
    public void updateElement(Supplier supplier){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SupplierMapper mapper = session.getMapper(SupplierMapper.class);

            mapper.updateSupplier(supplier);
            session.commit();
        }

    }
    @Override
    public void deleteElement(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SupplierMapper mapper = session.getMapper(SupplierMapper.class);

            mapper.deleteSupplierById(id);
            session.commit();
        }
    }
}
