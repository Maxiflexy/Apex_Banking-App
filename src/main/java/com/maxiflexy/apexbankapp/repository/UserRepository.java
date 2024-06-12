package com.maxiflexy.apexbankapp.repository;

import com.maxiflexy.apexbankapp.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long>{
    Boolean existsByEmail(String email);
    Boolean existsByAccountNumber(String accountNumber);

    UserEntity findByAccountNumber(String accountNumber);
    Optional<UserEntity> findByEmail (String email);
}
