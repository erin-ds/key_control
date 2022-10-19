package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeyDto extends CommonDto {

    @Schema(description = "ID типа ключа")
    private Long typeId;
    @Schema(description = "Номер ключа в HEX")
    private String numberHex;
    @Schema(description = "Номер ключа в десятичном виде")
    private Long numberDec;
}
