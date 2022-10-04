package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ReturnDto extends CommonDto {

    private SaleDto saleId;
    private LocalDateTime datePlan;
    private LocalDateTime dateFact;

}
