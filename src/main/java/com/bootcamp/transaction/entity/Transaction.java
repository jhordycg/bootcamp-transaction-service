package com.bootcamp.transaction.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Transaction {

    @Id
    private String id;
    private Double amount;
    private TransactionType type;
    private String receiverId;
    private String senderId;
    @CreatedDate
    private LocalDateTime createdAt;
}
