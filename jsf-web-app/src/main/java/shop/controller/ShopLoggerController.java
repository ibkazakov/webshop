package shop.controller;

import shop.dto.LogMessageDTO;
import shop.service.ShopLoggerService;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class ShopLoggerController {

    @Inject
    private ShopLoggerService shopLoggerService;

    private List<LogMessageDTO> preloadedList;

    public void preload(ComponentSystemEvent componentSystemEvent) throws Exception {
        this.preloadedList = shopLoggerService.findAll();
    }

    public List<LogMessageDTO> getPreloadedList() {
        return preloadedList;
    }

    public void deleteAll() {
        shopLoggerService.deleteAll();
    }
}
