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
import ru.topazelectro.keycontrol.dto.PartnerDto;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.exceptions.PartnerAlreadyExistException;
import ru.topazelectro.keycontrol.service.PartnerService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PartnerController {
    @Inject
    PartnerService partnerService;

    @GetMapping("/partner/all/pages/")
    @Tag(name = "Контрагенты", description = "Работа с контрагентами")
    @Operation(summary = "Получить список всех контрагентов с пагинацией")
    public Page<PartnerDto> getAllPartners(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                           @RequestParam(defaultValue = "10", required = false) int listSize) {
        return partnerService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/partner/all/")
    @Tag(name = "Контрагенты")
    @Operation(summary = "Получить список всех контрагентов")
    public List<PartnerDto> getAll() {
        return partnerService.getAll();

    }

    @GetMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation(summary = "Получить контрагента по ID", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PartnerDto.class))
            })
    })
    public ResponseEntity<?> getPartnerById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(partnerService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation(summary = "Сохранить нового контрагента в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PartnerDto.class))
            })
    })
    public ResponseEntity<?> savePartner(@RequestBody PartnerDto partnerDto) throws IdNotNullException, PartnerAlreadyExistException {
        try {
            return new ResponseEntity<>(partnerService.save(partnerDto), HttpStatus.OK);
        } catch (PartnerAlreadyExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation(summary = "Изменить информацию о контрагенте в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PartnerDto.class))
            })
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(example = "{ \"id\": 0, \"comment\": \"string\", \"name\": \"string\", \"city\": \"string\" }")))
    public ResponseEntity<?> editPartner(@RequestBody PartnerDto partnerDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(partnerService.update(partnerDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
