package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.*;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.exceptions.SoftwareAlreadyExistException;
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
    public ResponseEntity<?> getSoftwareById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(softwareService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation(summary = "Сохранить новый тип ПО в БД")
    public ResponseEntity<?> saveSoftware(@RequestBody SoftwareDto softwareDto) throws IdNotNullException, SoftwareAlreadyExistException {
        try {
            return new ResponseEntity<>(softwareService.save(softwareDto), HttpStatus.OK);
        } catch (SoftwareAlreadyExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation(summary = "Изменить тип ПО", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ResponseEntity<?> editSoftware(@RequestBody SoftwareDto softwareDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(softwareService.update(softwareDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
