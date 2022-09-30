package ru.topazelectro.keycontrol.service.mapping;

import ru.topazelectro.keycontrol.dto.SoftwareDto;
import ru.topazelectro.keycontrol.entity.SoftwareEntity;

public class SoftwareMappingService implements MappingService<SoftwareDto, SoftwareEntity> {

    @Override
    public SoftwareDto toDTO(SoftwareEntity softwareEntity) {
        return null;
    }

    @Override
    public SoftwareEntity fromDTO(SoftwareDto softwareDto) {
        return null;
    }
}
