package com.account.mysalary.repository;

import com.account.mysalary.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByName(String name);

    Optional<Account> findBySerial(String serial);

    @Query("select ac.serial from Account ac where ac.name = :name")
    String findSerialByName(@Param("name") String name);

    @Query("select ac.balance from Account ac where ac.name = :name")
    Long findBalanceByName(@Param("name") String name);

}
