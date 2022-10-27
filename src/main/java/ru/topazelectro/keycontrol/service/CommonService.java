package ru.topazelectro.keycontrol.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.topazelectro.keycontrol.dto.CommonDto;
import ru.topazelectro.keycontrol.entity.CommonEntity;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.repository.CommonRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CommonService<KEY_CONTROL extends CommonEntity, KEY_CONTROL_DTO extends CommonDto, REPOSITORY extends CommonRepository<KEY_CONTROL>> {

    @Inject
    private REPOSITORY repository;

    public Optional<KEY_CONTROL> findByIdForMapping(Long id) {
        if (id == null) return Optional.empty();
        return repository.findById(id);
    }


    public Page<KEY_CONTROL_DTO> getAllEntities(int page, int listSize) {
        Pageable pageable = PageRequest.of(page - 1, listSize);
        List<KEY_CONTROL_DTO> dtoList = repository
                .findAll(pageable)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList);

    }

    public KEY_CONTROL_DTO getById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id не должен быть null");
        } else {
            return toDTO(repository.findById(id).orElseThrow(() -> new IdNotFoundException(id)));
        }
    }

    public KEY_CONTROL_DTO save(KEY_CONTROL_DTO dto) {
        if (dto.getId() == null) {
            KEY_CONTROL entity = fromDTO(dto);
            return toDTO(repository.save(entity));
        } else {
            throw new IdNotNullException();
        }
    }

    public KEY_CONTROL_DTO update(KEY_CONTROL_DTO dto) {
        if (dto.getId() == null || !repository.existsById(dto.getId())) {
            throw new EmptyOrNonExistingIdException();
        } else {
            KEY_CONTROL entity = fromDTO(dto);
            return toDTO(repository.save(entity));
        }
    }

    abstract KEY_CONTROL_DTO toDTO(KEY_CONTROL keyControl);

    abstract KEY_CONTROL fromDTO(KEY_CONTROL_DTO keyControlDto);
}
