package org.wpattern.easy.buying.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.easy.buying.product.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName (String name);

    public List<Product> findByNameOr(String name, String description, Integer product_category_id);

}


