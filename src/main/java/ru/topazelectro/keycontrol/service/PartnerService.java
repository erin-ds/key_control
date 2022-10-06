package ru.topazelectro.keycontrol.service;

import ru.topazelectro.keycontrol.dto.PartnerDto;
import ru.topazelectro.keycontrol.entity.PartnerEntity;
import ru.topazelectro.keycontrol.repository.PartnerRepository;

public class PartnerService extends CommonService<PartnerEntity, PartnerDto, PartnerRepository> {
    @Override
    public PartnerDto toDTO(PartnerEntity partnerEntity) {
        return null;
    }

    @Override
    public PartnerEntity fromDTO(PartnerDto partnerDto) {
        return null;
    }
}
