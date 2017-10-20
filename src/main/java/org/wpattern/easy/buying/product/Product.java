package org.wpattern.easy.buying.product;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_product")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Product extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 127)
    @Column(name = "name", length = 127, nullable = false)
    private String name;

    @NotNull
    @Size(min = 4, max = 255)
    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @NotNull
    @Size(min = 8, max = 10)
    @Column(name = "product_category_id", length = 10, nullable = false)
    private Integer product_Category;


    public Product() {
    }

    public Product(String name, String description, Integer Product_Category) {
        super();
        this.name = name;
        this.description = description;
        this.product_Category = product_Category;
    }

    public Product(String name) {
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

    public Integer getProduct_Category() {
        return this.product_Category;
    }

    public void setProduct_Category(Integer product_Category) {
        this.product_Category = product_Category;
    }


}
