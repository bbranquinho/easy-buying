package org.wpattern.easy.buying.state;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_state")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class State extends BaseEntity<Long> {

    @NotNull
    @Size(min = 1, max = 127)
    @Column(name = "name", length = 127, nullable = false)
    private String name;

    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "symbol", length = 5, nullable = false)
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
