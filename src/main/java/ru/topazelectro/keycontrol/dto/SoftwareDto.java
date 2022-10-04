package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ru.topazelectro.keycontrol.entity.SoftwareEntity} entity
 */
@Data
public class SoftwareDto extends CommonDto {

    private final String name;
}