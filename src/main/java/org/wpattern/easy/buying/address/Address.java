package org.wpattern.easy.buying.address;

import org.wpattern.easy.buying.neighborhood.Neighborhood;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_address")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Address extends BaseEntity<Long> {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private Neighborhood neighborhood;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }
}
