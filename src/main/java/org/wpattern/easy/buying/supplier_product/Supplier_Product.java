package org.wpattern.easy.buying.supplier_product;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_supplier_product")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Supplier_Product extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 12)
    @Column(name = "supplier_id", length = 12, nullable = false)
    private Integer supplier_id;

    @NotNull
    @Size(min = 4, max = 12)
    @Column(name = "product_id", length = 12, nullable = false)
    private Integer product_id;

    public Supplier_Product() {
    }

    public Supplier_Product(Integer supplier_id, Integer product_id) {
        super();
        this.supplier_id = supplier_id;
        this.product_id = product_id;
    }

    public Supplier_Product(Integer supplier_id) {this.supplier_id = supplier_id; }

    public Integer getSupplier_id() {
        return this.supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Integer getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id (Integer product_id) { this.product_id = product_id; }


}
