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
import java.io.OptionalDataException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;

    private final AccountRepository accountRepository;

    @Transactional
    public void openAccount(OpenDto dto) throws Exception {
        dto.isThisNull();
        if(accountRepository.findBySerial(dto.getSerial()).isPresent()) {
            throw new Exception("이미 등록된 계좌번호입니다!");
        }
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
    public List<InquiryDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.toInquiryDto(accounts).stream()
                .sorted(Comparator.comparing(InquiryDto::getId))
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeAccountName(UpdateNameDto dto) throws Exception {
        Optional<Account> target = accountRepository.findById(dto.getId());
        Optional.of(target.get())
                .orElseThrow(() -> new Exception("존재하지 않는 계좌입니다!"))
                .changeName(dto.getName());
    }

    @Transactional
    public void deleteAccount(Long id) throws Exception {
        Optional<Account> target = accountRepository.findById(id);
        Optional.of(target.get())
                .orElseThrow(() -> new Exception("존재하지 않는 계좌입니다!"));
        accountRepository.deleteById(id);
    }
}
