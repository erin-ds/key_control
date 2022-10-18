package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyDto;
import ru.topazelectro.keycontrol.entity.Key;
import ru.topazelectro.keycontrol.repository.KeyRepository;

import javax.inject.Inject;

@Service
public class KeyService extends CommonService<Key, KeyDto, KeyRepository> {


    @Inject
    KeyTypeService keyTypeService;

    @Override
    public KeyDto toDTO(Key keyEntity) {
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
    public Key fromDTO(KeyDto keyDto) {
        Key entity = findByIdForMapping(keyDto.getId()).orElse(new Key());
        entity.setKeyTypeEntity(keyTypeService.findByIdForMapping(keyDto.getTypeId()).get());
        entity.setNumberHex(keyDto.getNumberHex());
        entity.setNumberDec(keyDto.getNumberDec());
        entity.setId(keyDto.getId());
        entity.setComment(keyDto.getComment());
        return entity;
    }
}
