package com.account.mysalary.service;

import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.dto.UpdateDebitDto;
import com.account.mysalary.entity.Account;
import com.account.mysalary.entity.AutoDeposit;
import com.account.mysalary.mapper.AutoDepositMapper;
import com.account.mysalary.projection.TotalExpensesInfo;
import com.account.mysalary.repository.AccountRepository;
import com.account.mysalary.repository.AutoDepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void updateDebit(UpdateDebitDto dto) throws Exception {
        Optional<AutoDeposit> debit = autoRepository.findById(dto.getId());
        debit.orElseThrow(() -> new Exception("등록되지 않은 자동이체 계좌입니다!"))
                .changeDebit(dto);
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

    @Transactional
    public List<DebitDto> inquiry(long id) throws Exception {
        Optional<Account> withdrawal = accountRepository.findById(id);
        Optional.of(withdrawal.get())
                .orElseThrow(() -> new Exception("자동이체 정보가 없습니다!"));
        List<AutoDeposit> result = autoRepository.findAutoDepositByWithdrawal(withdrawal.get());
        return depositMapper.entitiesToDtos(result).stream()
                .sorted(Comparator.comparing(DebitDto::getId))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteDebit(Long id) throws Exception {
        Optional<AutoDeposit> target = autoRepository.findById(id);
        Optional.of(target.get())
                .orElseThrow(() -> new Exception("정보가 존재하지 않습니다!"));
        autoRepository.deleteById(id);

    }

}
