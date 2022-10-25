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
    private Integer flashNumber;
    @Schema(description = "Лицензия расчётного центра")
    private Integer licenseCashless;
    @Schema(description = "Лицензия дисконтного центра")
    private Integer licenseDiscount;
    @Schema(description = "Лицензия отчётного центра")
    private Integer licenseReport;
    @Schema(description = "Лицензия личного кабинета РЦ")
    private Integer licenseCabinet;
    @Schema(description = "Лицензия автоналива")
    private Integer licensePaktan;
    @Schema(description = "ID группы")
    private Long keyGroupId;
    @Schema(description = "Вернули\\Не вернули")
    private Boolean returned;
    @Schema(description = "Номер заказа")
    private Integer orderNumber;
    @Schema(description = "Номер счета")
    private Integer billNumber;
}