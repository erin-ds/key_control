package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.topazelectro.keycontrol.entity.Sale;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link Sale} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDto extends CommonDto {

    @Schema(description = "Даты")
    private LocalDateTime date;
    @Schema(description = "ID существующего контрагента (покупателя)")
    private Long partnerId;
    @Schema(description = "ID существующего контрагента (фактического пользователя ПО)")
    private Long partnerIdEndUser;
    @Schema(description = "ID типа программного обеспечения")
    private Long softwareId;
    @Schema(description = "ID ключа")
    private Long keyId;
    @Schema(description = "Номер флешки с ПО")
    private int flashNumber;
    @Schema(description = "Лицензия расчётного центра")
    private int licenseCashless;
    @Schema(description = "Лицензия дисконтного центра")
    private int licenseDiscount;
    @Schema(description = "Лицензия отчётного центра")
    private int licenseReport;
    @Schema(description = "Лицензия личного кабинета РЦ")
    private int licenseCabinet;
    @Schema(description = "Лицензия автоналива")
    private int licensePaktan;
    @Schema(description = "ID группы")
    private Long keyGroupId;
    @Schema(description = "Вернули\\Не вернули")
    private boolean returned;
    @Schema(description = "Номер заказа")
    private int orderNumber;
    @Schema(description = "Номер счета")
    private int billNumber;
}