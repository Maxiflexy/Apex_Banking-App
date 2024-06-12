package com.maxiflexy.apexbankapp.service;

import com.maxiflexy.apexbankapp.payload.request.LoginRequest;
import com.maxiflexy.apexbankapp.payload.request.UserRequest;
import com.maxiflexy.apexbankapp.payload.response.ApiResponse;
import com.maxiflexy.apexbankapp.payload.response.BankResponse;
import com.maxiflexy.apexbankapp.payload.response.JWTAuthResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    BankResponse registerUser(UserRequest userRequest);
    ResponseEntity<ApiResponse<JWTAuthResponse>> login (LoginRequest loginRequest);
}
