package com.javatech.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<String> test_webflux = Mono.just("Test webflux").log();
        test_webflux.subscribe(System.out::println);

    }

    @Test
    public void testFlux() {
        Flux<String> test_webflux = Flux.just("Test webflux", "Test M").log();
        //test_webflux.subscribe(System.out::println);
       // test_webflux.subscribe(m -> m.on)

    }
}
