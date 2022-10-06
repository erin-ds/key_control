package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class KeyDto extends CommonDto {

    private Long typeId;
    private String numberHex;
    private Long numberDec;
}
