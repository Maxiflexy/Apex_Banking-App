package com.maxiflexy.apexbankapp.service;

import com.maxiflexy.apexbankapp.payload.response.BankResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface GeneralUserService {
    ResponseEntity<BankResponse<String>> uploadFilePicture(MultipartFile multipartFile);
}
