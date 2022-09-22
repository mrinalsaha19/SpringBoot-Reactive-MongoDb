package com.javatech.webflux.service;

import com.javatech.webflux.dto.ProductDTO;
import com.javatech.webflux.entity.Product;
import com.javatech.webflux.repo.ProductRepository;
import com.javatech.webflux.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<ProductDTO> getProducts() {
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDTO> getProduct(String id) {
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Flux<ProductDTO> getProductInRange(double min, double max) {
        return repository.findByPriceBetween(Range.closed(min, max));
    }

    public Mono<ProductDTO> saveProduct(Mono<ProductDTO> productDtoMono) {
        return productDtoMono.map(AppUtils::dtoToEntity)
                .doOnNext(date -> date.setUpdateDate(Instant.now().toString()))
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }
    public Flux<ProductDTO> saveProducts(Flux<ProductDTO> productDtoMono) {
        return productDtoMono.map(AppUtils::dtoToEntity)
                .doOnNext(date -> date.setUpdateDate(Instant.now().toString()))
                // .flatMap(pro -> repository.insert(pro)) Same as below line
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDtoMono, String id) {
        return repository.findById(id)
                .flatMap(p -> productDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
               // .flatMap(pro -> repository.save(pro)) Same as below line
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }
    public Mono<String> deleteProduct(String id) {

         repository.deleteById(id);
        return Mono.just("Deleted: "+ id);
    }

    public Flux<ProductDTO> getCustomProduct(String name, String qty) {
       return repository.findByNameAndQty(name, qty);
    }
}
