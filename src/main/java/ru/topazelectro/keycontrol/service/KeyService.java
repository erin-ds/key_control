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
    public KeyDto toDTO(Key key) {
        KeyDto dto = KeyDto.builder()
                .typeId(key.getKeyType().getId())
                .numberDec(key.getNumberDec())
                .numberHex(key.getNumberHex())
                .build();
        dto.setId(key.getId());
        dto.setComment(key.getComment());
        return dto;
    }

    @Override
    public Key fromDTO(KeyDto keyDto) {
        Key entity = findByIdForMapping(keyDto.getId()).orElse(new Key());
        entity.setKeyType(keyTypeService.findByIdForMapping(keyDto.getTypeId()).get());
        entity.setNumberHex(keyDto.getNumberHex());
        entity.setNumberDec(keyDto.getNumberDec());
        entity.setId(keyDto.getId());
        entity.setComment(keyDto.getComment());
        return entity;
    }
}
