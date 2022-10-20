package ru.topazelectro.keycontrol.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "key_groups")
public class KeyGroup extends CommonEntity{


    @Column(name = "number")
    private Long number;

    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "id", insertable = true, updatable = false)
    private Partner partnerEntity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        KeyGroup that = (KeyGroup) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
