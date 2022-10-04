package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class KeyTypeDto extends CommonDto {

    private String name;
    private List<KeyDto> key;
}
