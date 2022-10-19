package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.ReturnDto;
import ru.topazelectro.keycontrol.entity.Return;
import ru.topazelectro.keycontrol.repository.ReturnRepository;

import javax.inject.Inject;

@Service
public class ReturnService extends CommonService<Return, ReturnDto, ReturnRepository> {

    @Inject
    SaleService saleService;

    @Override
    public ReturnDto toDTO(Return returnEntity) {
        ReturnDto dto = ReturnDto.builder()
                .dateFact(returnEntity.getDateFact())
                .datePlan(returnEntity.getDatePlan())
                .saleId(returnEntity.getSaleEntity().getId())
                .build();
        dto.setId(returnEntity.getId());
        dto.setComment(returnEntity.getComment());
        return dto;
    }

    @Override
    public Return fromDTO(ReturnDto returnDto) {
        Return entity = findByIdForMapping(returnDto.getId()).orElse(new Return());
        entity.setId(returnDto.getId());
        entity.setComment(returnDto.getComment());
        entity.setDateFact(returnDto.getDateFact());
        entity.setDatePlan(returnDto.getDatePlan());
        entity.setSaleEntity(saleService.findByIdForMapping(returnDto.getSaleId()).get());
        return entity;
    }
}
