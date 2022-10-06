package ru.topazelectro.keycontrol.service;

import ru.topazelectro.keycontrol.dto.SoftwareDto;
import ru.topazelectro.keycontrol.entity.SoftwareEntity;
import ru.topazelectro.keycontrol.repository.SoftwareRepository;

public class SoftwareService extends CommonService<SoftwareEntity, SoftwareDto, SoftwareRepository> {

    @Override
    public SoftwareDto toDTO(SoftwareEntity softwareEntity) {
        SoftwareDto dto = SoftwareDto.builder().name(softwareEntity.getName()).build();
        dto.setId(softwareEntity.getId());
        dto.setComment(softwareEntity.getComment());
        return dto;
    }

    @Override
    public SoftwareEntity fromDTO(SoftwareDto softwareDto) {
        return null;
    }
}
