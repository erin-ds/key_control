package ru.topazelectro.keycontrol.service;


import ru.topazelectro.keycontrol.dto.CommonDto;
import ru.topazelectro.keycontrol.entity.CommonEntity;
import ru.topazelectro.keycontrol.repository.CommonRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CommonService<KEY_CONTROL_ENTITY extends CommonEntity, KEY_CONTROL_DTO extends CommonDto, REPOSITORY extends CommonRepository<KEY_CONTROL_ENTITY>> {

    @Inject
    private REPOSITORY repository;

    public Optional<KEY_CONTROL_ENTITY> findByIdForMapping(Long id) {
        if (id == null) return Optional.empty();
        return repository.findById(id);
    }


    public List<KEY_CONTROL_DTO> getAllEntities() {
        return repository
                .findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public KEY_CONTROL_DTO getById(Long id) {
        return toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException("Id не найден")));
    }

    public KEY_CONTROL_DTO save(KEY_CONTROL_DTO dto) {
        if (dto.getId() == null) {
            KEY_CONTROL_ENTITY entity = fromDTO(dto);
            return toDTO(repository.save(entity));
        } else {
            throw new RuntimeException("Для новой записи id всегда должен быть null");
        }
    }

    public KEY_CONTROL_DTO update(KEY_CONTROL_DTO dto) {
        if (dto.getId() == null) {
            throw new RuntimeException("Для существующей записи id должен быть указан");
        } else {
            KEY_CONTROL_ENTITY entity = repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Id не найден"));
            return toDTO(repository.save(entity));
        }
    }

    abstract KEY_CONTROL_DTO toDTO(KEY_CONTROL_ENTITY keyControlEntity);

    abstract KEY_CONTROL_ENTITY fromDTO(KEY_CONTROL_DTO keyControlDto);
}
