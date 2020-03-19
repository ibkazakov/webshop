package shop.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.product.Product;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.*;

@Stateless
public class ProductMapper implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(ProductMapper.class);


    public ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        return product;
    }

    public List<ProductDTO> toProductDTO(List<Product> products) {
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for(Product product: products) {
            productDTOs.add(toProductDTO(product));
        }
        return productDTOs;
    }

    public SortedSet<Map.Entry<ProductDTO, Integer>>
    toProductDTO(Set<Map.Entry<Product, Integer>> productEntries) {
        Map<ProductDTO, Integer> productDtoMap = new HashMap<>();

        for(Map.Entry<Product, Integer> entry : productEntries) {
            productDtoMap.put(toProductDTO(entry.getKey()), entry.getValue());
        }

        SortedSet<Map.Entry<ProductDTO, Integer>> sorted =
                new TreeSet<>(new Comparator<Map.Entry<ProductDTO, Integer>>() {

                    @Override
                    public int compare(Map.Entry<ProductDTO, Integer> o1,
                                       Map.Entry<ProductDTO, Integer> o2) {
                        return o1.getKey().getId().compareTo(o2.getKey().getId());
                    }
                } );

        sorted.addAll(productDtoMap.entrySet());


        return sorted;
    }
}
