package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoteUpdateDto extends CommonDto {

    @Schema(description = "ID ключа")
    private Long keyId;
    @Schema(description = "Дата фактической прошивки ключа")
    private LocalDateTime updateDate;
    @Schema(description = "Номер счёта")
    private Integer billNumber;
    @Schema(description = "Номер заказа")
    private Integer orderNumber;

}
