package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KeyDto extends CommonDto {

    @Schema(description = "ID типа ключа")
    private Long typeId;
    @Schema(description = "Номер ключа в HEX")
    private String numberHex;
    @Schema(description = "Номер ключа в десятичном виде")
    private Long numberDec;
}
