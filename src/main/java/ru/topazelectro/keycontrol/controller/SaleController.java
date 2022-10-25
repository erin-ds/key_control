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
public class SaleController {
    @Inject
    SaleService saleService;

    @GetMapping("/sale/all")
    @Tag(name = "Продажи", description = "Полная информация по продажам")
    @Operation(summary = "Получить весь список продаж")
    public Page<SaleDto> getAllSales(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                     @RequestParam(defaultValue = "10", required = false) int listSize) {
        return saleService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/sale")
    @Tag(name = "Продажи")
    @Operation(summary = "Получить продажу по ID")
    public SaleDto getSaleById(@RequestParam Long id) {
        return saleService.getById(id);
    }

    @PostMapping("/sale")
    @Tag(name = "Продажи")
    @Operation(summary = "Сохранить новую продажу в БД")
    public SaleDto saveSale(@RequestBody SaleDto saleDto) {
        return saleService.save(saleDto);
    }

    @PutMapping("/sale")
    @Tag(name = "Продажи")
    @Operation(summary = "Изменить информацию о продаже в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public SaleDto editSale(@RequestBody SaleDto saleDto) {
        return saleService.update(saleDto);
    }

}
