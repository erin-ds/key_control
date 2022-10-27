package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.RemoteUpdateDto;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.exceptions.PartnerAlreadyExistException;
import ru.topazelectro.keycontrol.service.RemoteUpdateService;

import javax.inject.Inject;

@RestController
@RequestMapping("api/v1/")
public class RemoteUpdateController {

    @Inject
    RemoteUpdateService remoteUpdateService;

    @GetMapping("/remote-update/all")
    @Tag(name = "Удалённая прошивка", description = "Даты прошивок")
    @Operation(summary = "Получить все данные о ключах которые подлежат или подлежали удалённой прошивки")
    public Page<RemoteUpdateDto> getAllRemoteUpdates(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                                     @RequestParam(defaultValue = "10", required = false) int listSize) {
        return remoteUpdateService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/remote-update")
    @Tag(name = "Удалённая прошивка")
    @Operation(summary = "Получить информацию о статусах удалённых прошивок по ID")
    public ResponseEntity<?> getRemoteUpdateById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(remoteUpdateService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/remote-update")
    @Tag(name = "Удалённая прошивка")
    @Operation(summary = "Сохранить новую информацию о статусе удалённой прошивке в БД")
    public ResponseEntity<?> saveRemoteUpdate(@RequestBody RemoteUpdateDto remoteUpdateDto) throws IdNotNullException {
        try {
            return new ResponseEntity<>(remoteUpdateService.save(remoteUpdateDto), HttpStatus.OK);
        } catch (IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/remote-update")
    @Tag(name = "Удалённая прошивка")
    @Operation(summary = "Изменить информацию о статусе удалённой прошивке в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ResponseEntity<?> editRemoteUpdate(@RequestBody RemoteUpdateDto remoteUpdateDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(remoteUpdateService.update(remoteUpdateDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
