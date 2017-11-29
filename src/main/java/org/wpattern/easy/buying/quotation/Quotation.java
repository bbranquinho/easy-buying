package org.wpattern.easy.buying.quotation;

import org.wpattern.easy.buying.productrequest.ProductRequest;
import org.wpattern.easy.buying.supplier.Supplier;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_quotation")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Quotation extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "product_request_id", nullable = false)
    private ProductRequest productRequest;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(name="unitary_price")
    private Double unitary_price;

    @Column(name="total_price")
    private Double total_price;

    @Column(name="quantity")
    private Integer quantity;


    public ProductRequest getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(ProductRequest productRequest) {
        this.productRequest = productRequest;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Double getUnitary_price() {
        return unitary_price;
    }

    public void setUnitary_price(Double unitary_price) {
        this.unitary_price = unitary_price;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
