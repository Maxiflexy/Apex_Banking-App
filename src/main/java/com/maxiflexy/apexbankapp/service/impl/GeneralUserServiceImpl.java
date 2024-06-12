package com.maxiflexy.apexbankapp.service.impl;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.maxiflexy.apexbankapp.domain.entity.UserEntity;
import com.maxiflexy.apexbankapp.infrastructure.config.JWTAuthenticationFilter;
import com.maxiflexy.apexbankapp.infrastructure.config.JWTTokenProvider;
import com.maxiflexy.apexbankapp.payload.response.BankResponse;
import com.maxiflexy.apexbankapp.repository.UserRepository;
import com.maxiflexy.apexbankapp.service.FileUploadService;
import com.maxiflexy.apexbankapp.service.GeneralUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneralUserServiceImpl implements GeneralUserService {
    private  final FileUploadService fileUploadService;
    private final UserRepository userRepository;
    private  final JWTAuthenticationFilter jwtAuthenticationFilter;
    private  final HttpServletRequest request;
    private  final JWTTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<BankResponse<String>> uploadFilePicture(MultipartFile profilePics) {
        String token = jwtAuthenticationFilter.getTokenFromUserRequest(request);
        String email = jwtTokenProvider.getUsername(token);

        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);

        String fileUrl = null;

        try {
            if(userEntityOptional.isPresent()){
                fileUrl = fileUploadService.uploadFile(profilePics);

                UserEntity userEntity = userEntityOptional.get();
                userEntity.setProfilePicture(fileUrl);

                userRepository.save(userEntity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(
                new BankResponse<>("uploaded Successfully ",fileUrl)
        );
    }
}
