package org.wpattern.easy.buying.city;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "tb_city")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class CityEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 3, max = 127)
    @Column(name = "Name", length = 127, nullable = false)
    private String name;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "State_id", length = 10, nullable = false)
    private Integer state_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_neighborhood", joinColumns = @JoinColumn(name = "neighborhood_id"), inverseJoinColumns = @JoinColumn(name = "neighborhood_id") )
    private List<Permission> permissions;


    public CityEntity() {
    }

    public CityEntity(String name, Integer state_id) {
        super();
        this.name = name;
        this.state_id = state_id;
    }


    public CityEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState_id() { return this.state_id; }

    public void setState_id(Integer state_id) { this.state_id = state_id; }

}
