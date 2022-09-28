package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class KeyGroupDto implements Serializable {

    private Long number;
    private PartnerDto partnerId;
    private String comment;
}
