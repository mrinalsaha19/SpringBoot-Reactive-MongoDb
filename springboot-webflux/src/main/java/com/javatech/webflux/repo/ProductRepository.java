package com.javatech.webflux.repo;

import com.javatech.webflux.dto.ProductDTO;
import com.javatech.webflux.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
    Flux<ProductDTO> findByPriceBetween(Range<Double> priceRange);
    @Query("{$and: [{name: ?0}, {qty: ?1}]}")
    Flux<ProductDTO> findByNameAndQuery(String name, String qty);
}
