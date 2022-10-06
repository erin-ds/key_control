package ru.topazelectro.keycontrol.service;


import ru.topazelectro.keycontrol.dto.CommonDto;
import ru.topazelectro.keycontrol.entity.CommonEntity;
import ru.topazelectro.keycontrol.repository.CommonRepository;

import javax.inject.Inject;
import java.util.Optional;

public abstract class CommonService<KEY_CONTROL_ENTITY extends CommonEntity, KEY_CONTROL_DTO extends CommonDto, REPOSITORY extends CommonRepository<KEY_CONTROL_ENTITY>> {

    @Inject
    private REPOSITORY repository;

    public Optional<KEY_CONTROL_ENTITY> findById(Long id) {
        if (id == null) return Optional.empty();
        return repository.findById(id);
    }

    abstract KEY_CONTROL_DTO toDTO (KEY_CONTROL_ENTITY keyControlEntity);
    abstract KEY_CONTROL_ENTITY fromDTO(KEY_CONTROL_DTO keyControlDto);
}
