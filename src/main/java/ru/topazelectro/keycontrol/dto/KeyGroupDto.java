package ru.topazelectro.keycontrol.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class KeyGroupDto extends CommonDto {

    private Long number;
    private Long partnerId;
}
