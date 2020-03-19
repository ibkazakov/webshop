package shop.logs;

import shop.product.Product;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import java.util.List;

@Local
public interface LogMessageRepository {

    void insert(LogMessage logMessage) throws Exception;

    void deleteAll() throws Exception;

    List<LogMessage> findAll() throws Exception;
}
