package ru.topazelectro.keycontrol.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "key_types")
public class KeyTypeEntity extends CommonEntity{


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "id", orphanRemoval = true)
    private List<KeyEntity> keyEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        KeyTypeEntity that = (KeyTypeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
