package org.wpattern.easy.buying.product_request;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface Product_RequestRepository extends JpaRepository<Product_Request, Long> {

    public Product_Request findByProduct_id (Integer product_id);

    public List<Product_Request> findByProduct_idOr (Integer product_id, Integer user_id, String detail, Date delivery, Date request);
}
