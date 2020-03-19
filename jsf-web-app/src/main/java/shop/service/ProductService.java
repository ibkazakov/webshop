package shop.service;
import shop.dto.ProductDTO;
import shop.dto.ProductMapper;
import shop.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Inject
    private ProductMapper mapper;

    @Inject
    private ProductRepository productRepository;

    public void insert(ProductDTO productDTO) {
        try {
            productRepository.insert(mapper.toProduct(productDTO));
        }
        catch (Exception e) {
            logger.error("ProductRepository insert error");
        }
    }

    public void update(ProductDTO productDTO)  {
        try {
            productRepository.update(mapper.toProduct(productDTO));
        }
        catch (Exception e) {
            logger.error("ProductRepository update error");
        }
    }

    public void delete(long id) {
        try {
            productRepository.delete(id);
        }
        catch (Exception e) {
            logger.error("ProductRepository delete error");
        }
    }

    public ProductDTO findById(long id) {
        try {
            return mapper.toProductDTO(productRepository.findById(id));
        }
        catch (Exception e) {
            logger.error("ProductRepository findOne error");
            return new ProductDTO();
        }
    }

    public List<ProductDTO> findAll() {
        try {
            return mapper.toProductDTO(productRepository.findAll());
        }
        catch (Exception e) {
            logger.error("ProductRepository findALL error");
            return new ArrayList<>();
        }
    }

    public void deleteAll() {
        try {
            productRepository.deleteAll();
        }
        catch (Exception e) {
            logger.error("ProductRepository deleteAll error");
        }
    }
}
