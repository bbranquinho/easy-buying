package org.wpattern.easy.buying.quotation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {

    public Quotation findByProduct_request_id (Integer product_request_id);

    public List<Quotation> findByProduct_request_idOr (Integer product_request_id, Integer supplier_id, Float unitary_price, Float total_price, Integer quantity);
}
