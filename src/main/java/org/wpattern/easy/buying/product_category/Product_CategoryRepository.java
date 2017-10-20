package org.wpattern.easy.buying.product_category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product_CategoryRepository extends JpaRepository<Product_Category, Long> {
    public Product_Category findByName (String name);

    public List<Product_Category> findByNameOr (String name);

}
