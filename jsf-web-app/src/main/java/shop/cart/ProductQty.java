package shop.cart;

import shop.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class ProductQty implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductQty.class);


    private Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void addProduct(Product product) {
        Product presentProduct = getProductById(product.getId());
        if (presentProduct == null) {
            cartMap.put(product,1);
        } else {
            int qty = cartMap.get(presentProduct);
            cartMap.put(presentProduct, qty + 1);
        }
    }

    public void removeProduct(Product product) {
        Product presentProduct = getProductById(product.getId());
        if (presentProduct != null) {
            int qty = cartMap.get(presentProduct);
            if (qty == 1) {
                cartMap.remove(presentProduct);
            } else
            {
                cartMap.put(presentProduct, qty - 1);
            }
        }
    }

    // returns null if the product with such id does not exist
    private Product getProductById(Long id) {
        Product product = null;
        for(Product currentProduct : cartMap.keySet()) {
            if (currentProduct.getId().equals(id)) {
                product = currentProduct;
            }
        }
        return product;
    }
}
