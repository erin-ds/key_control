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
public class KeyController {

    @Inject
    KeyGroupService keyGroupService;
    @Inject
    KeyService keyService;
    @Inject
    KeyTypeService keyTypeService;
    @Inject
    PartnerService partnerService;
    @Inject
    ReturnService returnService;
    @Inject
    SaleService saleService;
    @Inject
    SoftwareService softwareService;

    @GetMapping("/key/all")
    @Tag(name = "Ключи", description = "Работа с ключами")
    @Operation (summary = "Получить весь список ключей")
    public Page<KeyDto> getAllKeys(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                   @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/key")
    @Tag(name = "Ключи")
    @Operation (summary = "Получить ключ по ID")
    public KeyDto getKeyById(@RequestParam Long id) {
        return keyService.getById(id);
    }

    @PostMapping("/key")
    @Tag(name = "Ключи")
    @Operation (summary = "Сохранить новый ключ в БД")
    public KeyDto saveKey(@RequestBody KeyDto keyDto) {
        return keyService.save(keyDto);
    }

    @PutMapping("/key")
    @Tag(name = "Ключи")
    @Operation (summary = "Изменить информацию о ключе в БД")
    public KeyDto editKey(@RequestParam KeyDto keyDto) {
        return keyService.update(keyDto);
    }

    @GetMapping("/key-group/all")
    @Tag(name = "Группы", description = "Работа с номерами групп")
    @Operation (summary = "Получить список всех групп")
    public Page<KeyGroupDto> getAllKeyGroups(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                             @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyGroupService.getAllEntities(pageNumber, listSize);
    }

    @GetMapping("/key-group")
    @Tag(name = "Группы")
    @Operation (summary = "Получить группу по ID")
    public KeyGroupDto getKeyGroupById(@RequestParam Long id) {
        return keyGroupService.getById(id);
    }

    @PostMapping("/key-group")
    @Tag(name = "Группы")
    @Operation (summary = "Сохранить новую группу в БД")
    public KeyGroupDto saveKeyGroup(@RequestBody KeyGroupDto keyGroupDto) {
        return keyGroupService.save(keyGroupDto);
    }

    @PutMapping("/key-group")
    @Tag(name = "Группы")
    @Operation (summary = "Изменить информацию о группе в БД")
    public KeyGroupDto editKeyGroup(@RequestParam KeyGroupDto keyGroupDtoDto) {
        return keyGroupService.update(keyGroupDtoDto);
    }

    @GetMapping("/key-type/all")
    @Tag(name = "Типы ключей", description = "Тип подключения (USB\\LPT), тип ключа (сетевой\\локальный)")
    @Operation (summary = "Получить список всех типов ключей")
    public Page<KeyTypeDto> getAllKeyTypes(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                           @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyTypeService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation (summary = "Получить тип ключа по ID")
    public KeyTypeDto getKeyType(@RequestParam Long id) {
        return keyTypeService.getById(id);
    }

    @PostMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation (summary = "Сохранить новый тип ключа в БД")
    public KeyTypeDto saveKeyType(@RequestBody KeyTypeDto keyTypeDto) {
        return keyTypeService.save(keyTypeDto);
    }

    @PutMapping("/key-type")
    @Tag(name = "Типы ключей")
    @Operation (summary = "Изменить информацию о типе ключа в БД")
    public KeyTypeDto editKeyType(@RequestParam KeyTypeDto keyTypeDto) {
        return keyTypeService.update(keyTypeDto);
    }

    @GetMapping("/partner/all")
    @Tag(name = "Контрагенты", description = "Работа с контрагентами")
    @Operation (summary = "Получить список всех контрагентов")
    public Page<PartnerDto> getAllPartners(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                           @RequestParam(defaultValue = "10", required = false) int listSize) {
        return partnerService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation (summary = "Получить контрагента по ID")
    public PartnerDto getPartnerById(@RequestParam Long id) {
        return partnerService.getById(id);
    }

    @PostMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation (summary = "Сохранить нового контрагента в БД")
    public PartnerDto savePartner(@RequestBody PartnerDto partnerDto) {
        return partnerService.save(partnerDto);
    }

    @PutMapping("/partner")
    @Tag(name = "Контрагенты")
    @Operation (summary = "Изменить информацию о контрагенте в БД")
    public PartnerDto editPartner(@RequestParam PartnerDto partnerDto) {
        return partnerService.update(partnerDto);
    }

    @GetMapping("/returns/all")
    @Tag(name = "Возвраты", description = "Даты планируемого и фактического возврата")
    @Operation (summary = "Получить весь список возвратов")
    public Page<ReturnDto> getAllReturns(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                         @RequestParam(defaultValue = "10", required = false) int listSize) {
        return returnService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation (summary = "Получить информацию о возврате по ID")
    public ReturnDto getReturnById(@RequestParam Long id) {
        return returnService.getById(id);
    }

    @PostMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation (summary = "Сохранить новую информацию о возврате в БД")
    public ReturnDto saveReturn(@RequestBody ReturnDto returnDto) {
        return returnService.save(returnDto);
    }

    @PutMapping("/returns")
    @Tag(name = "Возвраты")
    @Operation (summary = "Изменить информацию о возврате в БД")
    public ReturnDto editReturn(@RequestParam ReturnDto returnDto) {
        return returnService.update(returnDto);
    }

    @GetMapping("/sale/all")
    @Tag(name = "Продажи", description = "Полная информация по продажам")
    @Operation (summary = "Получить весь список продаж")
    public Page<SaleDto> getAllSales(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                     @RequestParam(defaultValue = "10", required = false) int listSize) {
        return saleService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/sale")
    @Tag(name = "Продажи")
    @Operation (summary = "Получить продажу по ID")
    public SaleDto getSaleById(@RequestParam Long id) {
        return saleService.getById(id);
    }

    @PostMapping("/sale")
    @Tag(name = "Продажи")
    @Operation (summary = "Сохранить новую продажу в БД")
    public SaleDto saveSale(@RequestBody SaleDto saleDto) {
        return saleService.save(saleDto);
    }

    @PutMapping("/sale")
    @Tag(name = "Продажи")
    @Operation (summary = "Изменить информацию о продаже в БД")
    public SaleDto editSale(@RequestParam SaleDto saleDto) {
        return saleService.update(saleDto);
    }

    @GetMapping("/software/all")
    @Tag(name = "Типы программного обеспечения", description = "Топаз-АСЗ, Топаз-Офис и т.д.")
    @Operation (summary = "Получить весь список типов ПО")
    public Page<SoftwareDto> getAllSoftware(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                            @RequestParam(defaultValue = "10", required = false) int listSize) {
        return softwareService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation (summary = "Получить тип ПО по ID")
    public SoftwareDto getSoftwareById(@RequestParam Long id) {
        return softwareService.getById(id);
    }

    @PostMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation (summary = "Сохранить новый тип ПО в БД")
    public SoftwareDto saveSoftware(@RequestBody SoftwareDto softwareDto) {
        return softwareService.save(softwareDto);
    }

    @PutMapping("/software")
    @Tag(name = "Типы программного обеспечения")
    @Operation (summary = "Изменить тип ПО")
    public SoftwareDto editSoftware(@RequestParam SoftwareDto softwareDto) {
        return softwareService.update(softwareDto);
    }

}
