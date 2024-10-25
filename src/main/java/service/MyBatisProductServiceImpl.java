package service;

import dao.IDao;
import model.Product;
import mybatis.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisProductServiceImpl implements IDao<Product> {

    private SqlSessionFactory sqlSessionFactory;

    public MyBatisProductServiceImpl() {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getElement (int idProduct) {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);

            Product product = mapper.selectProductById(idProduct);
            System.out.println(product.toString());

            return product;
        }
    }

    @Override
    public List<Product> getAllElements() {
        List<Product> productList = new ArrayList<>();

        return productList;
    }

    @Override
    public void insertElement(Product product){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);

            mapper.insertProduct(product);
            session.commit();
        }
    }

    @Override
    public void updateElement(Product product){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);

            mapper.updateProduct(product);
            session.commit();
        }

    }
    @Override
    public void deleteElement(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);

            mapper.deleteProductById(id);
            session.commit();
        }
    }
}