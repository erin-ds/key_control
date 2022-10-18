package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;
import ru.topazelectro.keycontrol.entity.Sale;

/**
 * A DTO for the {@link Sale} entity
 */
@Data
@Builder
public class SaleDto extends CommonDto {

    private final Long date;
    private final Long partnerId;
    private final Long partnerIdEndUser;
    private final Long softwareId;
    private final Long keyId;
    private final int flashNumber;
    private final int licenseCashless;
    private final int licenseDiscount;
    private final int licenseReport;
    private final int licenseCabinet;
    private final int licensePaktan;
    private final Long keyGroupId;
    private final boolean isReturn;
    private final int orderNumber;
    private final int billNumber;
}