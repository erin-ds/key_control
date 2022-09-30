package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class KeyGroupDto implements Serializable {

    private Long id;
    private Long number;
    private Long partnerId;
    private String comment;
}
