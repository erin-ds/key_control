package ru.topazelectro.keycontrol.entity;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "returns")
public class Return extends CommonEntity{


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sale_id", referencedColumnName = "id", updatable = false)
    private Sale sale;

    @Column(name = "date_plan")
    private LocalDateTime datePlan;

    @Column(name = "date_fact")
    private LocalDateTime dateFact;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Return that = (Return) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
