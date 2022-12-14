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
import ru.topazelectro.keycontrol.dto.KeyGroupDto;
import ru.topazelectro.keycontrol.exceptions.*;
import ru.topazelectro.keycontrol.service.KeyGroupService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class KeyGroupController {

    @Inject
    KeyGroupService keyGroupService;


    @GetMapping("/key-group/pages/")
    @Tag(name = "Группы", description = "Работа с номерами групп")
    @Operation(summary = "Получить список всех групп с пагинацией")
    public Page<KeyGroupDto> getAllKeyGroups(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                             @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyGroupService.getAllEntities(pageNumber, listSize);
    }

    @GetMapping("/key-group/all/")
    @Tag(name = "Группы")
    @Operation(summary = "Получить список всех групп")
    public List<KeyGroupDto> getAll() {
        return keyGroupService.getAll();

    }

    @GetMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Получить группу по ID", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = KeyGroupDto.class))
            })
    })
    public ResponseEntity<?> getKeyGroupById(@RequestParam Long id) throws IdNotFoundException {
        try {
            return new ResponseEntity<>(keyGroupService.getById(id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Сохранить новую группу в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = KeyGroupDto.class))
            })
    })
    public ResponseEntity<?> saveKeyGroup(@RequestBody KeyGroupDto keyGroupDto) throws IdNotNullException, NumberAlreadyExistException, PartnerNotExistException {
        try {
            return new ResponseEntity<>(keyGroupService.save(keyGroupDto), HttpStatus.OK);
        } catch (PartnerNotExistException | NumberAlreadyExistException | IdNotNullException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/key-group")
    @Tag(name = "Группы")
    @Operation(summary = "Изменить информацию о группе в БД", responses = {
            @ApiResponse(content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = KeyGroupDto.class))
            })
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(example = "{ \"id\": 0, \"comment\": \"string\", \"number\": 0, \"partnerId\": 0 }")))
    public ResponseEntity<?> editKeyGroup(@RequestBody KeyGroupDto keyGroupDto) throws EmptyOrNonExistingIdException {
        try {
            return new ResponseEntity<>(keyGroupService.update(keyGroupDto), HttpStatus.OK);
        } catch (EmptyOrNonExistingIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
