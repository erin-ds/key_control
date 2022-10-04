package ru.topazelectro.keycontrol.service;


import ru.topazelectro.keycontrol.dto.CommonDto;
import ru.topazelectro.keycontrol.entity.CommonEntity;
import ru.topazelectro.keycontrol.repository.KeysControlRepository;

import javax.inject.Inject;
import java.util.Optional;

public abstract class KeyControlService<KEYS_DTO extends CommonDto, KEYS_ENTITY extends CommonEntity> {

    @Inject
    private KeysControlRepository repository;

    public Optional<CommonEntity> findById(Long id) {
        if (id == null) return Optional.empty();
        return repository.findById(id);
    }

}
