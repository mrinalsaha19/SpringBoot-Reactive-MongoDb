package com.javatech.webflux.service;

import com.javatech.webflux.dao.CustomerDAO;
import com.javatech.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO custDao;


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
}
