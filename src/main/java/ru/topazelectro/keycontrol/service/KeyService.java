package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyDto;
import ru.topazelectro.keycontrol.entity.Key;
import ru.topazelectro.keycontrol.exceptions.KeyTypeNotExistException;
import ru.topazelectro.keycontrol.repository.KeyRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeyService extends CommonService<Key, KeyDto, KeyRepository> {


    @Inject
    KeyTypeService keyTypeService;
    @Inject
    KeyRepository keyRepository;

    @Inject
    KeyGroupService keyGroupService;

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

    @Override
    public KeyDto save(KeyDto keyDto) {
        if (!keyTypeService.findByIdForMapping(keyDto.getTypeId()).isPresent()) {
            throw new KeyTypeNotExistException(keyDto.getTypeId());
        }
        return super.save(keyDto);
    }

    //    public KeyDto findByHex(String numberHex) {
//        if (numberHex == null) {
//            throw new RuntimeException("Номер ключа не должен быть null");
//        } else {
//            return toDTO(keyRepository.findByNumberHex(numberHex).orElseThrow(() ->
//                    new KeyNumberNotExistException(numberHex)));
//        }
//    }
    public List<KeyDto> getByHex(String hex) {
        if (hex == null) {
            throw new RuntimeException("Номер ключа не должен быть null");
        } else {
            return keyRepository
                    .findByNumberHex(hex)
                    .stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }
    }
}

