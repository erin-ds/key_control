package ru.topazelectro.keycontrol.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.topazelectro.keycontrol.dto.*;
import ru.topazelectro.keycontrol.service.*;

import javax.inject.Inject;
import java.util.List;

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

    @GetMapping("/key")
    public Page<KeyDto> getAllKeys(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                   @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/key")
    public KeyDto getKeyById(@RequestParam Long id) {
        return keyService.getById(id);
    }

    @PostMapping("/key")
    public KeyDto saveKey(@RequestBody KeyDto keyDto) {
        return keyService.save(keyDto);
    }

    @PutMapping("/key")
    public KeyDto editKey(@RequestParam KeyDto keyDto) {
        return keyService.update(keyDto);
    }

    @GetMapping("/key-group")
    public Page<KeyGroupDto> getAllKeyGroups(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                             @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyGroupService.getAllEntities(pageNumber, listSize);
    }

    @GetMapping("/key-group")
    public KeyGroupDto getKeyGroupById(@RequestParam Long id) {
        return keyGroupService.getById(id);
    }

    @PostMapping("/key-group")
    public KeyGroupDto saveKeyGroup(@RequestBody KeyGroupDto keyGroupDto) {
        return keyGroupService.save(keyGroupDto);
    }

    @PutMapping("/key-group")
    public KeyGroupDto editKeyGroup(@RequestParam KeyGroupDto keyGroupDtoDto) {
        return keyGroupService.update(keyGroupDtoDto);
    }

    @GetMapping("/key-type")
    public Page<KeyTypeDto> getAllKeyTypes(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                       @RequestParam(defaultValue = "10", required = false) int listSize) {
        return keyTypeService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/key-type")
    public KeyTypeDto getKeyType(@RequestParam Long id) {
        return keyTypeService.getById(id);
    }

    @PostMapping("/key-type")
    public KeyTypeDto saveKeyType(@RequestBody KeyTypeDto keyTypeDto) {
        return keyTypeService.save(keyTypeDto);
    }

    @PutMapping("/key-type")
    public KeyTypeDto editKeyType(@RequestParam KeyTypeDto keyTypeDto) {
        return keyTypeService.update(keyTypeDto);
    }

    @GetMapping("/partner")
    public Page<PartnerDto> getAllPartners(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                      @RequestParam(defaultValue = "10", required = false) int listSize) {
        return partnerService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/partner")
    public PartnerDto getPartnerById(@RequestParam Long id) {
        return partnerService.getById(id);
    }

    @PostMapping("/partner")
    public PartnerDto savePartner(@RequestBody PartnerDto partnerDto) {
        return partnerService.save(partnerDto);
    }

    @PutMapping("/partner")
    public PartnerDto editPartner(@RequestParam PartnerDto partnerDto) {
        return partnerService.update(partnerDto);
    }

    @GetMapping("/returns")
    public Page<ReturnDto> getAllReturns(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                     @RequestParam(defaultValue = "10", required = false) int listSize) {
        return returnService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/returns")
    public ReturnDto getReturnById(@RequestParam Long id) {
        return returnService.getById(id);
    }

    @PostMapping("/returns")
    public ReturnDto saveReturn(@RequestBody ReturnDto returnDto) {
        return returnService.save(returnDto);
    }

    @PutMapping("/returns")
    public ReturnDto editReturn(@RequestParam ReturnDto returnDto) {
        return returnService.update(returnDto);
    }

    @GetMapping("/sale")
    public Page<SaleDto> getAllSales(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                  @RequestParam(defaultValue = "10", required = false) int listSize) {
        return saleService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/sale")
    public SaleDto getSaleById(@RequestParam Long id) {
        return saleService.getById(id);
    }

    @PostMapping("/sale")
    public SaleDto saveSale(@RequestBody SaleDto saleDto) {
        return saleService.save(saleDto);
    }

    @PutMapping("/sale")
    public SaleDto editSale(@RequestParam SaleDto saleDto) {
        return saleService.update(saleDto);
    }

    @GetMapping("/software")
    public Page<SoftwareDto> getAllSoftware(@RequestParam(defaultValue = "1", required = false) int pageNumber,
                                  @RequestParam(defaultValue = "10", required = false) int listSize) {
        return softwareService.getAllEntities(pageNumber, listSize);

    }

    @GetMapping("/software")
    public SoftwareDto getSoftwareById(@RequestParam Long id) {
        return softwareService.getById(id);
    }

    @PostMapping("/software")
    public SoftwareDto saveSoftware(@RequestBody SoftwareDto softwareDto) {
        return softwareService.save(softwareDto);
    }

    @PutMapping("/software")
    public SoftwareDto editSoftware(@RequestParam SoftwareDto softwareDto) {
        return softwareService.update(softwareDto);
    }

}
