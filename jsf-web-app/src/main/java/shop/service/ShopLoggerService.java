package shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.dto.LogMessageDTO;
import shop.dto.LogMessageMapper;
import shop.logs.LogMessage;
import shop.logs.LogMessageRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ShopLoggerService {

    private static final Logger logger = LoggerFactory.getLogger(ShopLoggerService.class);

    @Inject
    private LogMessageRepository logMessageRepository;

    @Inject
    private LogMessageMapper mapper;

    public void writeMessage(String message) {
        try {
            logMessageRepository.
                    insert(new LogMessage(message, new Timestamp(System.currentTimeMillis())));
        }
        catch (Exception e) {
            logger.error("shopLogger write error");
        }
    }

    public List<LogMessageDTO> findAll() {
        try {
            return mapper.toLogMessageDTO(logMessageRepository.findAll());
        }
        catch (Exception e) {
            logger.error("shopLogger findAll error");
            return new ArrayList<>();
        }
    }

    public void deleteAll() {
        try {
            logMessageRepository.deleteAll();
        } catch (Exception e) {
            logger.error("shopLogger deleteAll error");
        }
    }
}
