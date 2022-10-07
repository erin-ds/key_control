package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KeyDto extends CommonDto {

    private Long typeId;
    private String numberHex;
    private Long numberDec;
}
