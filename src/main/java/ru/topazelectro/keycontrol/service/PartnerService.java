package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.PartnerDto;
import ru.topazelectro.keycontrol.entity.Partner;
import ru.topazelectro.keycontrol.exceptions.PartnerAlreadyExistException;
import ru.topazelectro.keycontrol.repository.PartnerRepository;

import javax.inject.Inject;

@Service
public class PartnerService extends CommonService<Partner, PartnerDto, PartnerRepository> {

    @Inject
    PartnerRepository partnerRepository;

    @Override
    public PartnerDto toDTO(Partner partnerEntity) {
        PartnerDto dto = PartnerDto.builder()
                .name(partnerEntity.getName())
                .city(partnerEntity.getCity())
                .build();
        dto.setId(partnerEntity.getId());
        dto.setComment(partnerEntity.getComment());
        return dto;
    }

    @Override
    public Partner fromDTO(PartnerDto partnerDto) {
        Partner entity = findByIdForMapping(partnerDto.getId()).orElse(new Partner());
        entity.setId(partnerDto.getId());
        entity.setName(partnerDto.getName());
        entity.setCity(partnerDto.getCity());
        entity.setComment(partnerDto.getComment());
        return entity;
    }

    @Override
    public PartnerDto save(PartnerDto partnerDto) {
        if (partnerRepository.findByName(partnerDto.getName()).isPresent()) {
            throw new PartnerAlreadyExistException();
        } else {
            return super.save(partnerDto);
        }
    }

}
