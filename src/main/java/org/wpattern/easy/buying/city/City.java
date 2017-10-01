package org.wpattern.easy.buying.city;

import org.wpattern.easy.buying.state.State;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_city")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class City  extends BaseEntity<Long> {

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
