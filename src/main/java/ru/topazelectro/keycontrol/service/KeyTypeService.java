package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyTypeDto;
import ru.topazelectro.keycontrol.entity.KeyType;
import ru.topazelectro.keycontrol.exceptions.KeyTypeAlreadyExistException;
import ru.topazelectro.keycontrol.repository.KeyTypeRepository;

import javax.inject.Inject;

@Service
public class KeyTypeService extends CommonService<KeyType, KeyTypeDto, KeyTypeRepository> {

    @Inject
    KeyTypeRepository keyTypeRepository;

    @Override
    public KeyTypeDto toDTO(KeyType keyType) {
        KeyTypeDto dto = KeyTypeDto.builder()
                .name(keyType.getName())
                .build();
        dto.setId(keyType.getId());
        dto.setComment(keyType.getComment());
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

    @Override
    public KeyTypeDto save(KeyTypeDto keyTypeDto) {
        if (keyTypeRepository.findByName(keyTypeDto.getName()).isPresent()) {
            throw new KeyTypeAlreadyExistException();
        } else {
            return super.save(keyTypeDto);
        }
    }
}
