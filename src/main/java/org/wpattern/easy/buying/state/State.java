package org.wpattern.easy.buying.state;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "tb_state")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class State extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 3, max = 127)
    @Column(name = "Name", length = 127, nullable = false)
    private String name;

    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Symbol", length = 5, nullable = false)
    private String symbol;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_city", joinColumns = @JoinColumn(name = "city_id"), inverseJoinColumns = @JoinColumn(name = "city_id") )
    private List<Permission> permissions;


    public State() {
    }

    public State(String name, String symbol) {
        super();
        this.name = name;
        this.symbol = symbol;
    }


    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() { return this.symbol; }

    public void setSymbol(String symbol) { this.symbol = symbol; }

}
