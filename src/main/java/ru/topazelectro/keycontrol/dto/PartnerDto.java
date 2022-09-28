package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerDto implements Serializable {

    private String name;
    private String city;
    private String comment;
}
