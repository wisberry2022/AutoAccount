package com.account.mysalary.service;

import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.entity.Account;
import com.account.mysalary.mapper.AutoDepositMapper;
import com.account.mysalary.projection.TotalExpensesInfo;
import com.account.mysalary.repository.AccountRepository;
import com.account.mysalary.repository.AutoDepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DebitService {

    private final AutoDepositRepository autoRepository;
    private final AccountRepository accountRepository;

    private final AutoDepositMapper depositMapper;

    @Transactional
    public void setDirectDebit(DebitDto dto) throws Exception {
        Account withdrawal = Optional.of(accountRepository.findBySerial(dto.getWithdrawal()))
                .orElseThrow(() -> new Exception("등록되지 않은 계좌입니다!"))
                .get();

        autoRepository.save(depositMapper.dtoToEntity(dto, withdrawal));
    }

    @Transactional
    public boolean isAssignedTransfer(DebitDto debit) {
        String withdrawal = debit.getWithdrawal();
        String deposit = debit.getDeposit();
        List<TotalExpensesInfo> results = autoRepository.findAutoDepositsByWithdrawal(withdrawal);
        return results.stream()
                .map(TotalExpensesInfo::getDeposit)
                .anyMatch(serial -> serial.equals(deposit));
    }

}
