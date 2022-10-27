package ru.topazelectro.keycontrol.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.ReturnDto;
import ru.topazelectro.keycontrol.exceptions.EmptyOrNonExistingIdException;
import ru.topazelectro.keycontrol.exceptions.IdNotFoundException;
import ru.topazelectro.keycontrol.exceptions.IdNotNullException;
import ru.topazelectro.keycontrol.exceptions.PartnerAlreadyExistException;
import ru.topazelectro.keycontrol.service.ReturnService;

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
    public ResponseEntity<?> getReturnById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(returnService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Сохранить новую информацию о возврате в БД")
    public ResponseEntity<?> saveReturn(@RequestBody ReturnDto returnDto) throws IdNotNullException {
        try {
            return new ResponseEntity<>(returnService.save(returnDto), HttpStatus.OK);
        } catch (PartnerAlreadyExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation(summary = "Изменить информацию о возврате в БД", description = "Сюда нужно так же передавать ID изменяемой записи")
    public ResponseEntity<?> editReturn(@RequestBody ReturnDto returnDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(returnService.update(returnDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
