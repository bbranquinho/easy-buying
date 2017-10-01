package org.wpattern.easy.buying.neighborhood;

import org.wpattern.easy.buying.city.City;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_neighborhood")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Neighborhood extends BaseEntity<Long> {

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "cuty_id", nullable = false)
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
