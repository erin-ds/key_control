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
import ru.topazelectro.keycontrol.dto.ReturnDto;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.exceptions.SaleNotExistException;
import ru.topazelectro.keycontrol.service.ReturnService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ReturnController {
    @Inject
    ReturnService returnService;

    @GetMapping("/returns/all/pages/")
    @Tag(name = "Возвраты", description = "Даты планируемого и фактического возврата")
    @Operation(summary = "Получить весь список возвратов с пагинацией")
    public Page<ReturnDto> getAllReturns(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                         @RequestParam(defaultValue = "10", required = false) int listSize) {
        return returnService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/returns/all/")
    @Tag(name = "Возвраты")
    @Operation(summary = "Получить весь список возвратов")
    public List<ReturnDto> getAll() {
        return returnService.getAll();

    }

    @GetMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Получить информацию о возврате по ID", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ReturnDto.class))
            })
    })
    public ResponseEntity<?> getReturnById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(returnService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Сохранить новую информацию о возврате в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ReturnDto.class))
            })
    })
    public ResponseEntity<?> saveReturn(@RequestBody ReturnDto returnDto) throws IdNotNullException, SaleNotExistException {
        try {
            return new ResponseEntity<>(returnService.save(returnDto), HttpStatus.OK);
        } catch (SaleNotExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Изменить информацию о возврате в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ReturnDto.class))
            })
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(example = "{ \"id\": 0, \"comment\": \"string\", \"name\": \"string\", \"city\": \"string\" }")))
    public ResponseEntity<?> editReturn(@RequestBody ReturnDto returnDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(returnService.update(returnDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
