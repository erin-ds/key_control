package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class KeyDto implements Serializable {

    private KeyTypeDto typeId;
    private String numberHex;
    private Long numberDec;
    private String comment;
}
