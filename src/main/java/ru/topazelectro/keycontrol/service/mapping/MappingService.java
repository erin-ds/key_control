package ru.topazelectro.keycontrol.service.mapping;


public interface MappingService <KEY_CONTROL_DTO, KEY_CONTROL_ENTITY> {

    KEY_CONTROL_DTO toDTO (KEY_CONTROL_ENTITY keyControlEntity);
    KEY_CONTROL_ENTITY fromDTO(KEY_CONTROL_DTO keyControlDto);
}
