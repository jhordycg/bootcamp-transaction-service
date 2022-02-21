package com.bootcamp.transaction.service;

import com.bootcamp.transaction.entity.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> findAll();

    Mono<Transaction> createByTransactionType(Transaction transaction);

    Mono<Transaction> depositTo(Transaction transaction);

    Mono<Transaction> selfDeposit(Transaction transaction);

    Mono<Transaction> withdrawTo(Transaction transaction);

    Mono<Transaction> selfWithdraw(Transaction transaction);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteAll();
}
