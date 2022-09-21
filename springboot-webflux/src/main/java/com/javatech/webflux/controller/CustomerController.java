package com.javatech.webflux.controller;

import com.javatech.webflux.dto.Customer;
import com.javatech.webflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/listOfCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping(value = "/stream/listOfCustomers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomerByStream() {
        return customerService.getAllCustomerByStream();
    }
}
