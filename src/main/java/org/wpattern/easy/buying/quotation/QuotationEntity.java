package org.wpattern.easy.buying.quotation;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_quotation")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class QuotationEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Product_Request_id", length = 10, nullable = false)
    private Integer product_request_id;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Supplier_id", length = 10, nullable = false)
    private Integer supplier_id;

    @NotNull
    @Size(min = 4, max = 12)
    @Column(name = "Unitary_Price", length = 12, nullable = false)
    private Float unitary_price;

    @NotNull
    @Size(min = 6, max = 12)
    @Column(name = "Total_Price", length = 12, nullable = false)
    private Float total_price;

    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Quantity", length = 12, nullable = false)
    private Integer quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_product_request", joinColumns = @JoinColumn(name = "product_request_id"), inverseJoinColumns = @JoinColumn(name = "product_request_id") )
    private List<Permission> permissions;


    public QuotationEntity() {
    }

    public QuotationEntity(Integer product_request_id, Integer supplier_id, Float unitary_price, Float total_price, Integer quantity) {
        super();
        this.product_request_id = product_request_id;
        this.supplier_id = supplier_id;
        this.unitary_price = unitary_price;
        this.total_price = total_price;
        this.quantity = quantity;
    }

    public QuotationEntity(Integer product_request_id) {
        this.product_request_id = product_request_id;
    }

    public Integer getProduct_request_id() {
        return this.product_request_id;
    }

    public void setProduct_request_id(Integer product_request_id) {
        this.product_request_id = product_request_id;
    }

    public Integer getSupplier_id() {
        return this.supplier_id;
    }

    public void setSupplier_id (Integer supplier_id) { this.supplier_id = supplier_id; }

    public Float getUnitary_price_price() { return this.unitary_price; }

    public void setUnitary_price(Float unitary_price) { this.unitary_price = unitary_price; }

    public Float getTotal_price() { return this.total_price; }

    public void setTotal_price(Float total_price) { this.total_price = total_price; }

    public Integer getQuantity() { return this.quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

}

