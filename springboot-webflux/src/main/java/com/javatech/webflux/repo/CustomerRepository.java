package com.javatech.webflux.repo;

import com.javatech.webflux.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {
}
