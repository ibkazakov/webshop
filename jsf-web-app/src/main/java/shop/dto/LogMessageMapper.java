package shop.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.logs.LogMessage;
import shop.product.Product;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.*;

@Stateless
public class LogMessageMapper implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(LogMessageMapper.class);


    public LogMessageDTO toLogMessageDTO(LogMessage logMessage) {
        LogMessageDTO logMessageDTO = new LogMessageDTO();

        logMessageDTO.setId(logMessage.getId());
        logMessageDTO.setMessage(logMessage.getMessage());
        logMessageDTO.setDateTime(logMessage.getDataTime());

        return logMessageDTO;
    }

    public List<LogMessageDTO> toLogMessageDTO(List<LogMessage> logMessages) {
        List<LogMessageDTO> logMessageDTOS = new ArrayList<>();
        for(LogMessage logMessage : logMessages) {
            logMessageDTOS.add(toLogMessageDTO(logMessage));
        }
        return logMessageDTOS;
    }
}
