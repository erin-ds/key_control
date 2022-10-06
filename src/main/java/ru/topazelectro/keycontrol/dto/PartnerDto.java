package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartnerDto extends CommonDto {


    private String name;
    private String city;
}
