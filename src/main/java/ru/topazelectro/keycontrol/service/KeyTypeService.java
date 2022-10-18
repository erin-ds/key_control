package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyTypeDto;
import ru.topazelectro.keycontrol.entity.KeyType;
import ru.topazelectro.keycontrol.repository.KeyTypeRepository;

@Service
public class KeyTypeService extends CommonService<KeyType, KeyTypeDto, KeyTypeRepository> {

    @Override
    public KeyTypeDto toDTO(KeyType keyTypeEntity) {
        KeyTypeDto dto = KeyTypeDto.builder()
                .name(keyTypeEntity.getName())
                .build();
        dto.setId(keyTypeEntity.getId());
        dto.setComment(keyTypeEntity.getComment());
        return dto;
    }

    @Override
    public KeyType fromDTO(KeyTypeDto keyTypeDto) {
        KeyType entity = findByIdForMapping(keyTypeDto.getId()).orElse(new KeyType());
        entity.setName(keyTypeDto.getName());
        entity.setId(keyTypeDto.getId());
        entity.setComment(keyTypeDto.getComment());
        return entity;
    }
}
