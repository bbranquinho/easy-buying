package org.wpattern.easy.buying.product;

import org.wpattern.easy.buying.product_category.ProductCategory;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_product")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Product extends BaseEntity<Long>{

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_category", nullable = false)
    private ProductCategory productCategory;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
