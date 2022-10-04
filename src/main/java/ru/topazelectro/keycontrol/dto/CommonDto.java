package ru.topazelectro.keycontrol.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class CommonDto implements Serializable {

    Long id;
    String comment;

}
