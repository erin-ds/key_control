package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.KeyTypeDto;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.exceptions.KeyTypeAlreadyExistException;
import ru.topazelectro.keycontrol.service.KeyTypeService;

import javax.inject.Inject;

@RestController
@RequestMapping("api/v1/")
public class KeyTypeController {
    @Inject
    KeyTypeService keyTypeService;

    @GetMapping("/key-type/all")
    @Tag(name = "Типы ключей", description = "Тип подключения (USB\\LPT), тип ключа (сетевой\\локальный)")
    @Operation(summary = "Получить список всех типов ключей")
    public Page<KeyTypeDto> getAllKeyTypes(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                           @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyTypeService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation(summary = "Получить тип ключа по ID")
    public ResponseEntity<?> getKeyType(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(keyTypeService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation(summary = "Сохранить новый тип ключа в БД")
    public ResponseEntity<?> saveKeyType(@RequestBody KeyTypeDto keyTypeDto) throws IdNotNullException, KeyTypeAlreadyExistException {
        try {
            return new ResponseEntity<>(keyTypeService.save(keyTypeDto), HttpStatus.OK);
        } catch (KeyTypeAlreadyExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation(summary = "Изменить информацию о типе ключа в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ResponseEntity<?> editKeyType(@RequestBody KeyTypeDto keyTypeDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(keyTypeService.update(keyTypeDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
