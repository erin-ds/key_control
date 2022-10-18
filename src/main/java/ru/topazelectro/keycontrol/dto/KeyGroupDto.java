package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KeyGroupDto extends CommonDto {

    @Schema(description = "Номер группы")
    private Long number;
    @Schema(description = "ID контрагента")
    private Long partnerId;
}
