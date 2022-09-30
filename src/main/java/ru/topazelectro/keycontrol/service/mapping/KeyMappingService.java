package ru.topazelectro.keycontrol.service.mapping;

import ru.topazelectro.keycontrol.dto.KeyDto;
import ru.topazelectro.keycontrol.entity.KeyEntity;

public class KeyMappingService implements MappingService<KeyDto, KeyEntity> {

    @Override
    public KeyDto toDTO(KeyEntity keyEntity) {
        return null;
    }

    @Override
    public KeyEntity fromDTO(KeyDto keyDto) {
        return null;
    }
}
