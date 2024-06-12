package com.maxiflexy.apexbankapp.service;

import com.maxiflexy.apexbankapp.payload.request.TransactionRequest;

public interface TransactionService {
    void saveTransactions(TransactionRequest transactionRequest);
}
