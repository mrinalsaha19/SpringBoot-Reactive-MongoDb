package com.javatech.webflux.dao;

import com.javatech.webflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDAO {
    public static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(0, 50).
                peek( i-> System.out.println("Processing: "+i)).
                peek(i ->sleepExecution(i)).
                mapToObj(i -> Customer.builder().name("Cusotmer" + 1).id(i).build()).
                collect(Collectors.toList());
    }

    public Flux<Customer> getStreamCustomers() {
        return Flux.range(0, 50).
                delayElements(Duration.ofMillis(1000)).
                doOnNext( i-> System.out.println("Processing: "+i)).
                map(i -> Customer.builder().name("Cusotmer" + i).id(i).build());
    }

}
