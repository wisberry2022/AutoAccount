package com.account.mysalary.mapper;

import com.account.mysalary.dto.AccountDto;
import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.dto.InquiryDto;
import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.entity.Account;
import com.account.mysalary.entity.AutoDeposit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target="id", ignore = true)
    Account dtoToEntity(OpenDto dto);

    @Mapping(target="debitCount", expression="java(entity.getAutoDeposits().size())")
    @Mapping(target="expense", expression="java(entity.getTotalExpense())")
    @Mapping(target="debits", expression="java(toDebitDtos(entity.getAutoDeposits()))")
    InquiryDto toDto(Account entity);

    @Mapping(target="withdrawal", expression="java(entity.getWithdrawal().getSerial())")
    DebitDto toDebitDto(AutoDeposit entity);

    default List<InquiryDto> toInquiryDto(List<Account> entities) {
        if(entities == null) {
            return null;
        }
        return entities.stream()
                .map(account -> toDto(account))
                .collect(Collectors.toList());
    }

    default List<DebitDto> toDebitDtos(List<AutoDeposit> entities) {
        if(entities == null) {
            return null;
        }
        return entities.stream()
                .map(debit -> toDebitDto(debit))
                .sorted(Comparator.comparing(DebitDto::getId))
                .collect(Collectors.toList());
    }
}
