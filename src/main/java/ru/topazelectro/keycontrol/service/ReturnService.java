package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.ReturnDto;
import ru.topazelectro.keycontrol.entity.ReturnEntity;
import ru.topazelectro.keycontrol.repository.ReturnRepository;
@Service
public class ReturnService extends CommonService<ReturnEntity, ReturnDto, ReturnRepository> {

    @Override
    public ReturnDto toDTO(ReturnEntity returnEntity) {
        ReturnDto dto = ReturnDto.builder()
                .dateFact(returnEntity.getDateFact())
                .datePlan(returnEntity.getDatePlan())
                .saleId(returnEntity.getSaleId())
                .build();
        dto.setId(returnEntity.getId());
        dto.setComment(returnEntity.getComment());
        return dto;
    }

    @Override
    public ReturnEntity fromDTO(ReturnDto returnDto) {
        ReturnEntity entity = findById(returnDto.getId()).orElse(new ReturnEntity());
        entity.setId(returnDto.getId());
        entity.setComment(returnDto.getComment());
        entity.setDateFact(returnDto.getDateFact());
        entity.setDatePlan(returnDto.getDatePlan());
        entity.setSaleId(returnDto.getSaleId());
        return entity;
    }
}
