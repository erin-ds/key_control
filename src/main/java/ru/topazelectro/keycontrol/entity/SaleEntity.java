package ru.topazelectro.keycontrol.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id", referencedColumnName = "id", insertable = false,updatable = false)
    @ToString.Exclude
    private PartnerEntity partnerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id_end_user", referencedColumnName = "id", insertable = false,updatable = false)
    @ToString.Exclude
    private PartnerEntity partnerIdEndUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "software_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ToString.Exclude
    private SoftwareEntity softwareId;

    @OneToOne
    @JoinColumn(name = "key_id", referencedColumnName = "id", insertable = false,updatable = false)
    private KeyEntity keyId;

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

    @Column(name = "key_group_id")
    private Long keyGroupId;

    @Column(name = "is_return")
    private boolean isReturn;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "bill_number")
    private int billNumber;

    @Column(name = "sale_comment")
    private String comment;

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
