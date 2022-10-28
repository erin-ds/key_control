package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.SaleDto;
import ru.topazelectro.keycontrol.exceptions.*;
import ru.topazelectro.keycontrol.service.SaleService;

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
    public ResponseEntity<?> getSaleById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(saleService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sale")
    @Tag(name = "Продажи")
    @Operation(summary = "Сохранить новую продажу в БД")
    public ResponseEntity<?> saveSale(@RequestBody SaleDto saleDto) throws IdNotNullException, PartnerNotExistException, SoftwareNotExistException, KeyNotExistException, KeyGroupNotExistException {
        try {
            return new ResponseEntity<>(saleService.save(saleDto), HttpStatus.OK);
        } catch (PartnerNotExistException | EndUserNotExistException | SoftwareNotExistException |
                 KeyNotExistException | KeyGroupNotExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/sale")
    @Tag(name = "Продажи")
    @Operation(summary = "Изменить информацию о продаже в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ResponseEntity<?> editSale(@RequestBody SaleDto saleDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(saleService.update(saleDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
