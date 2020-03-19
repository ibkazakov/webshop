package shop.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.remote.soap.LogMessageRepositoryWs;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@WebService(endpointInterface = "shop.remote.soap.LogMessageRepositoryWs",
        serviceName = "LoggerService")
public class LogMessageRepositoryImpl
        implements LogMessageRepository, LogMessageRepositoryWs
 {
    private static final Logger logger
            = LoggerFactory.getLogger(LogMessageRepositoryImpl.class);


    @PersistenceContext(unitName = "ds")
    private EntityManager em;


    @Override
    @TransactionAttribute
    public void insert(LogMessage logMessage) throws Exception  {
        em.persist(logMessage);
    }


    @Override
    @TransactionAttribute
    public void deleteAll() throws Exception {
        em.createQuery("delete from LogMessage").executeUpdate();
    }


    public List<LogMessage> findAll() throws Exception {
        return em.createQuery("from LogMessage", LogMessage.class).getResultList();
    }
}
