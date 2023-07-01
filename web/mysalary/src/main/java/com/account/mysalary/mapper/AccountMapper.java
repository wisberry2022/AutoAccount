package com.account.mysalary.mapper;

import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target="id", ignore = true)
    Account dtoToEntity(OpenDto dto);

}
