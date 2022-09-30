package ru.topazelectro.keycontrol.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ReturnDto implements Serializable {

    private Long id;
    private SaleDto saleId;
    private LocalDateTime datePlan;
    private LocalDateTime dateFact;
    private String comment;
}
