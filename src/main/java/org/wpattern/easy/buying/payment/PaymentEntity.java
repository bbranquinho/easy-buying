package org.wpattern.easy.buying.payment;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_payment")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class PaymentEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 10)
    @Column(name = "Date", length = 10, nullable = false)
    private Date date;

    @NotNull
    @Size(min = 4, max = 10)
    @Column(name = "expiration", length = 10, nullable = false)
    private Date expiration;

    @NotNull
    @Size(min = 8, max = 12)
    @Column(name = "value", length = 12, nullable = false)
    private Float value;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_supplier", joinColumns = @JoinColumn(name = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id") )
    private List<Permission> permissions;


    public PaymentEntity() {
    }

    public PaymentEntity(Date date, Date expiration, Float value) {
        super();
        this.date = date;
        this.expiration = expiration;
        this.value = value;
    }


    public PaymentEntity(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setdate(Date date) {
        this.date = date;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public void setExpiration (Date expiration) { this.expiration = expiration; }

    public Float getValue() { return this.value; }

    public void setValue(Float value) { this.value = value; }


}

