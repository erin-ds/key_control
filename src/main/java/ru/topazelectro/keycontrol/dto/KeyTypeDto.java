package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class KeyTypeDto extends CommonDto {

    private String name;
}
