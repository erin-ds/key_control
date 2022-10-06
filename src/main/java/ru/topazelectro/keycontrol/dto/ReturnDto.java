package ru.topazelectro.keycontrol.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class ReturnDto extends CommonDto {

    private Long saleId;
    private LocalDateTime datePlan;
    private LocalDateTime dateFact;

}
