package com.javatech.webflux.service;

import com.javatech.webflux.dao.CustomerDAO;
import com.javatech.webflux.dto.Customer;
import com.javatech.webflux.dto.CustomerDTO;
import com.javatech.webflux.dto.ProductDTO;
import com.javatech.webflux.repo.CustomerRepository;
import com.javatech.webflux.repo.ProductRepository;
import com.javatech.webflux.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO custDao;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository custRepository;

    public List<Customer> getAllCustomer() {
        long start = System.currentTimeMillis();
        List<Customer> listOfCus = custDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Time differ: "+(end-start));
        return listOfCus;
    }

    public Flux<Customer> getAllCustomerByStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> listOfCus = custDao.getStreamCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Time differ: "+(end-start));
        return listOfCus;
    }

    public Mono<ProductDTO> saveProduct(Mono<CustomerDTO> customerDtoMono) {
        return customerDtoMono.map(AppUtils::mapCustdtoToEntity)
                .doOnNext(date -> date.getProduct().setUpdateDate(Instant.now().toString()))
                .flatMap(custRepository::insert)
                .flatMap(product-> productRepository.insert(product.getProduct()))
                .map(AppUtils::entityToDto);
    }
}
