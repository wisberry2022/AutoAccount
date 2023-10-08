package com.account.mysalary.mapper;

import com.account.mysalary.dto.AccountDto;
import com.account.mysalary.dto.InquiryDto;
import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target="id", ignore = true)
    Account dtoToEntity(OpenDto dto);

    @Mapping(target="debitCount", expression="java(entity.getAutoDeposits().size())")
    @Mapping(target="expense", expression="java(entity.getTotalExpense())")
    InquiryDto toDto(Account entity);

    @Mapping(target="debitCount", expression="java(entity.getAutoDeposits().size())")
    AccountDto entityToDto(Account entity);

    default List<InquiryDto> toInquiryDto(List<Account> entities) {
        if(entities == null) {
            return null;
        }
        return entities.stream()
                .map(account -> toDto(account))
                .collect(Collectors.toList());
    }
}
