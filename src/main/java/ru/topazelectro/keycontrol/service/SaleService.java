package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.SaleDto;
import ru.topazelectro.keycontrol.entity.SaleEntity;
import ru.topazelectro.keycontrol.repository.SaleRepository;
@Service
public class SaleService extends CommonService<SaleEntity, SaleDto, SaleRepository> {

    @Override
    public SaleDto toDTO(SaleEntity saleEntity) {
        SaleDto dto = SaleDto.builder()
                .date(saleEntity.getDate())
                .partnerId(saleEntity.getPartnerId())
                .partnerIdEndUser(saleEntity.getPartnerIdEndUser())
                .softwareId(saleEntity.getSoftwareId())
                .keyId(saleEntity.getKeyId())
                .flashNumber(saleEntity.getFlashNumber())
                .licenseCashless(saleEntity.getLicenseCashless())
                .licenseDiscount(saleEntity.getLicenseDiscount())
                .licenseReport(saleEntity.getLicenseReport())
                .licenseCabinet(saleEntity.getLicenseCabinet())
                .licensePaktan(saleEntity.getLicensePaktan())
                .keyGroupId(saleEntity.getKeyGroupId())
                .isReturn(saleEntity.isReturn())
                .orderNumber(saleEntity.getOrderNumber())
                .billNumber(saleEntity.getBillNumber())
                .build();
        dto.setId(saleEntity.getId());
        dto.setComment(saleEntity.getComment());
        return dto;
    }

    @Override
    public SaleEntity fromDTO(SaleDto saleDto) {
        SaleEntity entity = findById(saleDto.getId()).orElse(new SaleEntity());
        entity.setDate(saleDto.getDate());
        entity.setPartnerId(saleDto.getPartnerId());
        entity.setPartnerIdEndUser(saleDto.getPartnerIdEndUser());
        entity.setSoftwareId(saleDto.getSoftwareId());
        entity.setKeyId(saleDto.getKeyId());
        entity.setFlashNumber(saleDto.getFlashNumber());
        entity.setLicenseCashless(saleDto.getLicenseCashless());
        entity.setLicenseDiscount(saleDto.getLicenseDiscount());
        entity.setLicenseReport(saleDto.getLicenseReport());
        entity.setLicenseCabinet(saleDto.getLicenseCabinet());
        entity.setLicensePaktan(saleDto.getLicensePaktan());
        entity.setKeyGroupId(saleDto.getKeyGroupId());
        entity.setReturn(saleDto.isReturn());
        entity.setOrderNumber(saleDto.getOrderNumber());
        entity.setBillNumber(saleDto.getBillNumber());
        entity.setId(saleDto.getId());
        entity.setComment(saleDto.getComment());
        return entity;
    }
}
