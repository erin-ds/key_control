package ru.topazelectro.keycontrol.service.mapping;

import ru.topazelectro.keycontrol.dto.SaleDto;
import ru.topazelectro.keycontrol.entity.SaleEntity;

public class SaleMappingService implements MappingService<SaleDto, SaleEntity> {

    @Override
    public SaleDto toDTO(SaleEntity saleEntity) {
        return null;
    }

    @Override
    public SaleEntity fromDTO(SaleDto saleDto) {
        return null;
    }
}
