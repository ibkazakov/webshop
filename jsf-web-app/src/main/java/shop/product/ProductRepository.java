package shop.product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepository {
    void insert(Product product) throws Exception;

    void update(Product product) throws Exception;

    void delete(long id) throws Exception;

    Product findById(long id) throws Exception;

    List<Product> findAll() throws Exception;

    void deleteAll() throws Exception;
}
