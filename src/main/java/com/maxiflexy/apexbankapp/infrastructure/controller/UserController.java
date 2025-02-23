package com.maxiflexy.apexbankapp.infrastructure.controller;

import com.maxiflexy.apexbankapp.payload.request.CreditAndDebitRequest;
import com.maxiflexy.apexbankapp.payload.request.EnquiryRequest;
import com.maxiflexy.apexbankapp.payload.request.TransferRequest;
import com.maxiflexy.apexbankapp.payload.response.BankResponse;
import com.maxiflexy.apexbankapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;


    @PostMapping("/credit-account")
    public BankResponse creditAccount(@RequestBody CreditAndDebitRequest request){
        return userService.creditAccount(request);
    }

    @PostMapping("/debit-account")
    public BankResponse debitAccount(@RequestBody CreditAndDebitRequest request){
        return userService.debitAccount(request);
    }

    @GetMapping("/account_balance")
    public BankResponse accountBalance(@RequestBody EnquiryRequest enquiryRequest){
        return userService.enquiryRequest(enquiryRequest);
    }

    @GetMapping("/name_enquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest enquiryRequest){
        return userService.nameEquiry(enquiryRequest);
    }
    @Operation(
            summary = "Credit Account",
            description = "Credit account of the receiver and debit the sender"
    )
    @PostMapping("/transfer")
    public BankResponse transfer(@RequestBody TransferRequest transferRequest){
        return userService.transfer(transferRequest);
    }
}
