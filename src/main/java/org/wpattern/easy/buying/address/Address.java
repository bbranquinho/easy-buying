package org.wpattern.easy.buying.address;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_address")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Address extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "District_id", length = 10, nullable = false)
    private Integer district_id;


    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "Name", length = 255, nullable = false)
    private String name;

    @NotNull
    @Size(min = 3, max = 8)
    @Column(name = "Cep", length = 8, nullable = false)
    private String cep;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_id") )
    private List<Permission> permissions;


    public Address() {
    }

    public Address(Integer district_id, String name, String cep) {
        super();
        this.district_id = district_id;
        this.name = name;
        this.cep = cep;
    }


    public Address(Integer district_id) {
        this.district_id = district_id;
    }

    public Integer getDistrict_id() {
        return this.district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
