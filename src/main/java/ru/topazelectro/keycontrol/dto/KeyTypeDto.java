package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class KeyTypeDto extends CommonDto {

    @Schema(description = "Тип ключа")
    private String name;
}
