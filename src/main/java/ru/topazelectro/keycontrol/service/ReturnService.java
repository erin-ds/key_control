package ru.topazelectro.keycontrol.service;

import ru.topazelectro.keycontrol.dto.ReturnDto;
import ru.topazelectro.keycontrol.entity.ReturnEntity;
import ru.topazelectro.keycontrol.repository.ReturnRepository;

public class ReturnService extends CommonService<ReturnEntity, ReturnDto, ReturnRepository> {

    @Override
    public ReturnDto toDTO(ReturnEntity returnEntity) {
        return null;
    }

    @Override
    public ReturnEntity fromDTO(ReturnDto returnDto) {
        return null;
    }
}
