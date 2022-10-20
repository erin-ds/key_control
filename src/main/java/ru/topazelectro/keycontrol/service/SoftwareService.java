package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.SoftwareDto;
import ru.topazelectro.keycontrol.entity.Software;
import ru.topazelectro.keycontrol.exceptions.SoftwareAlreadyExistException;
import ru.topazelectro.keycontrol.repository.SoftwareRepository;

import javax.inject.Inject;

@Service
public class SoftwareService extends CommonService<Software, SoftwareDto, SoftwareRepository> {

    @Inject
    SoftwareRepository softwareRepository;

    @Override
    public SoftwareDto toDTO(Software softwareEntity) {
        SoftwareDto dto = SoftwareDto.builder().name(softwareEntity.getName()).build();
        dto.setId(softwareEntity.getId());
        dto.setComment(softwareEntity.getComment());
        return dto;
    }

    @Override
    public Software fromDTO(SoftwareDto softwareDto) {
        Software entity = findByIdForMapping(softwareDto.getId()).orElse(new Software());
        entity.setName(softwareDto.getName());
        entity.setId(softwareDto.getId());
        entity.setComment(softwareDto.getComment());
        return entity;
    }


    @Override
    public SoftwareDto save(SoftwareDto softwareDto) {
        if (softwareRepository.findByName(softwareDto.getName()).isPresent()) {
            throw new SoftwareAlreadyExistException();
        } else {
            return super.save(softwareDto);
        }
    }

}
