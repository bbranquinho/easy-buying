package org.wpattern.easy.buying.supplier_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.easy.buying.supplier_product.Supplier_Product;

import java.util.List;


public interface Supplier_ProductRepository extends JpaRepository<Supplier_Product, Long> {

    public Supplier_Product findBySupplier_id (Integer supplier_id);

    public List<Supplier_Product> findBySupplier_idOr(Integer supplier_id, Integer Product_id);
}
