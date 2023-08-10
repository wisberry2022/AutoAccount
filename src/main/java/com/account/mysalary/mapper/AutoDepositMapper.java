package com.account.mysalary.mapper;

import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.entity.Account;
import com.account.mysalary.entity.AutoDeposit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AutoDepositMapper {

    @Mapping(target="id", ignore = true)
    @Mapping(target="withdrawal", source="entity")
    @Mapping(target="name", source="dto.name")
    @Mapping(target="deposit", source="dto.deposit")
    @Mapping(target="amount", source="dto.amount")
    @Mapping(target="date", source="dto.date")
    AutoDeposit dtoToEntity(DebitDto dto, Account entity);


    DebitDto entityToDto(AutoDeposit entity);

    @Mapping(target="withdrawal", ignore = true)
    List<DebitDto> entitiesToDtos(List<AutoDeposit> entities);

    default String map(Account account) {
        if(account == null) {
            return null;
        }
        return account.getSerial();
    }

}
