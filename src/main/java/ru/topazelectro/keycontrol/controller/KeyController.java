package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.KeyDto;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.exceptions.KeyGroupNotExistException;
import ru.topazelectro.keycontrol.service.KeyService;

import javax.inject.Inject;

@RestController
@RequestMapping("api/v1/")
public class KeyController {
    @Inject
    KeyService keyService;

    @GetMapping("/key/all")
    @Tag(name = "Ключи", description = "Работа с ключами")
    @Operation(summary = "Получить весь список ключей")
    public Page<KeyDto> getAllKeys(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                   @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/key")
    @Tag(name = "Ключи")
    @Operation(summary = "Получить ключ по ID")
    public ResponseEntity<?> getKeyById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(keyService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/key")
    @Tag(name = "Ключи")
    @Operation(summary = "Сохранить новый ключ в БД")
    public ResponseEntity<?> saveKey(@RequestBody KeyDto keyDto) throws IdNotNullException, KeyGroupNotExistException {
        try {
            return new ResponseEntity<>(keyService.save(keyDto), HttpStatus.OK);
        } catch (KeyGroupNotExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/key")
    @Tag(name = "Ключи")
    @Operation(summary = "Изменить информацию о ключе в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ResponseEntity<?> editKey(@RequestBody KeyDto keyDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(keyService.update(keyDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
