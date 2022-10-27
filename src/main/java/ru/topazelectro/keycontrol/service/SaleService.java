package ru.topazelectro.keycontrol.service;

import org.springframework.stereotype.Service;
import ru.topazelectro.keycontrol.dto.SaleDto;
import ru.topazelectro.keycontrol.entity.Sale;
import ru.topazelectro.keycontrol.repository.SaleRepository;

import javax.inject.Inject;

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
    public SaleDto toDTO(Sale sale) {
        SaleDto dto = SaleDto.builder()
                .date(sale.getDate())
                .partnerId(sale.getPartner().getId())
                .partnerIdEndUser(sale.getPartnerEndUser().getId())
                .softwareId(sale.getSoftware().getId())
                .keyId(sale.getKey().getId())
                .flashNumber(sale.getFlashNumber())
                .licenseCashless(sale.getLicenseCashless())
                .licenseDiscount(sale.getLicenseDiscount())
                .licenseReport(sale.getLicenseReport())
                .licenseCabinet(sale.getLicenseCabinet())
                .licensePaktan(sale.getLicensePaktan())
                .keyGroupId(sale.getKeyGroup().getId())
                .returned(sale.isReturn())
                .orderNumber(sale.getOrderNumber())
                .billNumber(sale.getBillNumber())
                .build();
        dto.setId(sale.getId());
        dto.setComment(sale.getComment());
        return dto;
    }

    @Override
    public Sale fromDTO(SaleDto saleDto) {
        Sale entity = findByIdForMapping(saleDto.getId()).orElse(new Sale());
        entity.setDate(saleDto.getDate());
        entity.setPartner(partnerService.findByIdForMapping(saleDto.getPartnerId()).get());
        entity.setPartnerEndUser(partnerService.findByIdForMapping(saleDto.getPartnerIdEndUser()).get());
        entity.setSoftware(softwareService.findByIdForMapping(saleDto.getSoftwareId()).get());
        entity.setKey(keyService.findByIdForMapping(saleDto.getKeyId()).get());
        entity.setFlashNumber(saleDto.getFlashNumber());
        entity.setLicenseCashless(saleDto.getLicenseCashless());
        entity.setLicenseDiscount(saleDto.getLicenseDiscount());
        entity.setLicenseReport(saleDto.getLicenseReport());
        entity.setLicenseCabinet(saleDto.getLicenseCabinet());
        entity.setLicensePaktan(saleDto.getLicensePaktan());
        entity.setKeyGroup(keyGroupService.findByIdForMapping(saleDto.getKeyGroupId()).get());
        entity.setReturn(saleDto.getReturned());
        entity.setOrderNumber(saleDto.getOrderNumber());
        entity.setBillNumber(saleDto.getBillNumber());
        entity.setId(saleDto.getId());
        entity.setComment(saleDto.getComment());
        return entity;
    }
}
