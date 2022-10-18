package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class ReturnDto extends CommonDto {

    @Schema(description = "ID продажи")
    private Long saleId;
    @Schema(description = "Ожидаемая дата возврата")
    private LocalDateTime datePlan;
    @Schema(description = "Фактическая дата возврата")
    private LocalDateTime dateFact;

}
