package ru.topazelectro.keycontrol.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "RemoteUpdate")
public class RemoteUpdate extends CommonEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id", referencedColumnName = "id")
    private Key key;

    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @Column(name = "bill_number")
    private Integer billNumber;
    @Column(name = "order_number")
    private Integer orderNumber;
}
