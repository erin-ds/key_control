package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class KeyTypeDto implements Serializable {

    private Long id;
    private String name;
    private String comment;
    private List<KeyDto> key;
}
