package ru.topazelectro.keycontrol.service.mapping;


import ru.topazelectro.keycontrol.dto.CommonDto;
import ru.topazelectro.keycontrol.entity.CommonEntity;

public interface MappingService <KEY_CONTROL_DTO extends CommonDto, KEY_CONTROL_ENTITY extends CommonEntity> {

    KEY_CONTROL_DTO toDTO (KEY_CONTROL_ENTITY keyControlEntity);
    KEY_CONTROL_ENTITY fromDTO(KEY_CONTROL_DTO keyControlDto);
}
