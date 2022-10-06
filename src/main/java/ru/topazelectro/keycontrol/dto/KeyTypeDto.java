package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class KeyTypeDto extends CommonDto {

    private String name;
    private List<KeyDto> key;
}
