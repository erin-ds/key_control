package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.SoftwareDto;
import ru.topazelectro.keycontrol.entity.SoftwareEntity;
import ru.topazelectro.keycontrol.repository.SoftwareRepository;

@Service
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
        SoftwareEntity entity = findByIdForMapping(softwareDto.getId()).orElse(new SoftwareEntity());
        entity.setName(softwareDto.getName());
        entity.setId(softwareDto.getId());
        entity.setComment(softwareDto.getComment());
        return entity;
    }
}
