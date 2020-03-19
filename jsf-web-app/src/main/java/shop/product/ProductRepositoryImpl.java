package shop.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.remote.rest.ProductServiceRs;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class ProductRepositoryImpl implements ProductRepository, ProductServiceRs {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);


    @PersistenceContext(unitName = "ds")
    private EntityManager em;


    @Override
    @TransactionAttribute
    public void insert(Product product) throws Exception  {
        em.persist(product);
    }


    @Override
    @TransactionAttribute
    public void update(Product product) throws Exception {
        em.merge(product);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) throws Exception {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    @TransactionAttribute
    public void deleteAll() throws Exception {
        em.createQuery("delete from Product ").executeUpdate();
    }


    public Product findById(long id) throws Exception {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() throws Exception {
        return em.createQuery("from Product", Product.class).getResultList();
    }

}
