package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.topazelectro.keycontrol.entity.Sale;

/**
 * A DTO for the {@link Sale} entity
 */
@Data
@Builder
public class SaleDto extends CommonDto {

    @Schema(description = "Даты")
    private final Long date;
    @Schema(description = "ID существующего контрагента (покупателя)")
    private final Long partnerId;
    @Schema(description = "ID существующего контрагента (фактического пользователя ПО)")
    private final Long partnerIdEndUser;
    @Schema(description = "ID типа программного обеспечения")
    private final Long softwareId;
    @Schema(description = "ID ключа")
    private final Long keyId;
    @Schema(description = "Номер флешки с ПО")
    private final int flashNumber;
    @Schema(description = "Лицензия расчётного центра")
    private final int licenseCashless;
    @Schema(description = "Лицензия дисконтного центра")
    private final int licenseDiscount;
    @Schema(description = "Лицензия отчётного центра")
    private final int licenseReport;
    @Schema(description = "Лицензия личного кабинета РЦ")
    private final int licenseCabinet;
    @Schema(description = "Лицензия автоналива")
    private final int licensePaktan;
    @Schema(description = "ID группы")
    private final Long keyGroupId;
    @Schema(description = "Вернули\\Не вернули")
    private final boolean returned;
    @Schema(description = "Номер заказа")
    private final int orderNumber;
    @Schema(description = "Номер счета")
    private final int billNumber;
}