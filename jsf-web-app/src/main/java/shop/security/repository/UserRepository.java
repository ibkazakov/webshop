package shop.security.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.security.entity.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class UserRepository {
    private static final Logger logger =
            LoggerFactory.getLogger(UserRepository.class);


    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @TransactionAttribute
    public User merge(User user) {
        return em.merge(user);
    }

    @TransactionAttribute
    public void delete(Long id) {
        logger.info("Deleting user");

        try {
            User attached = findById(id);
            if (attached != null) {
                em.remove(attached);
            }
        } catch (Exception ex) {
            logger.error("Error with entity class", ex);
            throw new IllegalStateException(ex);
        }
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @TransactionAttribute
    public List<User> getAllUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> from = query.from(User.class);
        from.fetch("roles", JoinType.LEFT);
        query.select(from).distinct(true);

        return em.createQuery(query).getResultList();
    }


}
