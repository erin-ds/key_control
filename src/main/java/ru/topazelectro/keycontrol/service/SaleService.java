package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.SaleDto;
import ru.topazelectro.keycontrol.entity.Sale;
import ru.topazelectro.keycontrol.repository.SaleRepository;

import javax.inject.Inject;
import java.time.LocalDate;

@Service
public class SaleService extends CommonService<Sale, SaleDto, SaleRepository> {

    @Inject
    PartnerService partnerService;
    @Inject
    SoftwareService softwareService;
    @Inject
    KeyService keyService;
    @Inject
    KeyGroupService keyGroupService;

    @Override
    public SaleDto toDTO(Sale saleEntity) {
        SaleDto dto = SaleDto.builder()
                .date(saleEntity.getDate())
                .partnerId(saleEntity.getPartnerEntity().getId())
                .partnerIdEndUser(saleEntity.getPartnerEntityEndUser().getId())
                .softwareId(saleEntity.getSoftwareEntity().getId())
                .keyId(saleEntity.getKeyEntity().getId())
                .flashNumber(saleEntity.getFlashNumber())
                .licenseCashless(saleEntity.getLicenseCashless())
                .licenseDiscount(saleEntity.getLicenseDiscount())
                .licenseReport(saleEntity.getLicenseReport())
                .licenseCabinet(saleEntity.getLicenseCabinet())
                .licensePaktan(saleEntity.getLicensePaktan())
                .keyGroupId(saleEntity.getKeyGroupEntity().getId())
                .returned(saleEntity.isReturn())
                .orderNumber(saleEntity.getOrderNumber())
                .billNumber(saleEntity.getBillNumber())
                .build();
        dto.setId(saleEntity.getId());
        dto.setComment(saleEntity.getComment());
        return dto;
    }

    @Override
    public Sale fromDTO(SaleDto saleDto) {
        Sale entity = findByIdForMapping(saleDto.getId()).orElse(new Sale());
        entity.setDate(saleDto.getDate());
        entity.setPartnerEntity(partnerService.findByIdForMapping(saleDto.getPartnerId()).get());
        entity.setPartnerEntityEndUser(partnerService.findByIdForMapping(saleDto.getPartnerIdEndUser()).get());
        entity.setSoftwareEntity(softwareService.findByIdForMapping(saleDto.getSoftwareId()).get());
        entity.setKeyEntity(keyService.findByIdForMapping(saleDto.getKeyId()).get());
        entity.setFlashNumber(saleDto.getFlashNumber());
        entity.setLicenseCashless(saleDto.getLicenseCashless());
        entity.setLicenseDiscount(saleDto.getLicenseDiscount());
        entity.setLicenseReport(saleDto.getLicenseReport());
        entity.setLicenseCabinet(saleDto.getLicenseCabinet());
        entity.setLicensePaktan(saleDto.getLicensePaktan());
        entity.setKeyGroupEntity(keyGroupService.findByIdForMapping(saleDto.getKeyGroupId()).get());
        entity.setReturn(saleDto.getReturned());
        entity.setOrderNumber(saleDto.getOrderNumber());
        entity.setBillNumber(saleDto.getBillNumber());
        entity.setId(saleDto.getId());
        entity.setComment(saleDto.getComment());
        return entity;
    }
}
