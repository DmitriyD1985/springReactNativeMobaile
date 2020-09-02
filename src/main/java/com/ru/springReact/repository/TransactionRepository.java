package com.ru.springReact.repository;

import com.ru.springReact.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(Long id);
    long count();
}
