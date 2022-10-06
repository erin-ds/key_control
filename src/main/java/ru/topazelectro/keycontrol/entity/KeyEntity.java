package ru.topazelectro.keycontrol.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "keys")
public class KeyEntity extends CommonEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Long typeId;

    @Column(name = "number_hex")
    private String numberHex;
    @Column(name = "number_dec")
    private Long numberDec;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        KeyEntity keyEntity = (KeyEntity) o;
        return id != null && Objects.equals(id, keyEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}