package com.account.mysalary.mapper;

import com.account.mysalary.dto.AccountDto;
import com.account.mysalary.dto.InquiryDto;
import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target="id", ignore = true)
    Account dtoToEntity(OpenDto dto);

    List<InquiryDto> toDtos(List<Account> entities);

    @Mapping(target="debitCount", expression="java(entity.getAutoDeposits().size())")
    AccountDto entityToDto(Account entity);

}
