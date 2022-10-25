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
public class PartnerController {
    @Inject
    PartnerService partnerService;

    @GetMapping("/partner/all")
    @Tag(name = "Контрагенты", description = "Работа с контрагентами")
    @Operation(summary = "Получить список всех контрагентов")
    public Page<PartnerDto> getAllPartners(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                           @RequestParam(defaultValue = "10", required = false) int listSize) {
        return partnerService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation(summary = "Получить контрагента по ID")
    public PartnerDto getPartnerById(@RequestParam Long id) {
        return partnerService.getById(id);
    }

    @PostMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation(summary = "Сохранить нового контрагента в БД")
    public PartnerDto savePartner(@RequestBody PartnerDto partnerDto) {
        return partnerService.save(partnerDto);
    }

    @PutMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation(summary = "Изменить информацию о контрагенте в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public PartnerDto editPartner(@RequestBody PartnerDto partnerDto) {
        return partnerService.update(partnerDto);
    }

}
