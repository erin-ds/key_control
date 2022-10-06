package ru.topazelectro.keycontrol.dto;

import lombok.*;

import java.io.Serializable;


@Data
public abstract class CommonDto implements Serializable {

    Long id;
    String comment;

}
