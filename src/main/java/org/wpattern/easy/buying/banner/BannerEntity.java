package org.wpattern.easy.buying.banner;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_banner")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class BannerEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 120)
    @Column(name = "message", length = 1024, nullable = false)
    private String message;


    @NotNull
    @Size(min = 8, max = 10)
    @Column(name = "expiration", length = 10, nullable = false)
    private Date expiration;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_supplier", joinColumns = @JoinColumn(name = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id") )
    private List<Permission> permissions;


    public BannerEntity() {
    }

    public BannerEntity(String message, Date expiration) {
        super();
        this.message = message;
        this.expiration = expiration;
    }


    public BannerEntity(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public void setDate(Date expiration) {
        this.expiration = expiration;
    }


}
