package org.wpattern.easy.buying.productrequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.wpattern.easy.buying.product.Product;
import org.wpattern.easy.buying.user.User;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_product_request")
@AttributeOverride(name = "id", column = @Column(name ="id"))
public class ProductRequest extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="detail")
    private String detail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    @Column(name="delivery")
    private Date delivery;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    @Column(name="request")
    private Date request;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public Date getRequest() {
        return request;
    }

    public void setRequest(Date request) {
        this.request = request;
    }
}
