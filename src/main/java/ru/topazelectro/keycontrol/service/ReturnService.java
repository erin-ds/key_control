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
    public ReturnDto toDTO(Return aReturn) {
        ReturnDto dto = ReturnDto.builder()
                .dateFact(aReturn.getDateFact())
                .datePlan(aReturn.getDatePlan())
                .saleId(aReturn.getSale().getId())
                .build();
        dto.setId(aReturn.getId());
        dto.setComment(aReturn.getComment());
        return dto;
    }

    @Override
    public Return fromDTO(ReturnDto returnDto) {
        Return entity = findByIdForMapping(returnDto.getId()).orElse(new Return());
        entity.setId(returnDto.getId());
        entity.setComment(returnDto.getComment());
        entity.setDateFact(returnDto.getDateFact());
        entity.setDatePlan(returnDto.getDatePlan());
        entity.setSale(saleService.findByIdForMapping(returnDto.getSaleId()).get());
        return entity;
    }
}
