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
public class SoftwareController {
    @Inject
    SoftwareService softwareService;

    @GetMapping("/software/all")
    @Tag(name = "Типы программного обеспечения", description = "Топаз-АСЗ, Топаз-Офис и т.д.")
    @Operation(summary = "Получить весь список типов ПО")
    public Page<SoftwareDto> getAllSoftware(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                            @RequestParam(defaultValue = "10", required = false) int listSize) {
        return softwareService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation(summary = "Получить тип ПО по ID")
    public SoftwareDto getSoftwareById(@RequestParam Long id) {
        return softwareService.getById(id);
    }

    @PostMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation(summary = "Сохранить новый тип ПО в БД")
    public SoftwareDto saveSoftware(@RequestBody SoftwareDto softwareDto) {
        return softwareService.save(softwareDto);
    }

    @PutMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation(summary = "Изменить тип ПО", description = "Сюда нужно так же передавать ID изменяемой записи")
    public SoftwareDto editSoftware(@RequestBody SoftwareDto softwareDto) {
        return softwareService.update(softwareDto);
    }

}
