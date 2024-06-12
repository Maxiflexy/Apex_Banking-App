package com.maxiflexy.apexbankapp.repository;

import com.maxiflexy.apexbankapp.domain.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,String> {
}
