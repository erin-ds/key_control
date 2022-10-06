package ru.topazelectro.keycontrol.service;

import ru.topazelectro.keycontrol.dto.KeyTypeDto;
import ru.topazelectro.keycontrol.entity.KeyTypeEntity;
import ru.topazelectro.keycontrol.repository.KeyTypeRepository;

public class KeyTypeService extends CommonService<KeyTypeEntity, KeyTypeDto, KeyTypeRepository> {
    @Override
    public KeyTypeDto toDTO(KeyTypeEntity keyTypeEntity) {
        return null;
    }

    @Override
    public KeyTypeEntity fromDTO(KeyTypeDto keyTypeDto) {
        return null;
    }
}
