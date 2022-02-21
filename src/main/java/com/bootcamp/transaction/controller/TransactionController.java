package com.bootcamp.transaction.controller;

import com.bootcamp.transaction.entity.Transaction;
import com.bootcamp.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @GetMapping
    public Flux<Transaction> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Mono<Transaction> create(@RequestBody Transaction transaction) {
        return service.createByTransactionType(transaction);
    }

    @DeleteMapping
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }


}
