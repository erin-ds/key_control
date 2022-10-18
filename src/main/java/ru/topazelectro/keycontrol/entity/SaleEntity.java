package ru.topazelectro.keycontrol.entity;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "sales")
public class SaleEntity extends CommonEntity{

    @Column(name = "date")
    private Long date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id", referencedColumnName = "id", insertable = true, updatable = false)
    private PartnerEntity partnerEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id_end_user", referencedColumnName = "id", insertable = true, updatable = false)
    private PartnerEntity partnerEntityEndUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "software_id", referencedColumnName = "id", insertable = true, updatable = false)
    private SoftwareEntity softwareEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id", referencedColumnName = "id", insertable = true, updatable = false)
    private KeyEntity keyEntity;

    @Column(name = "flash_number")
    private int flashNumber;

    @Column(name = "license_cashless")
    private int licenseCashless;

    @Column(name = "license_discount")
    private int licenseDiscount;

    @Column(name = "license_report")
    private int licenseReport;

    @Column(name = "license_cabinet")
    private int licenseCabinet;

    @Column(name = "license_paktan")
    private int licensePaktan;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "key_group_id", referencedColumnName = "id", insertable = true, updatable = false)
    private KeyGroupEntity keyGroupEntity;

    @Column(name = "is_return")
    private boolean isReturn;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "bill_number")
    private int billNumber;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SaleEntity that = (SaleEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
