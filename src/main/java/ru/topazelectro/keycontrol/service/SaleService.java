package ru.topazelectro.keycontrol.service;

import ru.topazelectro.keycontrol.dto.SaleDto;
import ru.topazelectro.keycontrol.entity.SaleEntity;
import ru.topazelectro.keycontrol.repository.SaleRepository;

public class SaleService extends CommonService<SaleEntity, SaleDto, SaleRepository> {

    @Override
    public SaleDto toDTO(SaleEntity saleEntity) {
        return null;
    }

    @Override
    public SaleEntity fromDTO(SaleDto saleDto) {
        return null;
    }
}
