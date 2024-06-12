package com.maxiflexy.apexbankapp.infrastructure.controller;

import com.itextpdf.text.DocumentException;
import com.maxiflexy.apexbankapp.domain.entity.Transactions;
import com.maxiflexy.apexbankapp.service.impl.BankStatementImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statement")
public class TransactionController {
    private final BankStatementImpl bankStatement;
    @GetMapping
    public List<Transactions> generateStatement(@RequestParam String accountNumber,
                                                @RequestParam String startDate,
                                                @RequestParam String endDate) throws DocumentException, FileNotFoundException {


    return bankStatement.generateStatement(accountNumber, startDate, endDate);
    }

}
