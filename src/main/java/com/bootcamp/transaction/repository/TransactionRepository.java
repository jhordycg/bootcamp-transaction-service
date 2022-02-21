package com.bootcamp.transaction.repository;

import com.bootcamp.transaction.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
