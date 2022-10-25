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
    public KeyDto getKeyById(@RequestParam Long id) {
        return keyService.getById(id);
    }

    @PostMapping("/key")
    @Tag(name = "Ключи")
    @Operation(summary = "Сохранить новый ключ в БД")
    public KeyDto saveKey(@RequestBody KeyDto keyDto) {
        return keyService.save(keyDto);
    }

    @PutMapping("/key")
    @Tag(name = "Ключи")
    @Operation(summary = "Изменить информацию о ключе в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public KeyDto editKey(@RequestBody KeyDto keyDto) {
        return keyService.update(keyDto);
    }

}
