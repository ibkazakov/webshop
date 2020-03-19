package shop.remote.soap;

import shop.logs.LogMessage;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface LogMessageRepositoryWs {
    @WebMethod
    List<LogMessage> findAll() throws Exception;
}
