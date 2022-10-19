package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerDto extends CommonDto {

    @Schema(description = "Наименование контрагента")
    private String name;
    @Schema(description = "Город контрагента")
    private String city;
}
