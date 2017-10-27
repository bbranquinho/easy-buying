package org.wpattern.easy.buying.neighborhood;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_neighborhood")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Neighborhood extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 3, max = 127)
    @Column(name = "Name", length = 127, nullable = false)
    private String name;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "City_id", length = 10, nullable = false)
    private Integer city_id;

    public Neighborhood() {
    }

    public Neighborhood(String name, Integer city_id) {
        super();
        this.name = name;
        this.city_id = city_id;
    }


    public Neighborhood(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCity_id() { return this.city_id; }

    public void setCity_id(Integer city_id) { this.city_id = city_id; }

}
