package ru.topazelectro.keycontrol.service.mapping;

import ru.topazelectro.keycontrol.dto.KeyTypeDto;
import ru.topazelectro.keycontrol.entity.KeyTypeEntity;

public class KeyTypeMappingService implements MappingService<KeyTypeDto, KeyTypeEntity> {
    @Override
    public KeyTypeDto toDTO(KeyTypeEntity keyTypeEntity) {
        return null;
    }

    @Override
    public KeyTypeEntity fromDTO(KeyTypeDto keyTypeDto) {
        return null;
    }
}
