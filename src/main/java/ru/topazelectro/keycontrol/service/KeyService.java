package ru.topazelectro.keycontrol.service;

import ru.topazelectro.keycontrol.dto.KeyDto;
import ru.topazelectro.keycontrol.entity.KeyEntity;
import ru.topazelectro.keycontrol.repository.KeyRepository;

public class KeyService extends CommonService<KeyEntity, KeyDto, KeyRepository> {

    @Override
    public KeyDto toDTO(KeyEntity keyEntity) {
        return null;
    }

    @Override
    public KeyEntity fromDTO(KeyDto keyDto) {
        return null;
    }
}
