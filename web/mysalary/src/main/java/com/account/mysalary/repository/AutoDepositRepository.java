package com.account.mysalary.repository;

import com.account.mysalary.entity.AutoDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoDepositRepository extends JpaRepository<AutoDeposit, Long> {
}
