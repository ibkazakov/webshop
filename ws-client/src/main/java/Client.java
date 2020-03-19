import shop.logs.LoggerService;
import shop.remote.LogMessage;

import java.util.List;


// Probably, It can be upgraded to the remote log service.
public class Client {

    private static LoggerService remotedService = new LoggerService();

    public static void main(String[] args) throws Exception  {
        List<LogMessage> logs = remotedService.getLogMessageRepositoryImplPort().findAll();
        System.out.println(logs.size());
    }
}
