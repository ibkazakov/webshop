package shop.security.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.security.entity.Role;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoleRepository {
    private static final Logger logger =
            LoggerFactory.getLogger(RoleRepository.class);


    @PersistenceContext(unitName = "ds")
    private EntityManager em;


    @TransactionAttribute
    public Role merge(Role role) {
        return em.merge(role);
    }

    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    public List<Role> getAllRoles() {
        return em.createQuery("from Role ", Role.class).getResultList();
    }

}