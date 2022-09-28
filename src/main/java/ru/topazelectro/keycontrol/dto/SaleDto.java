package ru.topazelectro.keycontrol.dto;

import lombok.Data;
import ru.topazelectro.keycontrol.entity.KeyEntity;
import ru.topazelectro.keycontrol.entity.KeyGroupEntity;
import ru.topazelectro.keycontrol.entity.PartnerEntity;
import ru.topazelectro.keycontrol.entity.SoftwareEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link ru.topazelectro.keycontrol.entity.SaleEntity} entity
 */
@Data
public class SaleDto implements Serializable {

    private final LocalDateTime date;
    private final PartnerDto partnerId;
    private final PartnerDto partnerIdEndUser;
    private final SoftwareDto softwareId;
    private final KeyDto keyId;
    private final int flashNumber;
    private final int licenseCashless;
    private final int licenseDiscount;
    private final int licenseReport;
    private final int licenseCabinet;
    private final int licensePaktan;
    private final KeyGroupDto keyGroupId;
    private final boolean isReturn;
    private final int orderNumber;
    private final int billNumber;
    private final String comment;
}