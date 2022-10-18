package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.topazelectro.keycontrol.entity.Software;

/**
 * A DTO for the {@link Software} entity
 */
@Data
@Builder
public class SoftwareDto extends CommonDto {

    @Schema(description = "Наименование ПО")
    private final String name;
}