package mybatis;

import model.Project;
import model.Supplier;

public interface SupplierMapper {
    Supplier selectSupplierById(int id);
    void insertSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplierById(int id);
}
