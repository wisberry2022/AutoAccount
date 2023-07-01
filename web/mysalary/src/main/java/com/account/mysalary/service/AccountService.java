package com.account.mysalary.service;

import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.mapper.AccountMapper;
import com.account.mysalary.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Transactional
    public void openAccount(OpenDto dto) {
        System.out.println(accountMapper.dtoToEntity(dto));
        accountRepository.save(accountMapper.dtoToEntity(dto));
    }

}
