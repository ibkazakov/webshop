package shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.logs.ShopLogger;
import shop.service.CartService;
import shop.dto.ProductDTO;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

@Named
@ApplicationScoped
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);


    @Inject
    private CartService cartService;

    @Interceptors({ShopLogger.class})
    public void addProduct(ProductDTO productDTO) {
        cartService.addProduct(productDTO);
    }

    @Interceptors({ShopLogger.class})
    public void removeProduct(ProductDTO productDTO) {
        cartService.removeProduct(productDTO);
    }

    public BigDecimal totalBill() {
        return cartService.totalBill();
    }

    @Interceptors({ShopLogger.class})
    public void acceptOrder() {
        cartService.clear();
    }

    public SortedSet<Map.Entry<ProductDTO, Integer>> productSet() {
        return cartService.productSet();
    }


}
