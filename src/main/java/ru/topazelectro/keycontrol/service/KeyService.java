package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyDto;
import ru.topazelectro.keycontrol.entity.KeyEntity;
import ru.topazelectro.keycontrol.repository.KeyRepository;

import javax.inject.Inject;

@Service
public class KeyService extends CommonService<KeyEntity, KeyDto, KeyRepository> {


    @Inject
    KeyTypeService keyTypeService;

    @Override
    public KeyDto toDTO(KeyEntity keyEntity) {
        KeyDto dto = KeyDto.builder()
                .typeId(keyEntity.getKeyTypeEntity().getId())
                .numberDec(keyEntity.getNumberDec())
                .numberHex(keyEntity.getNumberHex())
                .build();
        dto.setId(keyEntity.getId());
        dto.setComment(keyEntity.getComment());
        return dto;
    }

    @Override
    public KeyEntity fromDTO(KeyDto keyDto) {
        KeyEntity entity = findByIdForMapping(keyDto.getId()).orElse(new KeyEntity());
        entity.setKeyTypeEntity(keyTypeService.findByIdForMapping(keyDto.getTypeId()).get());
        entity.setNumberHex(keyDto.getNumberHex());
        entity.setNumberDec(keyDto.getNumberDec());
        entity.setId(keyDto.getId());
        entity.setComment(keyDto.getComment());
        return entity;
    }
}
