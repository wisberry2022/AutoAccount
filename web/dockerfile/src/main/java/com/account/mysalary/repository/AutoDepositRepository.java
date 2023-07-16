package com.account.mysalary.repository;

import com.account.mysalary.entity.Account;
import com.account.mysalary.entity.AutoDeposit;
import com.account.mysalary.projection.TotalExpensesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoDepositRepository extends JpaRepository<AutoDeposit, Long> {

    @Query("select ad.deposit as deposit, ad.amount as amount, ad.name as name from AutoDeposit ad where ad.withdrawal.serial = :serial")
    List<TotalExpensesInfo> findAutoDepositsByWithdrawal(@Param("serial") String serial);

    List<AutoDeposit> findAutoDepositByWithdrawal(Account account);

    List<AutoDeposit> findAutoDepositsByWithdrawal(long id);

}
