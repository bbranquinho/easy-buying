package org.wpattern.easy.buying.product_category;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_product_category")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Product_Category extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 45)
    @Column(name = "name", length = 45, nullable = false)
    private String name;

    public Product_Category() {
    }

   // public Product_Category(String name) {
   //     super();
   //     this.name = name;
    //}

    public Product_Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
