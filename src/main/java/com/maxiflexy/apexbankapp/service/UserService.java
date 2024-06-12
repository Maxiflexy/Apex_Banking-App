package com.maxiflexy.apexbankapp.service;

import com.maxiflexy.apexbankapp.payload.request.CreditAndDebitRequest;
import com.maxiflexy.apexbankapp.payload.request.EnquiryRequest;
import com.maxiflexy.apexbankapp.payload.request.TransferRequest;
import com.maxiflexy.apexbankapp.payload.response.BankResponse;

public interface UserService {
    BankResponse creditAccount (CreditAndDebitRequest request);
    BankResponse debitAccount (CreditAndDebitRequest request);
    BankResponse enquiryRequest (EnquiryRequest enquiryRequest);
    String nameEquiry(EnquiryRequest enquiryRequest);
    BankResponse transfer(TransferRequest transferRequest);
}
