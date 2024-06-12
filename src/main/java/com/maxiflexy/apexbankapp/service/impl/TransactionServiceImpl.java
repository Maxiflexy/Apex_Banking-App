package com.maxiflexy.apexbankapp.service.impl;

import com.maxiflexy.apexbankapp.domain.entity.Transactions;
import com.maxiflexy.apexbankapp.payload.request.TransactionRequest;
import com.maxiflexy.apexbankapp.repository.TransactionRepository;
import com.maxiflexy.apexbankapp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    @Override
    public void saveTransactions(TransactionRequest transactionRequest) {
        Transactions transactions = Transactions.builder()
                .transactionType(transactionRequest.getTransactionType())
                .accountNumber(transactionRequest.getAccountNumber())
                .amount(transactionRequest.getAmount())
                .status("SUCCESS")
                .build();

        transactionRepository.save(transactions);



        System.out.println("Transaction Saved Successfully");
    }
}
