package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyGroupDto;
import ru.topazelectro.keycontrol.entity.KeyGroupEntity;
import ru.topazelectro.keycontrol.repository.KeyGroupRepository;

import javax.inject.Inject;

@Service
public class KeyGroupService extends CommonService<KeyGroupEntity, KeyGroupDto, KeyGroupRepository> {

    @Inject
    KeyGroupRepository keyGroupRepository;

    @Override
    public KeyGroupDto toDTO(KeyGroupEntity keyGroupEntity) {
        KeyGroupDto dto = KeyGroupDto.builder()
                .number(keyGroupEntity.getNumber())
                .partnerId(keyGroupEntity.getPartnerId())
                .build();
        dto.setId(keyGroupEntity.getId());
        dto.setComment(keyGroupEntity.getComment());
        return dto;
    }

    @Override
    public KeyGroupEntity fromDTO(KeyGroupDto keyGroupDto) {
        KeyGroupEntity entity = keyGroupRepository.findById(keyGroupDto.getId()).orElse(new KeyGroupEntity());
        entity.setId(keyGroupDto.getId());
        entity.setNumber(keyGroupDto.getNumber());
        entity.setComment(keyGroupDto.getComment());
        entity.setPartnerId(keyGroupDto.getPartnerId());
        return entity;
    }
}