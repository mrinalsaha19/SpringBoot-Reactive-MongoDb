package com.javatech.webflux.utils;

import com.javatech.webflux.dto.CustomerDTO;
import com.javatech.webflux.dto.ProductDTO;
import com.javatech.webflux.entity.Customer;
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

    public static CustomerDTO mapCustEntityToDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    public static Customer mapCustdtoToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        Product product = new Product();
        BeanUtils.copyProperties(customerDTO, customer);
        BeanUtils.copyProperties(customerDTO.getProduct(), product);
        customer.setProduct(product);
        return customer;
    }
}
