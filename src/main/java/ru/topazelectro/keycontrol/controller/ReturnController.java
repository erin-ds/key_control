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
public class ReturnController {
    @Inject
    ReturnService returnService;

    @GetMapping("/returns/all")
    @Tag(name = "Возвраты", description = "Даты планируемого и фактического возврата")
    @Operation(summary = "Получить весь список возвратов")
    public Page<ReturnDto> getAllReturns(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                         @RequestParam(defaultValue = "10", required = false) int listSize) {
        return returnService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Получить информацию о возврате по ID")
    public ReturnDto getReturnById(@RequestParam Long id) {
        return returnService.getById(id);
    }

    @PostMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Сохранить новую информацию о возврате в БД")
    public ReturnDto saveReturn(@RequestBody ReturnDto returnDto) {
        return returnService.save(returnDto);
    }

    @PutMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Изменить информацию о возврате в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ReturnDto editReturn(@RequestBody ReturnDto returnDto) {
        return returnService.update(returnDto);
    }

}
