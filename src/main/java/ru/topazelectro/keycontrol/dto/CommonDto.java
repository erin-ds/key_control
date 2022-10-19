package ru.topazelectro.keycontrol.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class CommonDto implements Serializable {

    @Schema(description = "Идентификатор записи", accessMode = Schema.AccessMode.READ_ONLY)
    Long id;
    @Schema(description = "Комментарий к записи")
    String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonDto commonDto = (CommonDto) o;
        return id.equals(commonDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
