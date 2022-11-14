package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.SaleDto;
import ru.topazelectro.keycontrol.exceptions.*;
import ru.topazelectro.keycontrol.service.SaleService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class SaleController {
    @Inject
    SaleService saleService;

    @GetMapping("/sale/all/pages/")
    @Tag(name = "Продажи", description = "Полная информация по продажам")
    @Operation(summary = "Получить весь список продаж с пагинацией")
    public Page<SaleDto> getAllSales(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                     @RequestParam(defaultValue = "10", required = false) int listSize) {
        return saleService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/sale/all/")
    @Tag(name = "Продажи")
    @Operation(summary = "Получить весь список продаж")
    public List<SaleDto> getAll() {
        return saleService.getAll();

    }

    @GetMapping("/sale")
    @Tag(name = "Продажи")
    @Operation(summary = "Получить продажу по ID", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SaleDto.class))
            })
    })
    public ResponseEntity<?> getSaleById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(saleService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sale")
    @Tag(name = "Продажи")
    @Operation(summary = "Сохранить новую продажу в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SaleDto.class))
            })
    })
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
    @Operation(summary = "Изменить информацию о продаже в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SaleDto.class))
            })
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(example = "{ \"id\": 0, \"comment\": \"string\", \"date\": \"2022-11-02T10:29:04.574Z\", \"partnerId\": 0, \"partnerIdEndUser\": 0, \"softwareId\": 0, \"keyId\": 0, \"flashNumber\": 0, \"licenseCashless\": 0, \"licenseDiscount\": 0, \"licenseReport\": 0, \"licenseCabinet\": 0, \"licensePaktan\": 0, \"keyGroupId\": 0, \"returned\": true, \"orderNumber\": 0, \"billNumber\": 0 }")))
    public ResponseEntity<?> editSale(@RequestBody SaleDto saleDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(saleService.update(saleDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
