package org.wpattern.easy.buying.payment_feature;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_payment_feature")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Payment_FeatureEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 12)
    @Column(name = "value", length = 12, nullable = false)
    private Float value;

    @NotNull
    @Size(min = 4, max = 12)
    @Column(name = "month_number", length = 12, nullable = false)
    private Integer month_number;

    @NotNull
    @Size(min = 8, max = 12)
    @Column(name = "banner_number", length = 12, nullable = false)
    private Integer banner_number;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_supplier", joinColumns = @JoinColumn(name = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id") )
    private List<Permission> permissions;


    public Payment_FeatureEntity() {
    }

    public Payment_FeatureEntity(Float value, Integer month_number, Integer banner_number) {
        super();
        this.value = value;
        this.month_number = month_number;
        this.banner_number = banner_number;
    }

    public Payment_FeatureEntity(Float value) { this.value = value; }

    public Float getvalue() {
        return this.value;
    }

    public void setvalue(Float value) {
        this.value = value;
    }

    public Integer getMonth_number() {
        return this.month_number;
    }

    public void setMonth_number (Integer month_number) { this.month_number = month_number; }

    public Integer getbanner_number() { return this.banner_number; }

    public void setBanner_number(Integer banner_number) { this.banner_number = banner_number; }


}


