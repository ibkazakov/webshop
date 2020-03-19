package shop.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.controller.CartController;
import shop.service.ShopLoggerService;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Named
@ApplicationScoped
public class ShopLogger {
    private static final Logger logger = LoggerFactory.getLogger(ShopLogger.class);

    @Inject
    private ShopLoggerService shopLoggerService;

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        String message = parseInvokation(ctx);
        shopLoggerService.writeMessage(message);
        return ctx.proceed();
    }

    // It can be sophisticated in future.
    private String parseInvokation(InvocationContext ctx) {
        return ctx.getMethod().getName() + " invoked";
    }

}
