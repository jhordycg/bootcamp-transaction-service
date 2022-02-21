package com.bootcamp.transaction.service.impl;

import com.bootcamp.transaction.entity.Transaction;
import com.bootcamp.transaction.repository.TransactionRepository;
import com.bootcamp.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;

    @Override
    public Flux<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Transaction> createByTransactionType(Transaction transaction) {
        switch (transaction.getType()) {
            case DEPOSIT_TO:
                return depositTo(transaction);
            case SELF_DEPOSIT:
                return selfDeposit(transaction);
            case SELF_WITHDRAW:
                return selfWithdraw(transaction);
            default:
                return Mono.error(new NoSuchFieldException("Invalid transaction type."));
        }
    }

    @Override
    public Mono<Transaction> depositTo(Transaction transaction) {
        return repository.insert(transaction);
    }

    @Override
    public Mono<Transaction> selfDeposit(Transaction transaction) {
        return repository.insert(transaction);
    }

    @Override
    public Mono<Transaction> withdrawTo(Transaction transaction) {
        return repository.insert(transaction);
    }

    @Override
    public Mono<Transaction> selfWithdraw(Transaction transaction) {
        return repository.insert(transaction);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }

}
