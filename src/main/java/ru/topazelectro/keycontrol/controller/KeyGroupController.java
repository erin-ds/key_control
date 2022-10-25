package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.*;
import ru.topazelectro.keycontrol.service.*;

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
    public KeyGroupDto getKeyGroupById(@RequestParam Long id) {
        return keyGroupService.getById(id);
    }

    @PostMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Сохранить новую группу в БД")
    public KeyGroupDto saveKeyGroup(@RequestBody KeyGroupDto keyGroupDto) {
        return keyGroupService.save(keyGroupDto);
    }

    @PutMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Изменить информацию о группе в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public KeyGroupDto editKeyGroup(@RequestBody KeyGroupDto keyGroupDto) {
        return keyGroupService.update(keyGroupDto);
    }

}
