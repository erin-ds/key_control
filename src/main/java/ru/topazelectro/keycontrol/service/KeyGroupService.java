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
    public KeyGroupDto toDTO(KeyGroup keyGroup) {
        KeyGroupDto dto = KeyGroupDto.builder()
                .number(keyGroup.getNumber())
                .partnerId(keyGroup.getPartner().getId())
                .build();
        dto.setId(keyGroup.getId());
        dto.setComment(keyGroup.getComment());
        return dto;
    }

    @Override
    public KeyGroup fromDTO(KeyGroupDto keyGroupDto) {
        KeyGroup entity = findByIdForMapping(keyGroupDto.getId()).orElse(new KeyGroup());
        entity.setPartner(partnerService.findByIdForMapping(keyGroupDto.getPartnerId()).get());
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
