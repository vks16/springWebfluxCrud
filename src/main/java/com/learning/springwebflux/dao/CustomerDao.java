package com.learning.springwebflux.dao;

import com.learning.springwebflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {
    private static void sleep(int i){
        try{

            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Thread sleeping...");
        }
    }
    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1, 50)
                .peek(CustomerDao::sleep)
                .peek(i -> System.out.println("processing count : " + i))
                .mapToObj(i -> new Customer(i, "customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream(){
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing : " + i))
                .map(i -> new Customer(i, "customer " + i));
    }
}
