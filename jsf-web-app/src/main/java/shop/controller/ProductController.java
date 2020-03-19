package shop.controller;

import shop.dto.ProductDTO;
import shop.logs.ShopLogger;
import shop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import java.math.BigDecimal;
import java.util.List;


@Named
@ApplicationScoped
public class ProductController {



    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    @Inject
    private ProductService productService;

    private List<ProductDTO> preloadedList;

    private ProductDTO productDTO;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void preload(ComponentSystemEvent componentSystemEvent) throws Exception {
        this.preloadedList = productService.findAll();
    }

    public List<ProductDTO> getPreloadedList() {
        return preloadedList;
    }

    @Interceptors({ShopLogger.class})
    public void delete(ProductDTO productDTO) throws Exception {
        productService.delete(productDTO.getId());
    }

    @Interceptors({ShopLogger.class})
    public String editProduct(ProductDTO productDTO) {
        this.productDTO = productDTO;
        return "/admin/product.xhtml?faces-redirect=true";
    }

    @Interceptors({ShopLogger.class})
    public String createProduct() {
        productDTO = new ProductDTO();
        return "/admin/product.xhtml?faces-redirect=true";
    }

    @Interceptors({ShopLogger.class})
    public String saveProduct() throws Exception {
        if (productDTO.getId() == null) {
            productService.insert(productDTO);
        } else {
            productService.update(productDTO);
        }
        return "/admin/products_db.xhtml?faces-redirect=true";
    }

    public void defaultValues() throws Exception {
        productService.deleteAll();
        productService.insert(new ProductDTO( "Product1", "Desc1", new BigDecimal(14)));
        productService.insert(new ProductDTO( "Product2", "Desc2", new BigDecimal(102)));
        productService.insert(new ProductDTO( "Product3", "Desc3", new BigDecimal(1030)));
        productService.insert(new ProductDTO( "Product4", "Desc4", new BigDecimal(140)));
        productService.insert(new ProductDTO( "Product5", "Desc5", new BigDecimal(10)));
        productService.insert(new ProductDTO( "Product6", "Desc6", new BigDecimal(172)));
        productService.insert(new ProductDTO( "Product7", "Desc7", new BigDecimal(1090)));
        productService.insert(new ProductDTO( "Product8", "Desc8", new BigDecimal(247)));
        productService.insert(new ProductDTO( "Product9", "Desc9", new BigDecimal(147)));
    }

}
