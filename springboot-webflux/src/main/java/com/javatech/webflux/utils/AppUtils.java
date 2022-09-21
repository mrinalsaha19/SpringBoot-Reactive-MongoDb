package com.javatech.webflux.utils;

import com.javatech.webflux.dto.ProductDTO;
import com.javatech.webflux.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static ProductDTO entityToDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDTO productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
