package com.javatech.webflux.dto;

import com.javatech.webflux.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    public String id;
    public String name;
    public ProductDTO product;
}
