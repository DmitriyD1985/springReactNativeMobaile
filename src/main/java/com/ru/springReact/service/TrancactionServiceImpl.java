package com.ru.springReact.service;

import com.ru.springReact.model.Transaction;
import com.ru.springReact.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TrancactionServiceImpl implements TransactionService{

    TransactionRepository transactionRepository;

    public TrancactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public long count() {
        return transactionRepository.count();
    }
}
