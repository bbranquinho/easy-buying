package org.wpattern.easy.buying.product_request;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_product_request")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Product_RequestEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Product_id", length = 10, nullable = false)
    private Integer product_id;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "User_id", length = 10, nullable = false)
    private Integer user_id;

    @NotNull
    @Size(min = 4, max = 127)
    @Column(name = "Detail", length = 127, nullable = false)
    private String detail;

    @NotNull
    @Size(min = 6, max = 10)
    @Column(name = "Delivery", length = 10, nullable = false)
    private Date delivery;

    @NotNull
    @Size(min = 6, max = 10)
    @Column(name = "request", length = 12, nullable = false)
    private Date request;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "product_id") )
    private List<Permission> permissions;

    public Product_RequestEntity() {
    }

    public Product_RequestEntity(Integer product_id, Integer user_id, String detail, Date delivery, Date request) {
        super();
        this.product_id = product_id;
        this.user_id = user_id;
        this.detail = detail;
        this.delivery = delivery;
        this.request = request;
    }

    public Product_RequestEntity(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getUser_id() {
        return this.user_id;
    }

    public void setUser_id (Integer user_id) { this.user_id = user_id; }

    public Date getDelivery() { return this.delivery; }

    public void setDelivery(Date delivery) { this.delivery = delivery; }

    public Date getRequest() { return this.request; }

    public void setRequest(Date request) { this.request = request; }

}

