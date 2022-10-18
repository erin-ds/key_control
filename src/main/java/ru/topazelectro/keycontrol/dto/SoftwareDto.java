package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;
import ru.topazelectro.keycontrol.entity.Software;

/**
 * A DTO for the {@link Software} entity
 */
@Data
@Builder
public class SoftwareDto extends CommonDto {

    private final String name;
}