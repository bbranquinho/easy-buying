package org.wpattern.easy.buying.supplier;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tb_supplier")
@AttributeOverride(name = "id", column = @Column (name = "pk_id"))
public class Supplier extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 127)
    @Column(name = "name", length = 127, nullable = false)
    private String name;

    @NotNull
    @Size(min = 4, max = 127)
    @Column(name = "description", length = 127, nullable = false)
    private String description;

    @NotNull
    @Size(min = 8, max = 10)
    @Column(name = "register_date", length = 10, nullable = false)
    private Date register_Date;


    public Supplier() {
    }

    public Supplier(String name, String description, Date register_Date) {
        super();
        this.name = name;
        this.description = description;
        this.register_Date = register_Date;
    }

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescriptiom (String description) { this.description = description; }

    public Date getregister_Date() {
        return this.register_Date;
    }

    public void setDate(Date register_Date) {
        this.register_Date = register_Date;
    }


}
