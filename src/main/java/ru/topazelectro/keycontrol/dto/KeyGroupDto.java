package ru.topazelectro.keycontrol.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class KeyGroupDto extends CommonDto {

    private Long number;
    private Long partnerId;
}
