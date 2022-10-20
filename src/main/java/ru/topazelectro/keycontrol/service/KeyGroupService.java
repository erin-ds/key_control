package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.KeyGroupDto;
import ru.topazelectro.keycontrol.entity.KeyGroup;
import ru.topazelectro.keycontrol.exceptions.NumberAlreadyExistException;
import ru.topazelectro.keycontrol.repository.KeyGroupRepository;

import javax.inject.Inject;

@Service
public class KeyGroupService extends CommonService<KeyGroup, KeyGroupDto, KeyGroupRepository> {

    @Inject
    PartnerService partnerService;

    @Inject
    KeyGroupRepository keyGroupRepository;

    @Override
    public KeyGroupDto toDTO(KeyGroup keyGroupEntity) {
        KeyGroupDto dto = KeyGroupDto.builder()
                .number(keyGroupEntity.getNumber())
                .partnerId(keyGroupEntity.getPartnerEntity().getId())
                .build();
        dto.setId(keyGroupEntity.getId());
        dto.setComment(keyGroupEntity.getComment());
        return dto;
    }

    @Override
    public KeyGroup fromDTO(KeyGroupDto keyGroupDto) {
        KeyGroup entity = findByIdForMapping(keyGroupDto.getId()).orElse(new KeyGroup());
        entity.setPartnerEntity(partnerService.findByIdForMapping(keyGroupDto.getPartnerId()).get());
        entity.setId(keyGroupDto.getId());
        entity.setNumber(keyGroupDto.getNumber());

        entity.setComment(keyGroupDto.getComment());
        return entity;
    }

    @Override
    public KeyGroupDto save(KeyGroupDto keyGroupDto) {
        if (keyGroupRepository.findByNumber(keyGroupDto.getNumber()).isPresent()) {
            throw new NumberAlreadyExistException();
        } else {
            return super.save(keyGroupDto);
        }
    }
}
