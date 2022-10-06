package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.PartnerDto;
import ru.topazelectro.keycontrol.entity.PartnerEntity;
import ru.topazelectro.keycontrol.repository.PartnerRepository;
@Service
public class PartnerService extends CommonService<PartnerEntity, PartnerDto, PartnerRepository> {
    @Override
    public PartnerDto toDTO(PartnerEntity partnerEntity) {
        PartnerDto dto = PartnerDto.builder()
                .name(partnerEntity.getName())
                .city(partnerEntity.getCity())
                .build();
        dto.setId(partnerEntity.getId());
        dto.setComment(partnerEntity.getComment());
        return dto;
    }

    @Override
    public PartnerEntity fromDTO(PartnerDto partnerDto) {
        PartnerEntity entity = findById(partnerDto.getId()).orElse(new PartnerEntity());
        entity.setId(partnerDto.getId());
        entity.setName(partnerDto.getName());
        entity.setCity(partnerDto.getCity());
        entity.setComment(partnerDto.getComment());
        return entity;
    }
}
