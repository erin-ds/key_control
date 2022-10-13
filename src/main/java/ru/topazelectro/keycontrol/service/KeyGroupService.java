package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyGroupDto;
import ru.topazelectro.keycontrol.entity.KeyGroupEntity;
import ru.topazelectro.keycontrol.repository.KeyGroupRepository;

import javax.inject.Inject;

@Service
public class KeyGroupService extends CommonService<KeyGroupEntity, KeyGroupDto, KeyGroupRepository> {

    @Inject
    PartnerService partnerService;

    @Override
    public KeyGroupDto toDTO(KeyGroupEntity keyGroupEntity) {
        KeyGroupDto dto = KeyGroupDto.builder()
                .number(keyGroupEntity.getNumber())
                .partnerId(keyGroupEntity.getPartnerEntity().getId())
                .build();
        dto.setId(keyGroupEntity.getId());
        dto.setComment(keyGroupEntity.getComment());
        return dto;
    }

    @Override
    public KeyGroupEntity fromDTO(KeyGroupDto keyGroupDto) {
        KeyGroupEntity entity = findByIdForMapping(keyGroupDto.getId()).orElse(new KeyGroupEntity());
        entity.setId(keyGroupDto.getId());
        entity.setNumber(keyGroupDto.getNumber());
        entity.setComment(keyGroupDto.getComment());
        entity.setPartnerEntity(partnerService.findByIdForMapping(keyGroupDto.getId()).get());
        return entity;
    }
}
