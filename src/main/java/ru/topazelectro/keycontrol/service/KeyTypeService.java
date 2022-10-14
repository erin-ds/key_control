package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyTypeDto;
import ru.topazelectro.keycontrol.entity.KeyTypeEntity;
import ru.topazelectro.keycontrol.repository.KeyTypeRepository;

@Service
public class KeyTypeService extends CommonService<KeyTypeEntity, KeyTypeDto, KeyTypeRepository> {

    @Override
    public KeyTypeDto toDTO(KeyTypeEntity keyTypeEntity) {
        KeyTypeDto dto = KeyTypeDto.builder()
                .name(keyTypeEntity.getName())
                .build();
        dto.setId(keyTypeEntity.getId());
        dto.setComment(keyTypeEntity.getComment());
        return dto;
    }

    @Override
    public KeyTypeEntity fromDTO(KeyTypeDto keyTypeDto) {
        KeyTypeEntity entity = findByIdForMapping(keyTypeDto.getId()).orElse(new KeyTypeEntity());
        entity.setName(keyTypeDto.getName());
        entity.setId(keyTypeDto.getId());
        entity.setComment(keyTypeDto.getComment());
        return entity;
    }
}
