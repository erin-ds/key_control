package ru.topazelectro.keycontrol.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "comment")
    String comment;
}
