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
    public KeyTypeDto getKeyType(@RequestParam Long id) {
        return keyTypeService.getById(id);
    }

    @PostMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation(summary = "Сохранить новый тип ключа в БД")
    public KeyTypeDto saveKeyType(@RequestBody KeyTypeDto keyTypeDto) {
        return keyTypeService.save(keyTypeDto);
    }

    @PutMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation(summary = "Изменить информацию о типе ключа в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public KeyTypeDto editKeyType(@RequestBody KeyTypeDto keyTypeDto) {
        return keyTypeService.update(keyTypeDto);
    }

}
