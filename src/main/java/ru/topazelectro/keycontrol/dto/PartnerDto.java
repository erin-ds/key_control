package ru.topazelectro.keycontrol.dto;

import liquibase.pro.packaged.L;
import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerDto implements Serializable {

    private Long id;
    private String name;
    private String city;
    private String comment;
}
