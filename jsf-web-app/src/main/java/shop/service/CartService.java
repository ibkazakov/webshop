package shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.cart.ProductQty;
import shop.dto.ProductDTO;
import shop.dto.ProductMapper;
import shop.product.Product;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedSet;

@Named
@SessionScoped
public class CartService implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);


    @Inject
    private ProductMapper mapper;

    @Inject
    private ProductQty productQty;

    public void addProduct(ProductDTO productDTO) {
        Product product = mapper.toProduct(productDTO);
        productQty.addProduct(product);
    }

    public void removeProduct(ProductDTO productDTO) {
        Product product = mapper.toProduct(productDTO);
        productQty.removeProduct(product);
    }

    public BigDecimal totalBill() {
        BigDecimal moneySum = new BigDecimal(0);

        for(Map.Entry<Product, Integer> qtyEntry : productQty.getCartMap().entrySet()) {
             BigDecimal addValue = qtyEntry.getKey()
                     .getPrice().multiply(BigDecimal.valueOf(qtyEntry.getValue()));

             moneySum = moneySum.add(addValue);
        }

        return moneySum;
    }

    public void clear() {
        productQty.getCartMap().clear();
    }

    public SortedSet<Map.Entry<ProductDTO, Integer>> productSet() {
        return mapper.toProductDTO(productQty.getCartMap().entrySet());
    }


}
