package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;


@Data
public abstract class CommonDto implements Serializable {

    @Schema(description = "Идентификатор записи", accessMode = Schema.AccessMode.READ_ONLY)
    Long id;
    @Schema(description = "Комментарий к записи")
    String comment;

}
