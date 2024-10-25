package mybatis;

import model.Product;

public interface ProductMapper {
    Product selectProductById(int id);
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(int id);
}
