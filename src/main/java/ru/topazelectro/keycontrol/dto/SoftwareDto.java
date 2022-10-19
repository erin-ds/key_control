package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.topazelectro.keycontrol.entity.Software;

/**
 * A DTO for the {@link Software} entity
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoftwareDto extends CommonDto {

    @Schema(description = "Наименование ПО")
    private String name;


}