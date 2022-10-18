package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KeyGroupDto extends CommonDto {

    private Long number;
    private Long partnerId;
}
