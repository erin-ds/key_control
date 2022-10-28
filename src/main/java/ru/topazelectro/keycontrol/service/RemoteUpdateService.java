package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.RemoteUpdateDto;
import ru.topazelectro.keycontrol.entity.RemoteUpdate;
import ru.topazelectro.keycontrol.exceptions.KeyNotExistException;
import ru.topazelectro.keycontrol.repository.RemoteUpdateRepository;

import javax.inject.Inject;

@Service
public class RemoteUpdateService extends CommonService<RemoteUpdate, RemoteUpdateDto, RemoteUpdateRepository> {

    @Inject
    KeyService keyService;

    @Override
    public RemoteUpdateDto toDTO(RemoteUpdate remoteUpdate) {
        RemoteUpdateDto dto = RemoteUpdateDto.builder()
                .keyId(remoteUpdate.getKey().getId())
                .orderNumber(remoteUpdate.getOrderNumber())
                .billNumber(remoteUpdate.getBillNumber())
                .updateDate(remoteUpdate.getUpdateDate())
                .build();
        dto.setId(remoteUpdate.getId());
        dto.setComment(remoteUpdate.getComment());
        return dto;
    }

    @Override
    public RemoteUpdate fromDTO(RemoteUpdateDto remoteUpdateDto) {
        RemoteUpdate entity = findByIdForMapping(remoteUpdateDto.getId()).orElse(new RemoteUpdate());
        entity.setOrderNumber(remoteUpdateDto.getOrderNumber());
        entity.setBillNumber(remoteUpdateDto.getBillNumber());
        entity.setUpdateDate(remoteUpdateDto.getUpdateDate());
        entity.setKey(keyService.findByIdForMapping(remoteUpdateDto.getKeyId()).get());
        entity.setId(remoteUpdateDto.getId());
        entity.setComment(remoteUpdateDto.getComment());
        return entity;
    }

    @Override
    public RemoteUpdateDto save(RemoteUpdateDto remoteUpdateDto) {
        if (!keyService.findByIdForMapping(remoteUpdateDto.getKeyId()).isPresent()) {
            throw new KeyNotExistException(remoteUpdateDto.getKeyId());
        } else {
            return super.save(remoteUpdateDto);
        }
    }
}
