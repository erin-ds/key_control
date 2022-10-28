package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.KeyGroupDto;
import ru.topazelectro.keycontrol.exceptions.*;
import ru.topazelectro.keycontrol.service.KeyGroupService;

import javax.inject.Inject;

@RestController
@RequestMapping("api/v1/")
public class KeyGroupController {

    @Inject
    KeyGroupService keyGroupService;


    @GetMapping("/key-group/all")
    @Tag(name = "Группы", description = "Работа с номерами групп")
    @Operation(summary = "Получить список всех групп")
    public Page<KeyGroupDto> getAllKeyGroups(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                             @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyGroupService.getAllEntities(pageNumber, listSize);
    }

    @GetMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Получить группу по ID")
    public ResponseEntity<?> getKeyGroupById(@RequestParam Long id) throws IdNotFoundException, PartnerNotExistException {
        try {
            return new ResponseEntity<>(keyGroupService.getById(id), HttpStatus.OK);
        } catch (PartnerNotExistException |IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Сохранить новую группу в БД")
    public ResponseEntity<?> saveKeyGroup(@RequestBody KeyGroupDto keyGroupDto) throws IdNotNullException, NumberAlreadyExistException {
        try {
            return new ResponseEntity<>(keyGroupService.save(keyGroupDto), HttpStatus.OK);
        } catch (NumberAlreadyExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Изменить информацию о группе в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ResponseEntity<?> editKeyGroup(@RequestBody KeyGroupDto keyGroupDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(keyGroupService.update(keyGroupDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
