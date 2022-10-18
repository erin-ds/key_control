package ru.topazelectro.keycontrol.entity;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "returns")
public class ReturnEntity extends CommonEntity{


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sale_id", referencedColumnName = "id", updatable = false, insertable = true)
    private SaleEntity saleEntity;

    @Column(name = "date_plan")
    private LocalDateTime datePlan;

    @Column(name = "date_fact")
    private LocalDateTime dateFact;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReturnEntity that = (ReturnEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
