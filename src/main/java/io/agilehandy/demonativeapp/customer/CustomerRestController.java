package io.agilehandy.demonativeapp.customer;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerRestController {

    private final CustomerRepository repository;

    public CustomerRestController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    public Flux<Customer> customers() {
        return repository.findAll();
    }

    @PostMapping("/customers/{name}")
    public Mono<Customer> addCustomer(@PathVariable String name) {
        Customer customer = new Customer(null, name);
        return repository.save(customer);
    }

    @PutMapping("/customers/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id) {
        repository.deleteById(id);
        return Mono.empty();
    }
}
