package com.ru.springReact.service;

import com.ru.springReact.model.Transaction;

import java.util.Optional;

public interface TransactionService {
    Transaction save(Transaction transaction);

    Optional<Transaction> findById(Long id);

    long count();
}
