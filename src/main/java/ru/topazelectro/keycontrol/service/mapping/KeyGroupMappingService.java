package ru.topazelectro.keycontrol.service.mapping;

import ru.topazelectro.keycontrol.dto.KeyGroupDto;
import ru.topazelectro.keycontrol.entity.KeyGroupEntity;

public class KeyGroupMappingService implements MappingService<KeyGroupDto, KeyGroupEntity> {

    @Override
    public KeyGroupDto toDTO(KeyGroupEntity keyGroupEntity) {

        return KeyGroupDto.builder()
                .number(keyGroupEntity.getNumber())
                .partnerId(keyGroupEntity.getPartnerId().getId())
                .comment(keyGroupEntity.getComment())
                .build();
    }

    @Override
    public KeyGroupEntity fromDTO(KeyGroupDto keyGroupDto) {
        KeyGroupEntity entity;
        return null;
    }
}
