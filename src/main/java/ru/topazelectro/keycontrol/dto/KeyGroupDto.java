package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeyGroupDto extends CommonDto {

    @Schema(description = "Номер группы")
    private Long number;
    @Schema(description = "ID контрагента")
    private Long partnerId;
}
