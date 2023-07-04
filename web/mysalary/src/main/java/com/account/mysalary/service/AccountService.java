package com.account.mysalary.service;

import com.account.mysalary.dto.*;
import com.account.mysalary.entity.Account;
import com.account.mysalary.mapper.AccountMapper;
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
public class AccountService {

    private final AccountRepository accountRepository;
    private final AutoDepositRepository autoRepository;

    private final AccountMapper accountMapper;

    @Transactional
    public void openAccount(OpenDto dto) {
        accountRepository.save(accountMapper.dtoToEntity(dto));
    }

    @Transactional
    public void deposit(TransferDto dto) {
        Account target = accountRepository.findByName(dto.getName()).get();
        target.deposit(dto.getAmount());
        accountRepository.save(target);
    }

    @Transactional
    public void withdrawal(TransferDto dto) {
        Account target = accountRepository.findByName(dto.getName()).get();
        target.withdrawal(dto.getAmount());
        accountRepository.save(target);
    }

    @Transactional
    public long getTotalExpenses(String name) {
        String serial = accountRepository.findSerialByName(name);

        List<TotalExpensesInfo> results = autoRepository.findAutoDepositsByWithdrawal(serial);
        return results.stream()
                .map(TotalExpensesInfo::getAmount)
                .reduce(0L, (a,b) -> a+=b);
    }

    @Transactional
    public List<InquiryDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.toDtos(accounts);
    }

    @Transactional
    public void changeAccountName(UpdateNameDto dto) throws Exception {
        Optional<Account> target = accountRepository.findByName(dto.getBefore());
        Optional.of(target.get())
                .orElseThrow(() -> new Exception("존재하지 않는 계좌입니다!"))
                .changeName(dto.getAfter());
    }

    @Transactional
    public void deleteAccount(String serial) throws Exception {
        Optional<Account> target = accountRepository.findBySerial(serial);
        Optional.of(target.get())
                .orElseThrow(() -> new Exception("존재하지 않는 계좌입니다!"));
        accountRepository.deleteBySerial(serial);
    }
}
